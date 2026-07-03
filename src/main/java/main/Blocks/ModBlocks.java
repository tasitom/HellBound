package main.Blocks;

import main.Main;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;


public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Main.MODID);
    public static final DeferredBlock<CorruptedBlocks> CORRUPTED_GRASS_PRIDE = BLOCKS.registerBlock("corrupted_grass_pride",CorruptedBlocks::new);
    public static final DeferredBlock<CorruptedBlocks> CORRUPTED_GRASS_ENVY = BLOCKS.registerBlock("corrupted_grass_envy",CorruptedBlocks::new);
    public static final DeferredBlock<CorruptedBlocks> CORRUPTED_GRASS_SLOTH = BLOCKS.registerBlock("corrupted_grass_sloth",CorruptedBlocks::new);
    public static final DeferredBlock<CorruptedBlocks> CORRUPTED_GRASS_WRATH = BLOCKS.registerBlock("corrupted_grass_wrath",CorruptedBlocks::new);
    public static final DeferredBlock<CorruptedBlocks> CORRUPTED_GRASS_GREED = BLOCKS.registerBlock("corrupted_grass_greed",CorruptedBlocks::new);
    public static final DeferredBlock<CorruptedBlocks> CORRUPTED_GRASS_LUST = BLOCKS.registerBlock("corrupted_grass_lust",CorruptedBlocks::new);
    public static final DeferredBlock<CorruptedBlocks> CORRUPTED_GRASS_GLUTTONY = BLOCKS.registerBlock("corrupted_grass_gluttony",CorruptedBlocks::new);


    public void register(IEventBus iEventBus){
        BLOCKS.register(iEventBus);
    }
}
