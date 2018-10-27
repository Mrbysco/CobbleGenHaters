package com.Mrbysco.CobbleGenHaters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.Mrbysco.CobbleGenHaters.Handlers.HaterHandler;
import com.Mrbysco.CobbleGenHaters.Proxy.CommonProxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, 
	name = Reference.MOD_NAME, 
	version = Reference.VERSION, 
	acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS,
	dependencies = Reference.DEPENDENCIES)

public class CobbleGenHaters {
	@Instance(Reference.MOD_ID)
	public static CobbleGenHaters instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static final Logger logger = LogManager.getLogger(Reference.MOD_ID);
			
	@EventHandler
	public void PreInit(FMLPreInitializationEvent event)
	{
		proxy.PreInit();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		logger.info("Registering Cobble Gen Hating handler");
		MinecraftForge.EVENT_BUS.register(new HaterHandler());
		
		proxy.Init();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		proxy.PostInit();
	}
}