package com.janmo96.gyraxmod.Events;

import com.janmo96.gyraxmod.GyraxMod;
import com.janmo96.gyraxmod.Utils.ColorChecker;
import com.janmo96.gyraxmod.config.GyraxModCommonConfigs;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GyraxMod.MOD_ID)
public class ServerChatHandler
{



    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void ServerChat(ServerChatEvent event) {


    }

    @SubscribeEvent
    public static void OnPlayerDisconnect(PlayerEvent.PlayerLoggedOutEvent event)
    {
        
        if(!event.getEntity().getPersistentData().getBoolean("Joinedbefore") || !event.getEntity().getPersistentData().contains("JoinedBefore")){
            event.getEntity().getPersistentData().putBoolean("JoinedBefore", true);
        }

        System.out.println("Player Left Event Result: " + event.getResult());


        if(event.getEntity().getServer().getPlayerList().getPlayers().size() > 1) {
            for (int i = 0; i < event.getEntity().getServer().getPlayerList().getPlayers().size(); i++)
            {

                String LeavingMessage = (ColorChecker.TextColorChecker(GyraxModCommonConfigs.LeaveMessage.get()));
                LeavingMessage = LeavingMessage.replace("{username}", event.getEntity().getGameProfile().getName());

              //  TextComponent text = new TextComponent(LeavingMessage);
                //event.getEntity().getServer().getPlayerList().getPlayers().get(i).sendMessage(text, event.getEntity().getServer().getPlayerList().getPlayers().get(i).getUUID());
                event.getEntity().getServer().getPlayerList().getPlayers().get(i).sendSystemMessage(Component.literal(LeavingMessage));
            }
        }else if(event.getEntity().getServer().getPlayerList().getPlayers().size() <= 1)
        {
            String LeavingMessage = (ColorChecker.TextColorChecker(GyraxModCommonConfigs.LeaveMessage.get()));
            LeavingMessage = LeavingMessage.replace("{username}", event.getEntity().getGameProfile().getName());

            event.getEntity().sendSystemMessage(Component.literal(LeavingMessage));
        }

        }

    @SubscribeEvent
    public static void OnPlayerJoin(PlayerEvent.PlayerLoggedInEvent event )
    {
      //  System.out.println("Player Joined Before = " + event.getEntity().getPersistentData().contains("JoinedBefore"));

        if(event.getEntity().getPersistentData().getBoolean("JoinedBefore") || event.getEntity().getPersistentData().contains("JoinedBefore"))
        {


            String WelcomeBackMessage = (ColorChecker.TextColorChecker(GyraxModCommonConfigs.WelcomeBackMessage.get()));
            WelcomeBackMessage =  WelcomeBackMessage.replace("{username}", event.getEntity().getGameProfile().getName());


          //  TextComponent text = new TextComponent(WelcomeBackMessage);
            SentJoinMessage(event, Component.literal(WelcomeBackMessage));
        } else if(event.getEntity().getPersistentData().getBoolean("JoinedBefore") == false || !event.getEntity().getPersistentData().contains("JoinedBefore") && !event.getEntity().getPersistentData().getBoolean("JoinedBefore") || !event.getEntity().getPersistentData().contains("JoinedBefore")) {

            String WelcomeMessage = (ColorChecker.TextColorChecker(GyraxModCommonConfigs.WelcomeMessage.get()));
            event.getEntity().getPersistentData().putBoolean("JoinedBefore", true);
          //  System.out.println("Player Joined Before Set To = True");
            WelcomeMessage = WelcomeMessage.replace("{username}", event.getEntity().getGameProfile().getName());
            //TextComponent text = new TextComponent(WelcomeMessage);

            SentJoinMessage(event, Component.literal(WelcomeMessage));
        }

    }


    public static void SentJoinMessage(PlayerEvent.PlayerLoggedInEvent event, MutableComponent text)
{
    if(event.getEntity().getServer().getPlayerList().getPlayers().size() > 1) {
        for (int i = 0; i < event.getEntity().getServer().getPlayerList().getPlayers().size(); i++)
        {
            event.getEntity().getServer().getPlayerList().getPlayers().get(i).sendSystemMessage(text);
        }
    }else if(event.getEntity().getServer().getPlayerList().getPlayers().size() <= 1)
    {
        event.getEntity().sendSystemMessage(text);
    }

}

}
