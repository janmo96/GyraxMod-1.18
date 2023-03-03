package com.janmo96.gyraxmod.commands;

import com.janmo96.gyraxmod.Utils.ColorChecker;
import com.janmo96.gyraxmod.config.GyraxModCommonConfigs;
import com.janmo96.gyraxmod.rules.LoadRules;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.TextComponent;

public class RulesReloadCommand
{
    public RulesReloadCommand(CommandDispatcher<CommandSourceStack> dispatcher){
        if(GyraxModCommonConfigs.RulesEnabled.get()){
            dispatcher.register(Commands.literal("rules").then(Commands.literal("reload").requires(source -> source.hasPermission(4)).executes(command ->  {
            return RulesReload(command.getSource());
            })));
        }
    }


    private int RulesReload(CommandSourceStack source) throws CommandSyntaxException{

        LoadRules.Init();
        TextComponent text = new TextComponent(ColorChecker.TextColorChecker("&cRules Reloaded!"));
        source.getEntity().sendMessage(text, source.getEntity().getUUID());
        return 1;
    }

}
