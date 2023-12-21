package net.twomoonsstudios.moonsweaponry.config.objects.halberd;

import net.twomoonsstudios.moonsweaponry.config.objects.WeaponConfigObj;

import java.lang.reflect.Type;

import static net.twomoonsstudios.moonsweaponry.constants.WeaponDataConstants.HALBERD_DEFAULT_ATK_SPD;

public abstract class HalberdConfigObj extends WeaponConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public HalberdConfigObj(Type myType, String myID) {
        super(myType, myID);
    }
    @Override
    public Float getDefaultAttackSpeed(){
        return HALBERD_DEFAULT_ATK_SPD;
    }

    @Override
    protected Boolean getDefaultFireResistance() {
        return false;
    }

}
