package net.matt.tutorialmod;

import net.fabricmc.api.ModInitializer;

import net.matt.tutorialmod.block.ModBlocks;
import net.matt.tutorialmod.item.ModItemGroups;
import net.matt.tutorialmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tutorial_mod implements ModInitializer {
	public static final String MOD_ID = "tutorial_mod";
    public static final Logger LOGGER = LoggerFactory.getLogger("MOD_ID");

	@Override
	public void onInitialize() {

		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();

		ModBlocks.registerModBlocks();

	}
}