package net.more_rpg_classes.effect;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.tag.EntityTypeTags;

public class FrozenSolidEffect extends StatusEffect {
    public FrozenSolidEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity livingEntity, int pAmplifier) {
            if (livingEntity.isOnFire()) {
                livingEntity.removeStatusEffect(MRPGCEffects.FROZEN_SOLID);
            } else if (livingEntity.isInLava()) {
                livingEntity.removeStatusEffect(MRPGCEffects.FROZEN_SOLID);
            }
            livingEntity.setFrozenTicks(livingEntity.getFrozenTicks() + 10);
            super.applyUpdateEffect(livingEntity, pAmplifier);
    }

    @Override
    public void onApplied(LivingEntity livingEntity, AttributeContainer attributes, int amplifier) {
        EntityType<?> type = livingEntity.getType();
        if(type.isIn(EntityTypeTags.FREEZE_IMMUNE_ENTITY_TYPES)) {
            livingEntity.removeStatusEffect(MRPGCEffects.FROZEN_SOLID);
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

}
