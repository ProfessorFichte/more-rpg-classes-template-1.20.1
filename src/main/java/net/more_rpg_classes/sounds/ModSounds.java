package net.more_rpg_classes.sounds;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import static net.more_rpg_classes.MRPGCMod.MOD_ID;

public class ModSounds {
    public static final Identifier ICICLE_CRASH_ID = Identifier.of(MOD_ID, "icicle_crash");
    public static SoundEvent ICICLE_CRASH_EVENT = SoundEvent.of(ICICLE_CRASH_ID);
    public static final Identifier STRONG_ATTACK_ID = Identifier.of(MOD_ID, "strong_attack");
    public static SoundEvent STRONG_ATTACK_EVENT = SoundEvent.of(STRONG_ATTACK_ID);
    public static final Identifier CRIPPLING_STRIKE_ID = Identifier.of(MOD_ID, "crippling_strike");
    public static SoundEvent CRIPPLING_STRIKE_EVENT = SoundEvent.of(CRIPPLING_STRIKE_ID);
    public static final Identifier WATER_MAGIC_IMPACT_1_ID = Identifier.of(MOD_ID, "water_magic_impact1");
    public static SoundEvent WATER_MAGIC_IMPACT_1_EVENT = SoundEvent.of(WATER_MAGIC_IMPACT_1_ID);
    public static final Identifier EARTH_MAGIC_IMPACT_1_ID = Identifier.of(MOD_ID, "earth_magic_impact1");
    public static SoundEvent EARTH_MAGIC_IMPACT_1_EVENT = SoundEvent.of(EARTH_MAGIC_IMPACT_1_ID);
    public static final Identifier EARTH_MAGIC_IMPACT_2_ID = Identifier.of(MOD_ID, "earth_magic_impact2");
    public static SoundEvent EARTH_MAGIC_IMPACT_2_EVENT = SoundEvent.of(EARTH_MAGIC_IMPACT_2_ID);
    public static final Identifier AIR_MAGIC_IMPACT_1_ID = Identifier.of(MOD_ID, "air_magic_impact1");
    public static SoundEvent AIR_MAGIC_IMPACT_1_EVENT = SoundEvent.of(AIR_MAGIC_IMPACT_1_ID);
    public static final Identifier AIR_MAGIC_IMPACT_2_ID = Identifier.of(MOD_ID, "air_magic_impact2");
    public static SoundEvent AIR_MAGIC_IMPACT_2_EVENT = SoundEvent.of(AIR_MAGIC_IMPACT_2_ID);
    public static final Identifier AIR_MAGIC_IMPACT_3_ID = Identifier.of(MOD_ID, "air_magic_impact3");
    public static SoundEvent AIR_MAGIC_IMPACT_3_EVENT = SoundEvent.of(AIR_MAGIC_IMPACT_3_ID);
    public static final Identifier AIR_MAGIC_CAST_1_ID = Identifier.of(MOD_ID, "air_magic_cast1");
    public static SoundEvent AIR_MAGIC_CAST_1_EVENT = SoundEvent.of(AIR_MAGIC_CAST_1_ID);
    public static final Identifier EARTH_MAGIC_CAST_1_ID = Identifier.of(MOD_ID, "earth_magic_cast1");
    public static SoundEvent EARTH_MAGIC_CAST_1_EVENT = SoundEvent.of(EARTH_MAGIC_CAST_1_ID);

    public static void register() {
        Registry.register(Registries.SOUND_EVENT, ICICLE_CRASH_ID, ICICLE_CRASH_EVENT);
        Registry.register(Registries.SOUND_EVENT, STRONG_ATTACK_ID, STRONG_ATTACK_EVENT);
        Registry.register(Registries.SOUND_EVENT, CRIPPLING_STRIKE_ID, CRIPPLING_STRIKE_EVENT);
        Registry.register(Registries.SOUND_EVENT, WATER_MAGIC_IMPACT_1_ID, WATER_MAGIC_IMPACT_1_EVENT);
        Registry.register(Registries.SOUND_EVENT, EARTH_MAGIC_IMPACT_1_ID, EARTH_MAGIC_IMPACT_1_EVENT);
        Registry.register(Registries.SOUND_EVENT, EARTH_MAGIC_IMPACT_2_ID, EARTH_MAGIC_IMPACT_2_EVENT);
        Registry.register(Registries.SOUND_EVENT, AIR_MAGIC_IMPACT_1_ID, AIR_MAGIC_IMPACT_1_EVENT);
        Registry.register(Registries.SOUND_EVENT, AIR_MAGIC_IMPACT_2_ID, AIR_MAGIC_IMPACT_2_EVENT);
        Registry.register(Registries.SOUND_EVENT, AIR_MAGIC_IMPACT_3_ID, AIR_MAGIC_IMPACT_3_EVENT);
        Registry.register(Registries.SOUND_EVENT, AIR_MAGIC_CAST_1_ID, AIR_MAGIC_CAST_1_EVENT);
        Registry.register(Registries.SOUND_EVENT, EARTH_MAGIC_CAST_1_ID, EARTH_MAGIC_CAST_1_EVENT);
    }


}