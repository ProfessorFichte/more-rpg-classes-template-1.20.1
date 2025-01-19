package net.more_rpg_classes.util;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.spell_engine.internals.SpellHelper;
import net.spell_engine.internals.WorldScheduler;
import net.spell_engine.internals.casting.SpellCast;
import net.spell_engine.utils.TargetHelper;
import net.spell_power.api.SpellDamageSource;
import net.spell_power.api.SpellSchool;

import java.util.*;
import java.util.function.Predicate;

import static net.spell_engine.internals.SpellRegistry.getSpell;

public class CustomMethods {
    public static boolean clearNegativeEffects(LivingEntity entity, boolean debuff) {
        var effects = entity.getStatusEffects();
        for (var instance : effects) {
            var effect = instance.getEffectType().value();
            if (!effect.isBeneficial()) {
                ((WorldScheduler)entity.getWorld()).schedule(1, () -> entity.removeStatusEffect(instance.getEffectType()));
            }
        }
        return debuff;
    }

    public static void stackFreezeStacks(LivingEntity livingEntity, int amount){
        int actualFrozenTicks = livingEntity.getFrozenTicks();
        if(actualFrozenTicks >= 140){
            livingEntity.setFrozenTicks(actualFrozenTicks + amount);
        }else{
            livingEntity.setFrozenTicks(140);
        }
    }

    public static void executeSpellSpellEngine(PlayerEntity player, LivingEntity target, String modId, String pathSpell,
                                               SpellCast.Action spellCastAction, boolean aoe){
        if (FabricLoader.getInstance().isModLoaded("spell_engine")) {
            List<Entity> list = new ArrayList<Entity>();
            if (!aoe) {
                list.add(target);
            } else {
                float range = getSpell(Identifier.of(modId, pathSpell)).range;
                Predicate<Entity> selectionPredicate = (target2) -> {
                    return (TargetHelper.actionAllowed(TargetHelper.TargetingMode.AREA, TargetHelper.Intent.HARMFUL, player, target2)
                    );
                };
                list = player.getWorld().getOtherEntities(player, player.getBoundingBox().expand(range), selectionPredicate);
            }
            SpellHelper.performSpell(
                    player.getWorld(),
                    player,
                    Identifier.of(modId, pathSpell),
                    TargetHelper.SpellTargetResult.of(list),
                    spellCastAction,
                    1);
        }

    }

    public static void spawnCloudEntity(
            ParticleEffect particleType, Entity owner, float radiusCloud, int durationSecondsCloud, float radiusGrowthCloud
            , RegistryEntry<StatusEffect> statusEffect, int durationSecondsStatusEffect, int amplifierStatusEffect) {
        if (!owner.getWorld().isClient) {
            List<LivingEntity> list = owner.getWorld().getNonSpectatingEntities(LivingEntity.class, owner.getBoundingBox().expand(4.0, 2.0, 4.0));
            AreaEffectCloudEntity areaEffectCloudEntity = new AreaEffectCloudEntity(owner.getWorld(), owner.getX(), owner.getY(), owner.getZ());
            Entity entity = null;
            if (owner instanceof LivingEntity) {
                entity = owner;
            } else if (owner instanceof ProjectileEntity projectile) {
                owner = projectile.getOwner();
                areaEffectCloudEntity.setOwner((LivingEntity) owner);
            }
            if (entity instanceof LivingEntity) {
                areaEffectCloudEntity.setOwner((LivingEntity) entity);
            }
            areaEffectCloudEntity.setParticleType(particleType);
            areaEffectCloudEntity.setRadius(radiusCloud);
            areaEffectCloudEntity.setDuration(durationSecondsCloud * 20);
            areaEffectCloudEntity.setRadiusGrowth((radiusGrowthCloud - areaEffectCloudEntity.getRadius()) / (float) areaEffectCloudEntity.getDuration());
            areaEffectCloudEntity.addEffect(new StatusEffectInstance(statusEffect,
                    durationSecondsStatusEffect * 20, amplifierStatusEffect, false, false, true));

            if (!list.isEmpty()) {
                Iterator var5 = list.iterator();
                while (var5.hasNext()) {
                    LivingEntity livingEntity2 = (LivingEntity) var5.next();
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

    public static void applyStatusEffect(LivingEntity target, int effectAmplifier,int effectDurationSeconds,RegistryEntry<StatusEffect> statusEffect,
                                         int maxStackAmplifier, boolean canStackAmplifier, boolean showIcon, boolean increaseDuration,
                                         int increaseEffectDurationSeconds){

            if(target.hasStatusEffect(statusEffect)){
                int currentAmplifier = target.getStatusEffect(statusEffect).getAmplifier();
                int currentDuration = target.getStatusEffect(statusEffect).getDuration();
                int increaseAmp = 0;
                if(increaseDuration){
                    currentDuration = currentDuration + (increaseEffectDurationSeconds*20);
                }
                if(canStackAmplifier){
                    increaseAmp = increaseAmp + 1;
                }
                if(currentAmplifier<maxStackAmplifier){
                    target.addStatusEffect(new StatusEffectInstance(statusEffect, currentDuration, currentAmplifier + increaseAmp, false, false, showIcon));
                }else{
                    target.addStatusEffect(new StatusEffectInstance(statusEffect, currentDuration, maxStackAmplifier, false, false, showIcon));
                }
            }else{
                target.addStatusEffect(new StatusEffectInstance(statusEffect, effectDurationSeconds*20, effectAmplifier, false, false, showIcon));
            }
    }

    public static void spellSchoolDamageCalculation(SpellSchool spellSchool, float damageMultiplication, LivingEntity target, PlayerEntity attacker){
        float spellPower = (float) spellSchool.getValue(SpellSchool.Trait.POWER,new SpellSchool.QueryArgs(attacker));
        float critChance = (float) spellSchool.getValue(SpellSchool.Trait.CRIT_CHANCE,new SpellSchool.QueryArgs(attacker));
        float critDamage = (float) spellSchool.getValue(SpellSchool.Trait.CRIT_DAMAGE,new SpellSchool.QueryArgs(attacker));
        
        float damageAmount = spellPower * damageMultiplication;
        float random = new Random().nextFloat(1.0F);
        if(random < critChance){
            damageAmount = damageAmount* critDamage;
        }
        target.damage(SpellDamageSource.create(spellSchool,attacker),damageAmount);
    }
}
