package main.Blocks;

import main.Main;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;


public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Main.MODID);




    public void register(IEventBus iEventBus){
        BLOCKS.register(iEventBus);
    }
}
