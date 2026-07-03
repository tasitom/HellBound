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



    public void register(IEventBus iEventBus){
        ITEMS.register(iEventBus);
    }
}
