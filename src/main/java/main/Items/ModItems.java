package main.Items;

import main.Main;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static DeferredRegister.Items ITEMS = DeferredRegister.createItems(Main.MODID);




    public void register(IEventBus iEventBus){
        ITEMS.register(iEventBus);
    }
}
