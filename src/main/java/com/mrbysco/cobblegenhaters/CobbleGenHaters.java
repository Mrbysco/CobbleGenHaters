package com.mrbysco.cobblegenhaters;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.level.BlockEvent;

@Mod("cobblegenhaters")
public class CobbleGenHaters {
	public static final TagKey<Block> ALLOWED_BLOCKS = BlockTags.create(new ResourceLocation("cobblegenhaters", "allowed_blocks"));

	public CobbleGenHaters() {
		NeoForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent(priority = EventPriority.HIGH)
	public void blockPlaceEvent(final BlockEvent.FluidPlaceBlockEvent event) {
		BlockState state = event.getNewState();
		if (!state.is(ALLOWED_BLOCKS)) {
			event.setNewState(event.getOriginalState());
		}
	}
}
