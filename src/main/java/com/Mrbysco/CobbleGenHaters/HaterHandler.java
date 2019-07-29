package com.mrbysco.cobblegenhaters;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "cobblegenhaters", bus = Mod.EventBusSubscriber.Bus.MOD)
public class HaterHandler {
	@SubscribeEvent(priority = EventPriority.HIGH)
	public static void onBlocksRegistry(final BlockEvent.FluidPlaceBlockEvent event) {
		CobbleGenHaters.LOGGER.info("Trigger");
		BlockState state = event.getNewState();
		if(state.getBlock() != Blocks.OBSIDIAN)
		{
			CobbleGenHaters.LOGGER.info(state);
			event.setNewState(event.getOriginalState());
		}
	}
}
