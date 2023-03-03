package com.janmo96.gyraxmod;

import com.janmo96.gyraxmod.Utils.ColorChecker;
import com.janmo96.gyraxmod.config.GyraxModCommonConfigs;
import com.janmo96.gyraxmod.rules.LoadRules;
import com.mojang.logging.LogUtils;

import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.IExtensionPoint;

import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.network.NetworkConstants;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(GyraxMod.MOD_ID)
public class GyraxMod
{
    public static List<String> RulesText;
    public static List<String> McColors;
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "gyraxmod";

    public GyraxMod()
    {

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, GyraxModCommonConfigs.SPEC, "Gyrax/gyraxmod-common.toml");
        ModLoadingContext.get().registerExtensionPoint(IExtensionPoint.DisplayTest.class, () -> new IExtensionPoint.DisplayTest(() -> NetworkConstants.IGNORESERVERONLY, (a, b) -> true));
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        McColors = ColorChecker.getMcColors();
try {
            Path p = Paths.get(FMLPaths.CONFIGDIR.get() + "/Gyrax");

        if(!Files.isDirectory(p)) {
            Files.createDirectory(p);
            System.out.println("Gyrax Folder Created");
        } else {
           System.out.println("Gyrax Folder Exists: " + Files.exists(Paths.get(p.toUri())));
        }

} catch (Exception e) {
    e.printStackTrace();
}

    LoadRules.Init();


    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {



        // Do something when the server starts
        LOGGER.info("Gyrax Server Mod Loaded");
    }

}
