package com.janmo96.gyraxmod.commands;

import com.janmo96.gyraxmod.Utils.ColorChecker;
import com.janmo96.gyraxmod.config.GyraxModCommonConfigs;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.Util;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.TextComponent;

public class IpCommand
{
    public IpCommand(CommandDispatcher<CommandSourceStack> dispatcher)
    {
        dispatcher.register(Commands.literal("gyrax").then(Commands.literal("ip").executes((command) -> Ip(command.getSource()))));
    }

    public int Ip(CommandSourceStack source) {
        TextComponent mText = new TextComponent(ColorChecker.TextColorChecker(GyraxModCommonConfigs.IpMessage.get()));
        source.getEntity().sendMessage(mText, Util.NIL_UUID);

        return 1;
    }



}
