package net.twomoonsstudios.moonsweaponry.config.objects.mace;

import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.WeaponConfigObj;

import java.lang.reflect.Type;

import static net.twomoonsstudios.moonsweaponry.constants.WeaponDataConstants.*;

public abstract class MaceConfigObj extends WeaponConfigObj {
    public MaceConfigObj(Type myType, String myID) {
        super(myType, myID);
    }

    public MaceConfigObj(Type myType, String myID, MoonsWeaponsConfig.WeaponInfo configData) {
        super(myType, myID, configData);
    }

    @Override
    protected Float getDefaultAttackSpeed() {
        return DEFAULT_ATTACK_SPEED - MACE_DEFAULT_ATK_SPD;
    }

    @Override
    protected Boolean getDefaultFireResistance() {
        return false;
    }
}
