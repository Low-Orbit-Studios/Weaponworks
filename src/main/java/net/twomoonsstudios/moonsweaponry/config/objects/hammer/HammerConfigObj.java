package net.twomoonsstudios.moonsweaponry.config.objects.hammer;

import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.WeaponConfigObj;
import net.twomoonsstudios.moonsweaponry.config.objects.halberd.WoodenHalberdConfigObj;

import java.lang.reflect.Type;

import static net.twomoonsstudios.moonsweaponry.constants.WeaponDataConstants.DEFAULT_ATTACK_SPEED;
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

    public HammerConfigObj(Type myType, String weaponId, MoonsWeaponsConfig.WeaponInfo objData) {
        super(myType, weaponId, objData);
    }

    @Override
    public Float getDefaultAttackSpeed(){
        return DEFAULT_ATTACK_SPEED - HAMMER_DEFAULT_ATK_SPD;
    }

    @Override
    protected Boolean getDefaultFireResistance() {
        return false;
    }

}
