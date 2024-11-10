package net.more_rpg_classes.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.more_rpg_classes.MRPGCMod;

public class FrostedEffect extends StatusEffect {
    public FrostedEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(
                statusEffectCategory, color);
    }

    public void onApplied(LivingEntity entity,  int amplifier) {
        super.onApplied(entity, amplifier);
        if(!entity.hasStatusEffect(MRPGCEffects.FROZEN_SOLID.registryEntry)){
            entity.setFrozenTicks(entity.getFrozenTicks() + (60 * amplifier));
            if(amplifier == MRPGCMod.effectsConfig.value.frosted_amplifier_frozen_solid_conversion){
                entity.addStatusEffect(new StatusEffectInstance(MRPGCEffects.FROZEN_SOLID.registryEntry,100,0,false,false,true));
                entity.removeStatusEffect(MRPGCEffects.FROSTED.registryEntry);
            }
        }else{
            entity.removeStatusEffect(MRPGCEffects.FROSTED.registryEntry);
        }

    }

}
