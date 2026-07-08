package main.curios;

import main.Main;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CurioItems {
    public static DeferredRegister.Items OMENS = DeferredRegister.createItems(Main.MODID);
    public static DeferredItem<Item> GLUTTONY_OMEN = OMENS.register("gluttony_omen", properties -> new Omens(new MobEffectInstance(MobEffects.SATURATION, 21, 0, true, false, false)));
    public static DeferredItem<Item> GREED_OMEN = OMENS.register("greed_omen", properties -> new Omens(new MobEffectInstance(MobEffects.LUCK, 21, 0, true, false, false)));
    public static DeferredItem<Item> LUST_OMEN = OMENS.register("lust_omen", properties -> new Omens(new MobEffectInstance(MobEffects.REGENERATION, 21, 0, true, false, false)));
    public static DeferredItem<Item> PRIDE_OMEN = OMENS.register("pride_omen", properties -> new Omens(new MobEffectInstance(MobEffects.HEALTH_BOOST, 21, 0, true, false, false)));
    public static DeferredItem<Item> SLOTH_OMEN = OMENS.register("sloth_omen", properties -> new Omens(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 21, 0, true, false, false)));
    public static DeferredItem<Item> WRATH_OMEN = OMENS.register("wrath_omen", properties -> new Omens(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 21, 0, true, false, false)));
    public static DeferredItem<Item> ENVY_OMEN = OMENS.register("envy_omen", properties -> new Omens(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 21, 0, true, false, false)));
    public void register(IEventBus iEventBus){
        OMENS.register(iEventBus);
    }
}
