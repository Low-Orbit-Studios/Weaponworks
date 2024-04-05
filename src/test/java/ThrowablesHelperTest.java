import net.minecraft.world.item.Tiers;
import net.twomoonsstudios.moonsweaponry.constants.ThrownWeaponDataConstants;
import net.twomoonsstudios.moonsweaponry.enums.WeaponTypesEnum;
import net.twomoonsstudios.moonsweaponry.helpers.ThrowablesHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThrowablesHelperTest {
    public static final float THROWABLE_DEFAULT_VELOCITY = 1.6f;
    /**If the speed is greater or equal to this value, the weapon will deal max damage on impact.
     * Below it the damage will be properly scaled down. Range [0, 1]. Treat as % of max velocity.*/
    final float THROWABLE_MAX_DMG_VELOCITY_THRESHOLD = 0.8f;
    /**If the speed is lower or equal to this value, the weapon will deal minimum damage on impact.
     * {@link ThrownWeaponDataConstants#THROWABLE_MIN_DMG_COEF}. Treat as % of max velocity.*/
    final float THROWABLE_MIN_DMG_VELOCITY_THRESHOLD = 0.2f;
    /**The minimal damage multiplier a throwable can deal due to low movement speed. Range [0, 1]*/
    final float THROWABLE_MIN_DMG_COEF = 0.3f;
    final float THROWABLE_BASE_DMG = 10;
    //FLoat calculations can cause trash errors like 2.0000001. This is due to
    //hardware limitations. Use value below to round up to desired place after the comma, one zero per one place
    //after comma.
    final int roundingValue = 1000;

    private float getPercentageOfMaxVel(float currentVelocity){
        return currentVelocity/THROWABLE_DEFAULT_VELOCITY;
    }
    @Test
    void getDmgByVelocityGreaterThanMaxThreshold(){
        var currentVelocity = 2f;
        var newDmg = ThrowablesHelper.getDmgByVelocity(THROWABLE_MAX_DMG_VELOCITY_THRESHOLD
                , THROWABLE_MIN_DMG_VELOCITY_THRESHOLD
                ,currentVelocity
                ,THROWABLE_DEFAULT_VELOCITY
                ,THROWABLE_BASE_DMG
                ,THROWABLE_MIN_DMG_COEF);
        newDmg = Math.round(newDmg*roundingValue)/((float)roundingValue);
        assertEquals(newDmg, THROWABLE_BASE_DMG);
    }
    @Test
    void getDmgByVelocityEqualToMaxThreshold(){
        var currentVelocity = THROWABLE_DEFAULT_VELOCITY * THROWABLE_MAX_DMG_VELOCITY_THRESHOLD;
        var newDmg = ThrowablesHelper.getDmgByVelocity(THROWABLE_MAX_DMG_VELOCITY_THRESHOLD
                , THROWABLE_MIN_DMG_VELOCITY_THRESHOLD
                ,currentVelocity
                ,THROWABLE_DEFAULT_VELOCITY
                ,THROWABLE_BASE_DMG
                ,THROWABLE_MIN_DMG_COEF);
        newDmg = Math.round(newDmg*roundingValue)/((float)roundingValue);
        assertEquals(newDmg, THROWABLE_BASE_DMG);
    }
    //Below max above min - the middle of the linear function
    @Test
    void getDmgByVelocityMiddleBetweenThresholds(){
        var currentVelocity = THROWABLE_DEFAULT_VELOCITY * (THROWABLE_MAX_DMG_VELOCITY_THRESHOLD + THROWABLE_MIN_DMG_VELOCITY_THRESHOLD)/2;
        var newDmg = ThrowablesHelper.getDmgByVelocity(THROWABLE_MAX_DMG_VELOCITY_THRESHOLD
                , THROWABLE_MIN_DMG_VELOCITY_THRESHOLD
                ,currentVelocity
                ,THROWABLE_DEFAULT_VELOCITY
                ,THROWABLE_BASE_DMG
                ,THROWABLE_MIN_DMG_COEF);
        newDmg = Math.round(newDmg*roundingValue)/((float)roundingValue);
        var minDamage = THROWABLE_BASE_DMG * THROWABLE_MIN_DMG_COEF;
        var desiredDmg = (THROWABLE_BASE_DMG - minDamage)/2 + minDamage;
        assertEquals(newDmg, desiredDmg);
    }
    @Test
    void getDmgByVelocityEqualToMinThreshold(){
        var currentVelocity = THROWABLE_DEFAULT_VELOCITY * THROWABLE_MIN_DMG_VELOCITY_THRESHOLD;
        var newDmg = ThrowablesHelper.getDmgByVelocity(THROWABLE_MAX_DMG_VELOCITY_THRESHOLD
                , THROWABLE_MIN_DMG_VELOCITY_THRESHOLD
                ,currentVelocity
                ,THROWABLE_DEFAULT_VELOCITY
                ,THROWABLE_BASE_DMG
                ,THROWABLE_MIN_DMG_COEF);
        newDmg = Math.round(newDmg*roundingValue)/((float)roundingValue);
        var minDamage = THROWABLE_BASE_DMG * THROWABLE_MIN_DMG_COEF;
        assertEquals(newDmg, minDamage);
    }
    @Test
    void getDmgByVelocityLesserThanMinThreshold(){
        var currentVelocity = THROWABLE_DEFAULT_VELOCITY * THROWABLE_MIN_DMG_VELOCITY_THRESHOLD * 0.5f;
        var newDmg = ThrowablesHelper.getDmgByVelocity(THROWABLE_MAX_DMG_VELOCITY_THRESHOLD
                , THROWABLE_MIN_DMG_VELOCITY_THRESHOLD
                ,currentVelocity
                ,THROWABLE_DEFAULT_VELOCITY
                ,THROWABLE_BASE_DMG
                ,THROWABLE_MIN_DMG_COEF);
        newDmg = Math.round(newDmg*roundingValue)/((float)roundingValue);
        var minDamage = THROWABLE_BASE_DMG * THROWABLE_MIN_DMG_COEF;
        assertEquals(newDmg, minDamage);
    }
}
