package com.Mrbysco.CobbleGenHaters.Handlers;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HaterHandler {

	@SubscribeEvent(priority = EventPriority.HIGH)
	public void dontPlaceStone(BlockEvent.FluidPlaceBlockEvent event)
	{
		IBlockState state = event.getNewState();
		if(state.getBlock() != Blocks.OBSIDIAN)
		{
			event.setNewState(event.getOriginalState());
			event.setCanceled(true);
		}
	}
}
