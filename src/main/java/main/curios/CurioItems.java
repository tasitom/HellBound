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
    public static DeferredItem<Item> GLUTTONY_OMEN = OMENS.register("gluttony_omen", properties -> new Omens(new MobEffectInstance(MobEffects.SATURATION,MobEffectInstance.INFINITE_DURATION, 0, true, false, false)));
    public static DeferredItem<Item> GREED_OMEN = OMENS.register("greed_omen", properties -> new Omens(new MobEffectInstance(MobEffects.LUCK, MobEffectInstance.INFINITE_DURATION, 0, true, false, false)));
    public static DeferredItem<Item> LUST_OMEN = OMENS.register("lust_omen", properties -> new Omens(new MobEffectInstance(MobEffects.REGENERATION, MobEffectInstance.INFINITE_DURATION, 0, true, false, false)));
    public static DeferredItem<Item> PRIDE_OMEN = OMENS.register("pride_omen", properties -> new Omens(new MobEffectInstance(MobEffects.HEALTH_BOOST, MobEffectInstance.INFINITE_DURATION, 0, true, false, false)));
    public static DeferredItem<Item> SLOTH_OMEN = OMENS.register("sloth_omen", properties -> new Omens(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, MobEffectInstance.INFINITE_DURATION, 0, true, false, false)));
    public static DeferredItem<Item> WRATH_OMEN = OMENS.register("wrath_omen", properties -> new Omens(new MobEffectInstance(MobEffects.DAMAGE_BOOST, MobEffectInstance.INFINITE_DURATION, 0, true, false, false)));
    public static DeferredItem<Item> ENVY_OMEN = OMENS.register("envy_omen", properties -> new Omens(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, MobEffectInstance.INFINITE_DURATION, 0, true, false, false)));
}
