package main.Entities;

import main.Blocks.ModBlocks;
import main.Main;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, Main.MODID);
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AltarBe>> ALTAR_BE =
            BLOCK_ENTITIES.register("altar_be", () ->
                    BlockEntityType.Builder.of(AltarBe::new, ModBlocks.Altar_BLOCK.get()).build(null));
    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
