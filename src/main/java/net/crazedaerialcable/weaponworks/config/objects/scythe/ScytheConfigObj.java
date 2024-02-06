package net.crazedaerialcable.weaponworks.config.objects.scythe;

import net.crazedaerialcable.weaponworks.config.WeaponworksConfig;
import net.crazedaerialcable.weaponworks.config.objects.WeaponConfigObj;

import java.lang.reflect.Type;

import static net.crazedaerialcable.weaponworks.constants.WeaponDataConstants.DEFAULT_ATTACK_SPEED;
import static net.crazedaerialcable.weaponworks.constants.WeaponDataConstants.SCYTHE_DEFAULT_ATK_SPD;

public abstract class ScytheConfigObj extends WeaponConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public ScytheConfigObj(Type myType, String myID) {
        super(myType, myID);
    }

    public ScytheConfigObj(Type myType, String weaponId, WeaponworksConfig.WeaponInfo objData) {
        super(myType, weaponId, objData);
    }

    @Override
    public Float getDefaultAttackSpeed(){
        return DEFAULT_ATTACK_SPEED + SCYTHE_DEFAULT_ATK_SPD;
    }

    @Override
    protected Boolean getDefaultFireResistance() {
        return false;
    }

}
