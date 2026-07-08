package main.curios;

import main.Corruption;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class Omens extends Item implements ICurioItem {
    private MobEffectInstance OmenEffect;
    public Omens(MobEffectInstance OmenEffect) {
        super(new Properties().stacksTo(1).durability(0));
        this.OmenEffect = OmenEffect;

    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        LivingEntity livingEntity = slotContext.entity();
        if (!livingEntity.level().isClientSide()) {
            livingEntity.addEffect(OmenEffect);
        }
    }
}
