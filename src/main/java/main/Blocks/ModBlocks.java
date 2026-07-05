package main.Blocks;

import main.Main;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;


public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Main.MODID);
    public static final DeferredBlock<CorruptedBlocks> CORRUPTED_GRASS_PRIDE = BLOCKS.registerBlock("corrupted_grass_pride",properties -> new CorruptedBlocks(BlockBehaviour.Properties.of().destroyTime(2).randomTicks()));
    public static final DeferredBlock<CorruptedBlocks> CORRUPTED_GRASS_ENVY = BLOCKS.registerBlock("corrupted_grass_envy",properties -> new CorruptedBlocks(BlockBehaviour.Properties.of().destroyTime(2).randomTicks()));
    public static final DeferredBlock<CorruptedBlocks> CORRUPTED_GRASS_SLOTH = BLOCKS.registerBlock("corrupted_grass_sloth",properties -> new CorruptedBlocks(BlockBehaviour.Properties.of().destroyTime(2).randomTicks()));
    public static final DeferredBlock<CorruptedBlocks> CORRUPTED_GRASS_WRATH = BLOCKS.registerBlock("corrupted_grass_wrath",properties -> new CorruptedBlocks(BlockBehaviour.Properties.of().destroyTime(2).randomTicks()));
    public static final DeferredBlock<CorruptedBlocks> CORRUPTED_GRASS_GREED = BLOCKS.registerBlock("corrupted_grass_greed",properties -> new CorruptedBlocks(BlockBehaviour.Properties.of().destroyTime(2).randomTicks()));
    public static final DeferredBlock<CorruptedBlocks> CORRUPTED_GRASS_LUST = BLOCKS.registerBlock("corrupted_grass_lust",properties -> new CorruptedBlocks(BlockBehaviour.Properties.of().destroyTime(2).randomTicks()));
    public static final DeferredBlock<CorruptedBlocks> CORRUPTED_GRASS_GLUTTONY = BLOCKS.registerBlock("corrupted_grass_gluttony",properties -> new CorruptedBlocks(BlockBehaviour.Properties.of().destroyTime(2).randomTicks()));
    public static final DeferredBlock<Block> FLESH_BLOCK = BLOCKS.registerBlock("flesh_block",Block::new);
    public static final DeferredBlock<CorruptedCandle> CANDLE_ENVY = BLOCKS.registerBlock("envy_candle",properties -> new CorruptedCandle(BlockBehaviour.Properties.of().destroyTime(1).lightLevel(state -> state.getValue(CorruptedCandle.LIT) ? 8 :0),ParticleTypes.SOUL_FIRE_FLAME));
    public static final DeferredBlock<CorruptedCandle> CANDLE_GLUTTONY = BLOCKS.registerBlock("gluttony_candle",properties -> new CorruptedCandle(BlockBehaviour.Properties.of().destroyTime(1).lightLevel(state -> state.getValue(CorruptedCandle.LIT) ? 8 :0),ParticleTypes.SOUL_FIRE_FLAME));
    public static final DeferredBlock<CorruptedCandle> CANDLE_PRIDE = BLOCKS.registerBlock("pride_candle",properties -> new CorruptedCandle(BlockBehaviour.Properties.of().destroyTime(1).lightLevel(state -> state.getValue(CorruptedCandle.LIT) ? 8 :0),ParticleTypes.SOUL_FIRE_FLAME));
    public static final DeferredBlock<CorruptedCandle> CANDLE_LUST = BLOCKS.registerBlock("lust_candle",properties -> new CorruptedCandle(BlockBehaviour.Properties.of().destroyTime(1).lightLevel(state -> state.getValue(CorruptedCandle.LIT) ? 8 :0),ParticleTypes.SOUL_FIRE_FLAME));
    public static final DeferredBlock<CorruptedCandle> CANDLE_WRATH = BLOCKS.registerBlock("wrath_candle",properties -> new CorruptedCandle(BlockBehaviour.Properties.of().destroyTime(1).lightLevel(state -> state.getValue(CorruptedCandle.LIT) ? 8 :0),ParticleTypes.SOUL_FIRE_FLAME));
    public static final DeferredBlock<CorruptedCandle> CANDLE_SLOTH = BLOCKS.registerBlock("sloth_candle",properties -> new CorruptedCandle(BlockBehaviour.Properties.of().destroyTime(1).lightLevel(state -> state.getValue(CorruptedCandle.LIT) ? 8 :0),ParticleTypes.SOUL_FIRE_FLAME));
    public static final DeferredBlock<CorruptedCandle> CANDLE_GREED = BLOCKS.registerBlock("greed_candle",properties -> new CorruptedCandle(BlockBehaviour.Properties.of().destroyTime(1).lightLevel(state -> state.getValue(CorruptedCandle.LIT) ? 8 :0),ParticleTypes.SOUL_FIRE_FLAME));
    public static final DeferredBlock<RuinedPaperBlock> RUINED_PAPER_BLOCK = BLOCKS.registerBlock("ruined_paper_block",properties -> new RuinedPaperBlock(BlockBehaviour.Properties.of().destroyTime(0)));
    public void register(IEventBus iEventBus){
        BLOCKS.register(iEventBus);
    }
}
