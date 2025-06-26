package com.wdcftgg.inertiacancellation;

import com.wdcftgg.inertiacancellation.init.RegistryHandler;
import com.wdcftgg.inertiacancellation.network.PacketHandler;
import com.wdcftgg.inertiacancellation.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = InertiaCancellation.MODID, name = InertiaCancellation.NAME, version = InertiaCancellation.VERSION)
public class InertiaCancellation {
    public static final String MODID = "inertiacancellation";
    public static final String NAME = "InertiaCancellation";
    public static final String VERSION = "1.0.0";
    public static Logger logger;

    @Mod.Instance
    public static InertiaCancellation instance;

    public static final String CLIENT_PROXY_CLASS = "com.wdcftgg.inertiacancellation.proxy.ClientProxy";
    public static final String SERVER_PROXY_CLASS = "com.wdcftgg.inertiacancellation.proxy.CommonProxy";

    @SidedProxy(clientSide = CLIENT_PROXY_CLASS, serverSide = SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();

        proxy.onPreInit();

        RegistryHandler.preInitRegistries(event);

    }


    @Mod.EventHandler
    public static void Init(FMLInitializationEvent event) {
        proxy.onInit();

        PacketHandler.init();

        RegistryHandler.InitReg();

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.onPostInit();

        RegistryHandler.postInitReg();
    }


    @Mod.EventHandler
    public static void serverInit(FMLServerStartingEvent event) {
        RegistryHandler.serverRegistries(event);
    }

    public static void LogWarning(String str, Object... args) {
        logger.warn(String.format(str, args));
    }

    public static void LogWarning(String str) {
        logger.warn(str);
    }

    public static void Log(String str) {
        logger.info(str);
    }

    public static void Log(String str, Object... args) {
        logger.info(String.format(str, args));
    }
}
