package com.mrbysco.cobblegenhaters;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod("cobblegenhaters")
public class CobbleGenHaters {
	public static final Tag.Named<Block> ALLOWED_BLOCKS = BlockTags.bind("cobblegenhaters:" + "allowed_blocks");

	public CobbleGenHaters() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent(priority = EventPriority.HIGH)
	public void blockPlaceEvent(final BlockEvent.FluidPlaceBlockEvent event) {
		BlockState state = event.getNewState();
		if(!state.is(ALLOWED_BLOCKS)) {
			event.setNewState(event.getOriginalState());
		}
	}
}
