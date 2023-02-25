package com.janmo96.gyraxmod.commands;

import com.janmo96.gyraxmod.Utils.ColorChecker;
import com.janmo96.gyraxmod.Utils.ReplaceText;
import com.janmo96.gyraxmod.config.GyraxModCommonConfigs;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.Util;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.TextComponent;

public class MoneyCommand
{
    private int money;

    public MoneyCommand(CommandDispatcher<CommandSourceStack> dispatcher)
    {
        dispatcher.register(Commands.literal("money").executes((command) -> {
            return  MoneyReturn(command.getSource());
        }));
    }

    public int MoneyReturn(CommandSourceStack source) throws CommandSyntaxException
    {
        money = source.getEntity().getPersistentData().getInt("Money");
        String moneyText = ColorChecker.TextColorChecker(GyraxModCommonConfigs.MoneyText.get());
        String moneyToString = String.valueOf(money);
        moneyText = moneyText.replace("{amount}", moneyToString);
        TextComponent mText = new TextComponent(moneyText);
        System.out.println("moneyTextModified to = " + moneyText);
        source.getEntity().sendMessage(mText, Util.NIL_UUID);

        return 1;
    }

}
