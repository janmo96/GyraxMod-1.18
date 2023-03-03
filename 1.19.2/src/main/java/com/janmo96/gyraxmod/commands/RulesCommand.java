package com.janmo96.gyraxmod.commands;

import com.janmo96.gyraxmod.GyraxMod;
import com.janmo96.gyraxmod.config.GyraxModCommonConfigs;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;

public class RulesCommand {

    public RulesCommand(CommandDispatcher<CommandSourceStack> dispatcher){
        if(GyraxModCommonConfigs.RulesEnabled.get()) {

        dispatcher.register(Commands.literal("rules").executes((command) -> {
            return Rules(command.getSource());
        }));

        }
    }

    private int Rules(CommandSourceStack source) throws CommandSyntaxException
    {
        for (String s : GyraxMod.RulesText){
            source.getEntity().sendSystemMessage(Component.literal(s));
        }
        return 1;
    }


}
