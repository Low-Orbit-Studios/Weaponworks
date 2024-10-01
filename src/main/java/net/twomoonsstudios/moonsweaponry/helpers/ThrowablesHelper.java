package net.twomoonsstudios.moonsweaponry.helpers;

import net.twomoonsstudios.moonsweaponry.constants.ThrownWeaponDataConstants;
import net.twomoonsstudios.moonsweaponry.item.ThrowableWeaponItem;

import java.util.HashMap;

import static net.twomoonsstudios.moonsweaponry.constants.ThrownWeaponDataConstants.*;

public class ThrowablesHelper {
    /**
     * Calculates the damage to be dealt scaled by linear function dependant on current velocity and passed thresholds.
     *
     * @param maxDmgVelocityThreshold Above (or equal to) what value should the damage be equal to base damage (100% damage dealt)? Range is [0, 1]
     * @param minDmgVelocityThreshold Below (or equal to) what value should the damage be equal to minimum damage? Range is [0, 1]*/
    public static float getDmgByVelocity(float maxDmgVelocityThreshold, float minDmgVelocityThreshold, float currentVelocity, float maxVelocity, float baseDmg, float minDmgCoef)
    {
        //How fast is the entity travelling in % of max speed.
        var velocityPercentage = currentVelocity/maxVelocity;
        if(velocityPercentage >= maxDmgVelocityThreshold){
            return baseDmg; //Do not change Damage.
        }
        else if(velocityPercentage <= minDmgVelocityThreshold){
            return baseDmg * minDmgCoef;//We are below min threshold. Return smallest possible damage.
        }

        //We scale linearly between thresholds, with y = ax + b. y is the result damage, x is current velocity. Calc a and b:
        var baseFuncAngleCoef = (1 - minDmgCoef) / (maxDmgVelocityThreshold - minDmgVelocityThreshold);
        var a = baseDmg * baseFuncAngleCoef;
        var b = baseDmg * (1 - maxDmgVelocityThreshold * baseFuncAngleCoef);

        var newDmg = a * velocityPercentage + b;//separate line for easier debug
        return newDmg;
    }

