package net.twomoonsstudios.moonsweaponry.config.objects.spear;

import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.WeaponConfigObj;

import java.lang.reflect.Type;

import static net.twomoonsstudios.moonsweaponry.constants.WeaponDataConstants.*;

public abstract class SpearConfigObj extends WeaponConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public SpearConfigObj(Type myType, String myID) {
        super(myType, myID);
    }

    public SpearConfigObj(Type myType, String myID, MoonsWeaponsConfig.WeaponInfo configData) {
        super(myType, myID, configData);
    }

    @Override
    public Float getDefaultAttackSpeed(){
        return DEFAULT_ATTACK_SPEED - SPEAR_DEFAULT_ATK_SPD;
    }

    @Override
    protected Boolean getDefaultFireResistance() {
        return false;
    }
}
