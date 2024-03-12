package net.matt.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.matt.tutorialmod.block.ModBlocks;
import net.matt.tutorialmod.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> RUBY_SMELTABLES = List.of(ModItems.RAW_RUBY, ModBlocks.RUBY_ORE,
            ModBlocks.DEEPSLATE_RUBY_ORE, ModBlocks.NETHER_RUBY_ORE, ModBlocks.END_RUBY_ORE);
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerSmelting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY,
                0.7F, 200, "ruby");
        offerBlasting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY,
                0.7F, 100, "ruby");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RUBY,
                RecipeCategory.DECORATIONS, ModBlocks.RUBY_BLOCK);

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_RUBY,
                RecipeCategory.DECORATIONS, ModBlocks.RAW_RUBY_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_RUBY, 1)
                .pattern("SSS")
                .pattern("SRS")
                .pattern("SSS")
                .input('S', Items.STONE)
                .input('R', ModItems.RUBY)
                .criterion(hasItem(Items.STONE), conditionsFromItem(Items.STONE))
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RAW_RUBY)));

        createStairsRecipe(ModBlocks.RUBY_STAIRS, Ingredient.ofItems(ModBlocks.RUBY_BLOCK));
        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS,ModBlocks.RUBY_SLAB, Ingredient.ofItems(ModBlocks.RUBY_BLOCK));
        offerSingleOutputShapelessRecipe(exporter, ModBlocks.RUBY_BUTTON, ModBlocks.RUBY_BLOCK, "ruby");
        createPressurePlateRecipe(RecipeCategory.MISC,ModBlocks.RUBY_PRESSURE_PLATE, Ingredient.ofItems(ModBlocks.RUBY_BLOCK));
        createFenceRecipe(ModBlocks.RUBY_FENCE, Ingredient.ofItems(ModBlocks.RUBY_BLOCK));
        createFenceGateRecipe(ModBlocks.RUBY_FENCE_GATE, Ingredient.ofItems(ModBlocks.RUBY_BLOCK));
        offerWallRecipe(exporter, RecipeCategory.MISC, ModBlocks.RUBY_STAIRS, ModBlocks.RUBY_BLOCK);
        createDoorRecipe(ModBlocks.RUBY_DOOR, Ingredient.ofItems(ModBlocks.RUBY_BLOCK));
        createTrapdoorRecipe(ModBlocks.RUBY_TRAPDOOR, Ingredient.ofItems(ModBlocks.RUBY_BLOCK));
    }
}
