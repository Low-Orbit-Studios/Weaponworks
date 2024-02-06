package net.crazedaerialcable.weaponworks.config.objects.spear;


import java.lang.reflect.Type;

import static net.crazedaerialcable.weaponworks.constants.WeaponDataConstants.*;

public class GoldenSpearConfigObj extends SpearConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public GoldenSpearConfigObj(Type myType, String myID) {
        super(myType, myID);
    }
    public GoldenSpearConfigObj(String myId){
        super(GoldenSpearConfigObj.class, myId);
    }


    @Override
    protected String getDefaultTier() {
        return GOLDEN_SPEAR_DEFAULT_TIER_NAME;
    }

    @Override
    protected Integer getDefaultDamage() {
        return GOLDEN_SPEAR_DEFAULT_DMG;
    }

    @Override
    protected Integer getDefaultDurability() {
        return GOLDEN_ITEMS_DURABILITY;
    }
}
