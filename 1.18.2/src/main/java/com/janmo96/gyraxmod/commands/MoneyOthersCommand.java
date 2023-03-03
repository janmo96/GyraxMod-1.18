package com.janmo96.gyraxmod.commands;

import com.janmo96.gyraxmod.Utils.ColorChecker;
import com.janmo96.gyraxmod.config.GyraxModCommonConfigs;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.Util;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.accesstransformer.generated.AtParser;


public class MoneyOthersCommand
{
    private int money;

    public MoneyOthersCommand(CommandDispatcher<CommandSourceStack> dispatcher)
    {
        dispatcher.register(Commands.literal("money").then(Commands.argument("target_player", EntityArgument.player())).executes((command) -> {
            return  MoneyOther(command.getSource(), EntityArgument.getPlayer(command, "target_player"));
        }));
    }

    public int MoneyOther(CommandSourceStack source, Player target) throws CommandSyntaxException
    {

        money = source.getEntity().getPersistentData().getInt("Money");
        String moneyText = "Player: " + target.getGameProfile().getName() + " Has " + target.getPersistentData().getInt("Money") + "$";
       // moneyText = moneyText.replace("{amount}", String.valueOf(money));
        TextComponent mText = new TextComponent(moneyText);

        source.getEntity().sendMessage(mText, Util.NIL_UUID);

        return 1;
    }
}
