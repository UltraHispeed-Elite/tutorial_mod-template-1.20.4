package net.matt.tutorialmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.matt.tutorialmod.Tutorial_mod;
import net.matt.tutorialmod.item.custom.MetalDetectorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));
    public static final Item RAW_RUBY = registerItem("raw_ruby", new Item(new FabricItemSettings()));
    public static final Item METAL_DETECTOR = registerItem("metal_detector",
            new MetalDetectorItem(new FabricItemSettings().maxDamage(64)));

    public static final Item TOMATO = registerItem("tomato", new Item(new FabricItemSettings().food(ModFoodComponents.TOMATO)));
    public static final Item COAL_BRIQUETTE = registerItem("coal_briquette",
            new Item(new FabricItemSettings()));

    public static final Item RUBY_STAFF = registerItem("ruby_staff",
            new Item(new FabricItemSettings().maxCount(1)));


    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries) {
//        entries.add(RUBY);
//        entries.add(RAW_RUBY);
    }
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Tutorial_mod.MOD_ID, name), item);
    }
    public static void registerModItems() {
        Tutorial_mod.LOGGER.info("Registering Mod Items for " + Tutorial_mod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
    }
}
