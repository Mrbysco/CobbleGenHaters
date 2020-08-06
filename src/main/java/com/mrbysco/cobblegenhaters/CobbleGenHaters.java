package com.mrbysco.cobblegenhaters;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("cobblegenhaters")
public class CobbleGenHaters {
	public static final ITag.INamedTag<Block> ALLOWED_BLOCKS = BlockTags.makeWrapperTag("cobblegenhaters:" + "allowed_blocks");

	public CobbleGenHaters() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent(priority = EventPriority.HIGH)
	public void blockPlaceEvent(final BlockEvent.FluidPlaceBlockEvent event) {
		BlockState state = event.getNewState();
		if(!ALLOWED_BLOCKS.contains(state.getBlock())) {
			event.setNewState(event.getOriginalState());
		}
	}
}
