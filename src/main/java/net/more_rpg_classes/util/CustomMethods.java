package net.more_rpg_classes.util;

import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.particle.ParticleEffect;

import java.util.Iterator;
import java.util.List;

public class CustomMethods {

    public static void increaseAmpByChance(
            LivingEntity entity, StatusEffect statusEffect, int duration, int amplifier, int max_amp, int chance) {
        int roll = (int) ((Math.random() * (1 + chance)) + 1);
        if (roll >= chance)    {
            if (entity.hasStatusEffect(statusEffect)) {
                int currentAmplifier = entity.getStatusEffect(statusEffect).getAmplifier();
                if (currentAmplifier >= max_amp) {
                    entity.addStatusEffect(new StatusEffectInstance(statusEffect, duration, currentAmplifier, false, false, true));
                    return;
                }
                entity.addStatusEffect(new StatusEffectInstance(statusEffect, duration, currentAmplifier + amplifier, false, false, true));
            }
            entity.addStatusEffect(new StatusEffectInstance(statusEffect, duration, amplifier, false,false, true ));
    }
    }
    public static void increaseHiddenAmpByChance(
            LivingEntity entity, StatusEffect statusEffect, int duration, int amplifier, int max_amp, int chance) {
        int roll = (int) ((Math.random() * (1 + chance)) + 1);
        if (roll >= chance)    {
            if (entity.hasStatusEffect(statusEffect)) {
                int currentAmplifier = entity.getStatusEffect(statusEffect).getAmplifier();
                int currentDuration= entity.getStatusEffect(statusEffect).getDuration();
                if (currentAmplifier >= max_amp) {
                    entity.addStatusEffect(new StatusEffectInstance(statusEffect, currentDuration, currentAmplifier, false, false, false));
                    return;
                }
                entity.addStatusEffect(new StatusEffectInstance(statusEffect, currentDuration, currentAmplifier + amplifier, false, false, false));
            }
            entity.addStatusEffect(new StatusEffectInstance(statusEffect, duration, amplifier, false,false, false ));
        }
    }

    public static void decreaseAmpByChance(
            LivingEntity entity, StatusEffect statusEffect, int removedampstack, int chance) {
        int roll = (int) ((Math.random() * (1 + chance)) + 1);
        if (roll >= chance){
            if (entity.hasStatusEffect(statusEffect)){
                int currentAmp = entity.getStatusEffect(statusEffect).getAmplifier();
                int Duration = entity.getStatusEffect(statusEffect).getDuration();
                if (currentAmp < 1 ) {
                    entity.removeStatusEffect(statusEffect);
                    return;
                }
                entity.removeStatusEffect(statusEffect);
                entity.addStatusEffect(new StatusEffectInstance(
                        statusEffect, Duration, currentAmp - removedampstack, false, false, true));
            }
        }
    }

    public static void decreaseAmp(
            LivingEntity entity, StatusEffect statusEffect, int removedampstack) {
            if (entity.hasStatusEffect(statusEffect)){
                int currentAmp = entity.getStatusEffect(statusEffect).getAmplifier();
                int Duration = entity.getStatusEffect(statusEffect).getDuration();
                if (currentAmp < 1 ) {
                    entity.removeStatusEffect(statusEffect);
                    return;
                }
                entity.removeStatusEffect(statusEffect);
                entity.addStatusEffect(new StatusEffectInstance(
                        statusEffect, Duration, currentAmp - removedampstack, false, false, true));
            }
    }

