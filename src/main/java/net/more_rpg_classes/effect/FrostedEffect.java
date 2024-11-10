package net.more_rpg_classes.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.more_rpg_classes.MRPGCMod;

public class FrostedEffect extends StatusEffect {
    public FrostedEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        if(!entity.hasStatusEffect(MRPGCEffects.FROZEN_SOLID)){
            entity.setFrozenTicks(entity.getFrozenTicks() + (60 * amplifier));
            if(amplifier == MRPGCMod.effectsConfig.value.frosted_amplifier_frozen_solid_conversion){
                entity.addStatusEffect(new StatusEffectInstance(MRPGCEffects.FROZEN_SOLID,100,0,false,false,true));
                entity.removeStatusEffect(MRPGCEffects.FROSTED);
            }
        }else {
            entity.removeStatusEffect(MRPGCEffects.FROSTED);
        }

    }
}
