package net.twomoonsstudios.moonsweaponry.config.objects.warglaive;

import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;

import java.lang.reflect.Type;

import static net.twomoonsstudios.moonsweaponry.constants.MeleeWeaponDataConstants.*;

public class GoldenWarglaiveConfigObj extends WarglaiveConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public GoldenWarglaiveConfigObj(Type myType, String myID) {
        super(myType, myID);
    }
    public GoldenWarglaiveConfigObj(String myId){
        super(GoldenWarglaiveConfigObj.class, myId);
    }

    public GoldenWarglaiveConfigObj(String weaponId, MoonsWeaponsConfig.WeaponInfo objData) {
        super(GoldenWarglaiveConfigObj.class, weaponId, objData);
    }

    @Override
    protected String getDefaultTier() {
        return GOLDEN_WARGLAIVE_DEFAULT_TIER_NAME;
    }

    @Override
    protected Integer getDefaultDamage() {
        return GOLDEN_WARGLAIVE_DEFAULT_DMG;
    }

    @Override
    protected Integer getDefaultDurability() {
        return GOLDEN_ITEMS_DURABILITY;
    }
}
