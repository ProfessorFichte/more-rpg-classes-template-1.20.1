package net.more_rpg_classes.effect;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.registry.tag.EntityTypeTags;
import net.more_rpg_classes.MRPGCMod;

public class FrostedEffect extends StatusEffect {
    public FrostedEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    public void applyUpdateEffect(LivingEntity livingEntity, int pAmplifier) {
        livingEntity.setFrozenTicks(livingEntity.getFrozenTicks() + 3);
        super.applyUpdateEffect(livingEntity, pAmplifier);
    }

    @Override
    public void onApplied(LivingEntity livingEntity, AttributeContainer attributes, int amplifier) {
        EntityType<?> type = livingEntity.getType();
        if(!type.isIn(EntityTypeTags.FREEZE_IMMUNE_ENTITY_TYPES)) {
            if (!livingEntity.hasStatusEffect(MRPGCEffects.FROZEN_SOLID)) {
                if (amplifier == MRPGCMod.effectsConfig.value.frosted_amplifier_frozen_solid_conversion) {
                    livingEntity.addStatusEffect(new StatusEffectInstance(MRPGCEffects.FROZEN_SOLID, 100, 0, false, false, true));
                    livingEntity.removeStatusEffect(MRPGCEffects.FROSTED);
                }
            } else {
                livingEntity.removeStatusEffect(MRPGCEffects.FROSTED);
            }
        }else {
            livingEntity.removeStatusEffect(MRPGCEffects.FROSTED);
        }
    }
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
