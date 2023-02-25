package com.janmo96.gyraxmod.Events;

import com.janmo96.gyraxmod.GyraxMod;
import com.janmo96.gyraxmod.Utils.ColorChecker;
import com.janmo96.gyraxmod.config.GyraxModCommonConfigs;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerPlayer;
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
        if(!event.getPlayer().getPersistentData().getBoolean("Joinedbefore") || !event.getPlayer().getPersistentData().contains("JoinedBefore")){
            event.getPlayer().getPersistentData().putBoolean("JoinedBefore", true);
        }

        System.out.println("Player Left Event Result: " + event.getResult());


        if(event.getPlayer().getServer().getPlayerList().getPlayers().size() > 1) {
            for (int i = 0; i < event.getPlayer().getServer().getPlayerList().getPlayers().size(); i++)
            {

                String LeavingMessage = (ColorChecker.TextColorChecker(GyraxModCommonConfigs.LeaveMessage.get()));
                LeavingMessage = LeavingMessage.replace("{username}", event.getPlayer().getGameProfile().getName());

                TextComponent text = new TextComponent(LeavingMessage);
                event.getPlayer().getServer().getPlayerList().getPlayers().get(i).sendMessage(text, event.getPlayer().getServer().getPlayerList().getPlayers().get(i).getUUID());
            }
        }else if(event.getPlayer().getServer().getPlayerList().getPlayers().size() <= 1)
        {
            String LeavingMessage = (ColorChecker.TextColorChecker(GyraxModCommonConfigs.LeaveMessage.get()));
            LeavingMessage = LeavingMessage.replace("{username}", event.getPlayer().getGameProfile().getName());

            TextComponent text = new TextComponent(LeavingMessage);
            event.getPlayer().sendMessage(text, event.getPlayer().getUUID());
        }

        }

    @SubscribeEvent
    public static void OnPlayerJoin(PlayerEvent.PlayerLoggedInEvent event )
    {
      //  System.out.println("Player Joined Before = " + event.getPlayer().getPersistentData().contains("JoinedBefore"));

        if(event.getPlayer().getPersistentData().getBoolean("JoinedBefore") || event.getPlayer().getPersistentData().contains("JoinedBefore")){
            if(!event.getPlayer().getPersistentData().contains("Money") || !event.getPlayer().getPersistentData().contains("Money") || event.getPlayer().getPersistentData().getInt("Money") < 0){
                SetMoneyValue(event.getPlayer());
                System.out.println("Player Didnt Have Money Set");
            } else if(event.getPlayer().getPersistentData().contains("Money")) {
                System.out.println("Player Did Have Money Set Which is : " + event.getPlayer().getPersistentData().getInt("Money"));
            }

            String WelcomeBackMessage = (ColorChecker.TextColorChecker(GyraxModCommonConfigs.WelcomeBackMessage.get()));
            WelcomeBackMessage =  WelcomeBackMessage.replace("{username}", event.getPlayer().getGameProfile().getName());
            TextComponent text = new TextComponent(WelcomeBackMessage);
            SentJoinMessage(event, text);
        } else if(event.getPlayer().getPersistentData().getBoolean("JoinedBefore") == false || !event.getPlayer().getPersistentData().contains("JoinedBefore") && !event.getPlayer().getPersistentData().getBoolean("JoinedBefore") || !event.getPlayer().getPersistentData().contains("JoinedBefore")) {
            if(!event.getPlayer().getPersistentData().contains("Money") || !event.getPlayer().getPersistentData().contains("Money") || event.getPlayer().getPersistentData().getInt("Money") < 0){
                SetMoneyValue(event.getPlayer());
            }

            String WelcomeMessage = (ColorChecker.TextColorChecker(GyraxModCommonConfigs.WelcomeMessage.get()));
            event.getPlayer().getPersistentData().putBoolean("JoinedBefore", true);
          //  System.out.println("Player Joined Before Set To = True");
            WelcomeMessage = WelcomeMessage.replace("{username}", event.getPlayer().getGameProfile().getName());
            TextComponent text = new TextComponent(WelcomeMessage);

            SentJoinMessage(event, text);
        }

    }


    public static void SentJoinMessage(PlayerEvent.PlayerLoggedInEvent event, TextComponent text)
{
    if(event.getPlayer().getServer().getPlayerList().getPlayers().size() > 1) {
        for (int i = 0; i < event.getPlayer().getServer().getPlayerList().getPlayers().size(); i++)
        {
            event.getPlayer().getServer().getPlayerList().getPlayers().get(i).sendMessage(text, event.getPlayer().getServer().getPlayerList().getPlayers().get(i).getUUID());
        }
    }else if(event.getPlayer().getServer().getPlayerList().getPlayers().size() <= 1)
    {
        event.getPlayer().sendMessage(text, event.getPlayer().getUUID());
    }

}

public static void SetMoneyValue(Player player) {
        player.getPersistentData().putInt("Money", GyraxModCommonConfigs.DefaultMoneyValue.get());
        System.out.println("Money Set For " + player.getGameProfile().getName());
}



}
