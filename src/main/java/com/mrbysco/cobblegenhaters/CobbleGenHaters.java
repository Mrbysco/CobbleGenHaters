package com.mrbysco.cobblegenhaters;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod("cobblegenhaters")
public class CobbleGenHaters {
	public static final TagKey<Block> ALLOWED_BLOCKS = BlockTags.create(new ResourceLocation("cobblegenhaters", "allowed_blocks"));

	public CobbleGenHaters() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent(priority = EventPriority.HIGH)
	public void blockPlaceEvent(final BlockEvent.FluidPlaceBlockEvent event) {
		BlockState state = event.getNewState();
		if (!state.is(ALLOWED_BLOCKS)) {
			event.setNewState(event.getOriginalState());
		}
	}
}
