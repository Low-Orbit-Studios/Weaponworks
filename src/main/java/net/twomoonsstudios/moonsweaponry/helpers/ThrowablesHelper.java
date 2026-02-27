package net.twomoonsstudios.moonsweaponry.helpers;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.forgespi.Environment;
import net.twomoonsstudios.moonsweaponry.MoonsWeaponry;

import java.util.Map;

import static net.twomoonsstudios.moonsweaponry.MoonsWeaponry.getConfigHelper;
import static net.twomoonsstudios.moonsweaponry.MoonsWeaponry.getLogger;

public class ThrowablesHelper {
    public static float getDmgByVelocity(float currentVelocity, float maxVelocity, float baseDmg, float velocityLevel)
    {
//        //How fast is the entity travelling in % of max speed.
//        var velocityPercentage = currentVelocity / maxVelocity;
//        if(velocityPercentage >= maxDmgVelocityThreshold){
//            return baseDmg; //Do not change Damage.
//        }
//        else if(velocityPercentage <= minDmgVelocityThreshold){
//            return baseDmg * minDmgCoef;//We are below min threshold. Return smallest possible damage.
//        }
//
//        //We scale linearly between thresholds, with y = ax + b. y is the result damage, x is current velocity. Calc a and b:
//        var baseFuncAngleCoef = (1 - minDmgCoef) / (maxDmgVelocityThreshold - minDmgVelocityThreshold);
//        var a = baseDmg * baseFuncAngleCoef;
//        var b = baseDmg * (1 - maxDmgVelocityThreshold * baseFuncAngleCoef);
//
//        var newDmg = a * velocityPercentage + b;//separate line for easier debug
//        return newDmg;
        Map<String,Object> config = MoonsWeaponry.getConfigHelper().weaponworksConfig.throwingWeaponConstants;
        float velocityPercent = currentVelocity / maxVelocity;
        float minDmgVelocityPercent = ((Double) config.get("throwableMinDmgVelocityPercent")).floatValue();
        float maxDmgVelocityPercent = ((Double) config.get("throwableMaxDmgVelocityPercent")).floatValue();
        float minDmgCoef = ((Double) config.get("throwableMinDmgCoefficient")).floatValue();
        float minDmg = baseDmg * minDmgCoef;
        float dmgToDeal = baseDmg;
        if (velocityPercent <= minDmgVelocityPercent) {
            dmgToDeal = minDmg;
        } else if (velocityPercent <= maxDmgVelocityPercent)
        {
            float slope = (1 - minDmgCoef) / (maxDmgVelocityPercent - minDmgVelocityPercent);

            dmgToDeal = (slope * (velocityPercent - minDmgVelocityPercent) + minDmgCoef) * baseDmg;

            MoonsWeaponry.getLogger().debug("slope: {}, dmg: {}", slope, dmgToDeal);
        }
        dmgToDeal = modifyDamage(dmgToDeal, velocityLevel);

        // 0.5f added because for some reason (float error buildup? idk) enemies with 20 health taking 20 dmg have 0.13 hp
        return Mth.ceil(dmgToDeal) + 0.5f;

    }

    static float modifyDamage(float dmgToDeal, float velocityLevel) {
        return dmgToDeal + (velocityLevel *  ((Double) getConfigHelper().weaponworksConfig.enchantmentConstants.get("velocityEnchantLevelDmgIncrease")).floatValue());
    }
}
