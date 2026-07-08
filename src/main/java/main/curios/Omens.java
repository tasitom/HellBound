package main.curios;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class Omens extends Item implements ICurioItem {
    private MobEffectInstance OmenEffect;
    public Omens(MobEffectInstance OmenEffect) {
        super(new Properties().stacksTo(1));
        this.OmenEffect = OmenEffect;

    }

    @Override
    public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {
        ICurioItem.super.onEquip(slotContext, prevStack, stack);
        LivingEntity livingEntity = slotContext.entity();
        if (!livingEntity.level().isClientSide){
            livingEntity.addEffect(OmenEffect);
        }
    }

    @Override
    public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {
        ICurioItem.super.onUnequip(slotContext, newStack, stack);
        LivingEntity entity = slotContext.entity();
        if (!entity.level().isClientSide){
            entity.removeEffect(OmenEffect.getEffect());
        }
    }
}
