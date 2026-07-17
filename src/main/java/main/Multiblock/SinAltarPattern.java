package main.Multiblock;

import main.Blocks.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class SinAltarPattern {
    private final Map<BlockPos, Predicate<BlockState>> layout;

    public static final SinAltarPattern SIN_ALTAR = build();

    private static SinAltarPattern build() {
        Map<BlockPos, Predicate<BlockState>> layout = new HashMap<>();
        for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++) {
                layout.put(new BlockPos(x, -1, z), s -> s.is(Blocks.POLISHED_BLACKSTONE));
            }
        }
        layout.put(new BlockPos(-1, 0, -1), s -> s.is(ModBlocks.CANDLE_ENVY.get()));
        layout.put(new BlockPos(1, 0, -1), s -> s.is(ModBlocks.CANDLE_ENVY.get()));
        layout.put(new BlockPos(-1, 0, 1), s -> s.is(ModBlocks.CANDLE_ENVY.get()));
        layout.put(new BlockPos(1, 0, 1), s -> s.is(ModBlocks.CANDLE_ENVY.get()));
        return new SinAltarPattern(layout);
    }

    public SinAltarPattern(Map<BlockPos, Predicate<BlockState>> layout) {
        this.layout = layout;
    }

    public boolean matches(Level level, BlockPos controllerPos) {
        for (var entry : layout.entrySet()) {
            BlockPos check = controllerPos.offset(entry.getKey());
            if (!entry.getValue().test(level.getBlockState(check))) {
                return false;
            }
        }
        return true;
    }
}
