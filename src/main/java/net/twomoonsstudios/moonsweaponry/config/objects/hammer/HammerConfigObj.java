package net.twomoonsstudios.moonsweaponry.config.objects.hammer;

import net.twomoonsstudios.moonsweaponry.config.objects.WeaponConfigObj;

import java.lang.reflect.Type;

import static net.twomoonsstudios.moonsweaponry.constants.WeaponDataConstants.HAMMER_DEFAULT_ATK_SPD;

public abstract class HammerConfigObj extends WeaponConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public HammerConfigObj(Type myType, String myID) {
        super(myType, myID);
    }
    @Override
    public Float getDefaultAttackSpeed(){
        return HAMMER_DEFAULT_ATK_SPD;
    }

    @Override
    protected Boolean getDefaultFireResistance() {
        return false;
    }

}
