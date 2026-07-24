package main.Multiblock;

import main.Blocks.CorruptedCandle;
import main.Blocks.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class SinAltarPattern {

    public enum Sins{
        pride,envy,gluttonous,sloth,lust,wrath,greed
    }
    private final Map<BlockPos, Predicate<BlockState>> layout;
    public static final Map<String,SinAltarPattern> Altars = new HashMap<>();
    static {
        for (Sins sin : Sins.values()) {
            register(sin.name(), build(getCandleFor(sin)));
        }
    }
    private static Supplier<? extends CorruptedCandle> getCandleFor(Sins sin) {
        return switch (sin) {
            case pride -> ModBlocks.CANDLE_PRIDE;
            case envy -> ModBlocks.CANDLE_ENVY;
            case gluttonous -> ModBlocks.CANDLE_GLUTTONY;
            case sloth -> ModBlocks.CANDLE_SLOTH;
            case lust -> ModBlocks.CANDLE_LUST;
            case wrath -> ModBlocks.CANDLE_WRATH;
            case greed -> ModBlocks.CANDLE_GREED;
        };
    }
    private static SinAltarPattern build(Supplier<? extends CorruptedCandle> candle) {
        Map<BlockPos, Predicate<BlockState>> layout = new HashMap<>();
        layout.put(new BlockPos(-3, 0, 0), s -> s.is(ModBlocks.PEDESTAL_BLOCK.get()));
        layout.put(new BlockPos(3, 0, 0), s -> s.is(ModBlocks.PEDESTAL_BLOCK.get()));
        layout.put(new BlockPos(0, 0, 3), s -> s.is(ModBlocks.PEDESTAL_BLOCK.get()));
        layout.put(new BlockPos(0, 0, -3), s -> s.is(ModBlocks.PEDESTAL_BLOCK.get()));
        layout.put(new BlockPos(-3, 1, 3), s -> s.is(candle.get()));
        layout.put(new BlockPos(3, 1, -3), s -> s.is(candle.get()));
        layout.put(new BlockPos(3, 1, 3), s -> s.is(candle.get()));
        layout.put(new BlockPos(-3, 1, -3), s -> s.is(candle.get()));
        layout.put(new BlockPos(-5, 2, 0), s -> s.is(ModBlocks.PEDESTAL_BLOCK.get()));
        layout.put(new BlockPos(5, 2, 0), s -> s.is(ModBlocks.PEDESTAL_BLOCK.get()));
        layout.put(new BlockPos(0, 2, 5), s -> s.is(ModBlocks.PEDESTAL_BLOCK.get()));
        layout.put(new BlockPos(0, 2, -5), s -> s.is(ModBlocks.PEDESTAL_BLOCK.get()));
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
    public static boolean matchesAny(Level level,BlockPos pos){
        for (var entry : Altars.entrySet()){
            if (entry.getValue().matches(level,pos)){

                return true;
            }
        }
        return false;
    }
    private static SinAltarPattern register(String key, SinAltarPattern pattern) {
        Altars.put(key, pattern);
        return pattern;
    }
    public static String get_Sin(Level level,BlockPos pos){
        for (var entry : Altars.entrySet()){
            if (entry.getValue().matches(level,pos)){
                return entry.getKey();
            }
        }
        return null;
    }
    public static SinAltarPattern get(String key) {
        return Altars.get(key);
    }
}
