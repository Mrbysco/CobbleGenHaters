package com.mrbysco.cobblegenhaters;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("cobblegenhaters")
public class CobbleGenHaters {
	public static final Logger LOGGER = LogManager.getLogger();

	public CobbleGenHaters() {

	}

	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class HaterHandler {
		@SubscribeEvent(priority = EventPriority.HIGH)
		public static void onBlocksRegistry(final BlockEvent.FluidPlaceBlockEvent event) {
			BlockState state = event.getNewState();
			if(state.getBlock() != Blocks.OBSIDIAN)
			{
				LOGGER.info(state);
				event.setNewState(event.getOriginalState());
			}
		}
	}
}
