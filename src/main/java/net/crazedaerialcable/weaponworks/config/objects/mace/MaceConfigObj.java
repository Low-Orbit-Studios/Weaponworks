package net.crazedaerialcable.weaponworks.config.objects.mace;

import net.crazedaerialcable.weaponworks.config.WeaponworksConfig;
import net.crazedaerialcable.weaponworks.config.objects.WeaponConfigObj;

import java.lang.reflect.Type;

import static net.crazedaerialcable.weaponworks.constants.WeaponDataConstants.*;

public abstract class MaceConfigObj extends WeaponConfigObj {
    public MaceConfigObj(Type myType, String myID) {
        super(myType, myID);
    }

    

    @Override
    protected Float getDefaultAttackSpeed() {
        return DEFAULT_ATTACK_SPEED + MACE_DEFAULT_ATK_SPD;
    }

    @Override
    protected Boolean getDefaultFireResistance() {
        return false;
    }
}
