package net.twomoonsstudios.moonsweaponry.config.objects.hammer;

import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;

import java.lang.reflect.Type;

import static net.twomoonsstudios.moonsweaponry.constants.MeleeWeaponDataConstants.*;

public class GoldenHammerConfigObj extends HammerConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public GoldenHammerConfigObj(Type myType, String myID) {
        super(myType, myID);
    }
    public GoldenHammerConfigObj(String myId){
        super(GoldenHammerConfigObj.class, myId);
    }

    public GoldenHammerConfigObj(String weaponId, MoonsWeaponsConfig.WeaponInfo objData) {
        super(GoldenHammerConfigObj.class, weaponId, objData);
    }

    @Override
    protected String getDefaultTier() {
        return GOLDEN_HAMMER_DEFAULT_TIER_NAME;
    }

    @Override
    protected Integer getDefaultDamage() {
        return GOLDEN_HAMMER_DEFAULT_DMG;
    }

    @Override
    protected Integer getDefaultDurability() {
        return GOLDEN_ITEMS_DURABILITY;
    }
}