    public static void increaseEffectLevel(LivingEntity entity, StatusEffect statusEffect, int duration, int amplifier, int amplifierMax) {
        if (entity.hasStatusEffect(statusEffect)) {
            int currentAmplifier = entity.getStatusEffect(statusEffect).getAmplifier();
            if (currentAmplifier >= amplifierMax) {
                entity.addStatusEffect(new StatusEffectInstance(statusEffect, duration, currentAmplifier, false, false, true));
                return;
            }
            entity.addStatusEffect(new StatusEffectInstance(statusEffect, duration, currentAmplifier + amplifier, false, false, true));
        }
        entity.addStatusEffect(new StatusEffectInstance(statusEffect, duration, amplifier, false,false, true ));
    }
    public static void increaseHiddenEffectLevel(LivingEntity entity, StatusEffect statusEffect, int duration, int amplifier, int amplifierMax) {
        if (entity.hasStatusEffect(statusEffect)) {
            int currentAmplifier = entity.getStatusEffect(statusEffect).getAmplifier();
            if (currentAmplifier >= amplifierMax) {
                entity.addStatusEffect(new StatusEffectInstance(statusEffect, duration, currentAmplifier, false, false, false));
                return;
            }
            entity.addStatusEffect(new StatusEffectInstance(statusEffect, duration, currentAmplifier + amplifier, false, false, false));
        }
        entity.addStatusEffect(new StatusEffectInstance(statusEffect, duration, amplifier, false,false, false ));
    }

    public static void decreaseEffectLevel(LivingEntity entity, StatusEffect statusEffect, int amplifier) {
        if (entity.hasStatusEffect(statusEffect)) {
            int currentAmplifier = entity.getStatusEffect(statusEffect).getAmplifier();
            int currentDuration = entity.getStatusEffect(statusEffect).getDuration();
            if (currentAmplifier < 1 ) {
                entity.removeStatusEffect(statusEffect);
                return;
            }
            entity.removeStatusEffect(statusEffect);
            entity.addStatusEffect(new StatusEffectInstance(statusEffect, currentDuration, currentAmplifier - amplifier, false, false, true));
        }
    }

    public static boolean clearNegativeEffects(LivingEntity entity, boolean debuff) {
        List<StatusEffectInstance> list = entity.getStatusEffects().stream().toList();
        if (list.isEmpty())
            return false;
        for (StatusEffectInstance statusEffectInstance : list) {
            StatusEffect statusEffect = statusEffectInstance.getEffectType();
            if (!statusEffect.isBeneficial() && debuff) {
                entity.removeStatusEffect(statusEffect);
            }
        }
        return true;
    }

    public static void spawnCloudEntity(
            ParticleEffect particleType, Entity owner, float radiusCloud, int durationSecondsCloud, float radiusGrowthCloud
            , StatusEffect statusEffect, int durationSecondsStatusEffect, int amplifierStatusEffect) {
        if (!owner.getWorld().isClient) {
            List<LivingEntity> list = owner.getWorld().getNonSpectatingEntities(LivingEntity.class, owner.getBoundingBox().expand(4.0, 2.0, 4.0));
            AreaEffectCloudEntity areaEffectCloudEntity = new AreaEffectCloudEntity(owner.getWorld(), owner.getX(), owner.getY(), owner.getZ());
            Entity entity = null;
            if(owner instanceof LivingEntity){
                entity = owner;
            }else if(owner instanceof ProjectileEntity projectile){
                projectile.getOwner();
            }
            if (entity instanceof LivingEntity) {
                areaEffectCloudEntity.setOwner((LivingEntity)entity);
            }
            areaEffectCloudEntity.setParticleType(particleType);
            areaEffectCloudEntity.setRadius(radiusCloud);
            areaEffectCloudEntity.setDuration(durationSecondsCloud*20);
            areaEffectCloudEntity.setRadiusGrowth((radiusGrowthCloud - areaEffectCloudEntity.getRadius()) / (float)areaEffectCloudEntity.getDuration());
            areaEffectCloudEntity.addEffect(new StatusEffectInstance(statusEffect,
                    durationSecondsStatusEffect*20, amplifierStatusEffect, false, false, true));
            if (!list.isEmpty()) {
                Iterator var5 = list.iterator();
                while(var5.hasNext()) {
                    LivingEntity livingEntity2 = (LivingEntity)var5.next();
                    double x = owner.squaredDistanceTo(livingEntity2);
                    if (x < 16.0) {
                        areaEffectCloudEntity.setPosition(livingEntity2.getX(), livingEntity2.getY(), livingEntity2.getZ());
                        break;
                    }
                }
            }
            owner.getWorld().spawnEntity(areaEffectCloudEntity);
        }
    }
}