    public static HashMap<String,Object> getDefaultConfig() {
        HashMap<String, Object> ThrownConfigMap = new HashMap<>();
        ThrownConfigMap.put("throwables_flame_enchant_seconds", 100);
        ThrownConfigMap.put("throwables_flame_enchant_entity_seconds", 5);
        ThrownConfigMap.put("throwable_max_dmg_velocity_threshold", 0.8f);
        ThrownConfigMap.put("throwable_min_dmg_velocity_threshold", 0.4f);
        ThrownConfigMap.put("throwable_min_dmg_coef", 0.2f);

        ThrownConfigMap.put("dagger_default_cooldown", 10);
        ThrownConfigMap.put("dagger_default_inaccuracy", 0.1f);
        ThrownConfigMap.put("dagger_default_velocity", 1.6f);

        ThrownConfigMap.put("wood_dagger_default_dmg", 3);
        ThrownConfigMap.put("wood_dagger_default_uses", 16);
        ThrownConfigMap.put("stone_dagger_default_dmg", 3);
        ThrownConfigMap.put("stone_dagger_default_uses", 24);
        ThrownConfigMap.put("iron_dagger_default_dmg", 4);
        ThrownConfigMap.put("iron_dagger_default_uses", 24);
        ThrownConfigMap.put("gold_dagger_default_dmg", 5);
        ThrownConfigMap.put("gold_dagger_default_uses", 16);
        ThrownConfigMap.put("diamond_dagger_default_dmg", 5);
        ThrownConfigMap.put("diamond_dagger_default_uses", 32);
        ThrownConfigMap.put("netherite_dagger_default_dmg", 6);
        ThrownConfigMap.put("netherite_dagger_default_uses", 32);

        ThrownConfigMap.put("javelin_default_cooldown", 25);
        ThrownConfigMap.put("javelin_default_inaccuracy", 0.05f);
        ThrownConfigMap.put("javelin_default_velocity", 1.8f);

        ThrownConfigMap.put("wood_javelin_default_dmg", 6);
        ThrownConfigMap.put("wood_javelin_default_uses", 12);
        ThrownConfigMap.put("stone_javelin_default_dmg", 6);
        ThrownConfigMap.put("stone_javelin_default_uses", 16);
        ThrownConfigMap.put("iron_javelin_default_dmg", 7);
        ThrownConfigMap.put("iron_javelin_default_uses", 24);
        ThrownConfigMap.put("gold_javelin_default_dmg", 8);
        ThrownConfigMap.put("gold_javelin_default_uses", 12);
        ThrownConfigMap.put("diamond_javelin_default_dmg", 8);
        ThrownConfigMap.put("diamond_javelin_default_uses", 32);
        ThrownConfigMap.put("netherite_javelin_default_dmg", 9);
        ThrownConfigMap.put("netherite_javelin_default_uses", 32);

        ThrownConfigMap.put("shuriken_default_cooldown", 15);
        ThrownConfigMap.put("shuriken_default_inaccuracy", 0.1f);
        ThrownConfigMap.put("shuriken_default_velocity", 1.5f);

        ThrownConfigMap.put("wood_shuriken_default_dmg", 3);
        ThrownConfigMap.put("wood_shuriken_default_uses", 18);
        ThrownConfigMap.put("stone_shuriken_default_dmg", 3);
        ThrownConfigMap.put("stone_shuriken_default_uses", 24);
        ThrownConfigMap.put("iron_shuriken_default_dmg", 4);
        ThrownConfigMap.put("iron_shuriken_default_uses", 36);
        ThrownConfigMap.put("gold_shuriken_default_dmg", 5);
        ThrownConfigMap.put("gold_shuriken_default_uses", 18);
        ThrownConfigMap.put("diamond_shuriken_default_dmg", 5);
        ThrownConfigMap.put("diamond_shuriken_default_uses", 48);
        ThrownConfigMap.put("netherite_shuriken_default_dmg", 6);
        ThrownConfigMap.put("netherite_shuriken_default_uses", 48);

        ThrownConfigMap.put("hatchet_default_cooldown", 30);
        ThrownConfigMap.put("hatchet_default_inaccuracy", 0.02f);
        ThrownConfigMap.put("hatchet_default_velocity", 2.0f);

        ThrownConfigMap.put("wood_hatchet_default_dmg", 7);
        ThrownConfigMap.put("wood_hatchet_default_uses", 8);
        ThrownConfigMap.put("stone_hatchet_default_dmg", 7);
        ThrownConfigMap.put("stone_hatchet_default_uses", 12);
        ThrownConfigMap.put("iron_hatchet_default_dmg", 8);
        ThrownConfigMap.put("iron_hatchet_default_uses", 16);
        ThrownConfigMap.put("gold_hatchet_default_dmg", 9);
        ThrownConfigMap.put("gold_hatchet_default_uses", 8);
        ThrownConfigMap.put("diamond_hatchet_default_dmg", 9);
        ThrownConfigMap.put("diamond_hatchet_default_uses", 24);
        ThrownConfigMap.put("netherite_hatchet_default_dmg", 10);
        ThrownConfigMap.put("netherite_hatchet_default_uses", 24);

        ThrownConfigMap.put("boomerang_default_cooldown", 10);
        ThrownConfigMap.put("boomerang_default_inaccuracy", 0.03f);
        ThrownConfigMap.put("boomerang_default_velocity", 1.5f);

        ThrownConfigMap.put("wood_boomerang_default_dmg", 5);
        ThrownConfigMap.put("wood_boomerang_default_uses", 1);
        ThrownConfigMap.put("stone_boomerang_default_dmg", 5);
        ThrownConfigMap.put("stone_boomerang_default_uses", 1);
        ThrownConfigMap.put("iron_boomerang_default_dmg", 6);
        ThrownConfigMap.put("iron_boomerang_default_uses", 1);
        ThrownConfigMap.put("gold_boomerang_default_dmg", 7);
        ThrownConfigMap.put("gold_boomerang_default_uses", 1);
        ThrownConfigMap.put("diamond_boomerang_default_dmg", 7);
        ThrownConfigMap.put("diamond_boomerang_default_uses", 1);
        ThrownConfigMap.put("netherite_boomerang_default_dmg", 8);
        ThrownConfigMap.put("netherite_boomerang_default_uses", 1);

        return ThrownConfigMap;
    }
}
