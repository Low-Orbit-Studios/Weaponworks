package net.twomoonsstudios.moonsweaponry.config.objects.scythe;

import net.twomoonsstudios.moonsweaponry.config.objects.WeaponConfigObj;

import java.lang.reflect.Type;

import static net.twomoonsstudios.moonsweaponry.constants.WeaponDataConstants.DEFAULT_ATTACK_SPEED;
import static net.twomoonsstudios.moonsweaponry.constants.WeaponDataConstants.SCYTHE_DEFAULT_ATK_SPD;

public abstract class ScytheConfigObj extends WeaponConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public ScytheConfigObj(Type myType, String myID) {
        super(myType, myID);
    }
    @Override
    public Float getDefaultAttackSpeed(){
        return DEFAULT_ATTACK_SPEED - SCYTHE_DEFAULT_ATK_SPD;
    }

    @Override
    protected Boolean getDefaultFireResistance() {
        return false;
    }

}
