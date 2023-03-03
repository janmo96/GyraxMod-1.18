package com.janmo96.gyraxmod.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class GyraxModCommonConfigs
{
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;


    public static final ForgeConfigSpec.ConfigValue<Boolean> RulesEnabled;
    public static final ForgeConfigSpec.ConfigValue<String> WelcomeMessage;
    public static final ForgeConfigSpec.ConfigValue<String> WelcomeBackMessage;
    public static final ForgeConfigSpec.ConfigValue<String> LeaveMessage;
    public static final ForgeConfigSpec.ConfigValue<String> IpMessage;

    static {
        BUILDER.push("Configs For Gyrax Mod");

        RulesEnabled = BUILDER.comment("Rules Command Enabled On Server")
                .define("RulesEnabled:", true);

        WelcomeMessage = BUILDER.comment("First Join Message Sent To Server")
                .define("Welcome Message:", "&bWelcome &a{username} &bTo The Server");

        WelcomeBackMessage = BUILDER.comment("Welcome Back Message Sent To Server")
                .define("Welcome Back Message:", "&bWelcome Back &a{username} &bTo The Server");

        LeaveMessage = BUILDER.comment("Leaving Message Sent To Server")
                .define("LeavingMessage:", "&bPlayer &a{username} &bLeft From Server");

        IpMessage = BUILDER.comment("Message Sent To Player From IP Command")
                .define("IP Message:", "&5Server IP = &bgyrax.net");
        //Here Define Configs

        BUILDER.pop();
        SPEC = BUILDER.build();
    }

}
