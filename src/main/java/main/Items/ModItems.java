package main.Items;

import main.Blocks.ModBlocks;
import main.Main;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static DeferredRegister.Items ITEMS = DeferredRegister.createItems(Main.MODID);
    public static DeferredItem<BlockItem> CORRUPTED_GRASS_GREED_ITEM = ITEMS.registerSimpleBlockItem(ModBlocks.CORRUPTED_GRASS_GREED);
    public static DeferredItem<BlockItem> CORRUPTED_GRASS_LUST_ITEM = ITEMS.registerSimpleBlockItem(ModBlocks.CORRUPTED_GRASS_LUST);
    public static DeferredItem<BlockItem> CORRUPTED_GRASS_GLUTTONY_ITEM = ITEMS.registerSimpleBlockItem(ModBlocks.CORRUPTED_GRASS_GLUTTONY);
    public static DeferredItem<BlockItem> CORRUPTED_GRASS_SLOTH_ITEM = ITEMS.registerSimpleBlockItem(ModBlocks.CORRUPTED_GRASS_SLOTH);
    public static DeferredItem<BlockItem> CORRUPTED_GRASS_WRATH_ITEM = ITEMS.registerSimpleBlockItem(ModBlocks.CORRUPTED_GRASS_WRATH);
    public static DeferredItem<BlockItem> CORRUPTED_GRASS_PRIDE_ITEM = ITEMS.registerSimpleBlockItem(ModBlocks.CORRUPTED_GRASS_PRIDE);
    public static DeferredItem<BlockItem> CORRUPTED_GRASS_ENVY_ITEM = ITEMS.registerSimpleBlockItem(ModBlocks.CORRUPTED_GRASS_ENVY);
    public static DeferredItem<BlockItem> FLESH_BLOCK_ITEM = ITEMS.registerSimpleBlockItem(ModBlocks.FLESH_BLOCK);
    public static DeferredItem<BlockItem> CANDLE_ENVY_ITEM = ITEMS.registerSimpleBlockItem(ModBlocks.CANDLE_ENVY);
    public static DeferredItem<BlockItem> CANDLE_GLUTTONY_ITEM = ITEMS.registerSimpleBlockItem(ModBlocks.CANDLE_GLUTTONY);
    public static DeferredItem<BlockItem> CANDLE_PRIDE_ITEM = ITEMS.registerSimpleBlockItem(ModBlocks.CANDLE_PRIDE);
    public static DeferredItem<BlockItem> CANDLE_LUST_ITEM = ITEMS.registerSimpleBlockItem(ModBlocks.CANDLE_LUST);
    public static DeferredItem<BlockItem> CANDLE_WRATH_ITEM = ITEMS.registerSimpleBlockItem(ModBlocks.CANDLE_WRATH);
    public static DeferredItem<BlockItem> CANDLE_SLOTH_ITEM = ITEMS.registerSimpleBlockItem(ModBlocks.CANDLE_SLOTH);
    public static DeferredItem<BlockItem> CANDLE_GREED_ITEM = ITEMS.registerSimpleBlockItem(ModBlocks.CANDLE_GREED);
    public static DeferredItem<RuinedPaper> RUINED_PAPER = ITEMS.register("ruined_page",properties -> new RuinedPaper(new Item.Properties()) );
    public static DeferredItem<BlockItem> ALTAR_BLOCK_ITEM = ITEMS.registerSimpleBlockItem(ModBlocks.Altar_BLOCK);

    public void register(IEventBus iEventBus){
        ITEMS.register(iEventBus);
    }
}
