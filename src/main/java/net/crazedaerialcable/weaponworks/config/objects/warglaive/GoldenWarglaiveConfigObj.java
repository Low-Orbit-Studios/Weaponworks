package net.crazedaerialcable.weaponworks.config.objects.warglaive;

import net.minecraft.item.ToolMaterials;

import java.lang.reflect.Type;

import static net.crazedaerialcable.weaponworks.constants.WeaponDataConstants.*;

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
