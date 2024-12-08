package net.more_rpg_classes.effect;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.more_rpg_classes.util.tags.MRPGCEntityTags;

public class StunEffect extends StatusEffect {
    protected StunEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    public void onApplied(LivingEntity livingEntity, int amplifier) {
        super.onApplied(livingEntity, amplifier);
        EntityType<?> type = livingEntity.getType();
        if(type.isIn(MRPGCEntityTags.STUN_IMMUNE)) {
            livingEntity.removeStatusEffect(MRPGCEffects.STUNNED.registryEntry);

        }

    }
}
