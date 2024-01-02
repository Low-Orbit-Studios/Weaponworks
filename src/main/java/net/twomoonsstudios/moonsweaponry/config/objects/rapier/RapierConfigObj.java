package net.twomoonsstudios.moonsweaponry.config.objects.rapier;

import net.twomoonsstudios.moonsweaponry.config.objects.WeaponConfigObj;

import java.lang.reflect.Type;

import static net.twomoonsstudios.moonsweaponry.constants.WeaponDataConstants.RAPIER_DEFAULT_ATK_SPD;

public abstract class RapierConfigObj extends WeaponConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public RapierConfigObj(Type myType, String myID) {
        super(myType, myID);
    }
    @Override
    public Float getDefaultAttackSpeed(){
        return RAPIER_DEFAULT_ATK_SPD;
    }

    @Override
    protected Boolean getDefaultFireResistance() {
        return false;
    }

}