package net.twomoonsstudios.moonsweaponry.helpers;

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
}
