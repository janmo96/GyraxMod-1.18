package com.janmo96.gyraxmod.Events;

import com.janmo96.gyraxmod.GyraxMod;
import com.janmo96.gyraxmod.commands.*;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GyraxMod.MOD_ID)
public class ModEvents
{
    @SubscribeEvent
    public static void onCommandsRegister(RegisterCommandsEvent event){
        new RulesCommand(event.getDispatcher());
        new RulesReloadCommand(event.getDispatcher());
        new IpCommand(event.getDispatcher());
        new MoneyCommand(event.getDispatcher());
      //  new MoneyOthersCommand(event.getDispatcher());



    }
}
