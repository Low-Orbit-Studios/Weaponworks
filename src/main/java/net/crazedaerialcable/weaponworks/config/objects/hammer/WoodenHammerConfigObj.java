package net.crazedaerialcable.weaponworks.config.objects.hammer;

import net.minecraft.item.ToolMaterials;

import java.lang.reflect.Type;

import static net.crazedaerialcable.weaponworks.constants.WeaponDataConstants.WOODEN_HAMMER_DEFAULT_DMG;
import static net.crazedaerialcable.weaponworks.constants.WeaponDataConstants.WOODEN_HAMMER_DEFAULT_TIER_NAME;

public class WoodenHammerConfigObj extends HammerConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public WoodenHammerConfigObj(Type myType, String myID) {
        super(myType, myID);
    }
    public WoodenHammerConfigObj(String myId){
        super(WoodenHammerConfigObj.class, myId);
    }



    @Override
    protected String getDefaultTier() {
        return WOODEN_HAMMER_DEFAULT_TIER_NAME;
    }

    @Override
    protected Integer getDefaultDamage() {
        return WOODEN_HAMMER_DEFAULT_DMG;
    }

    @Override
    protected Integer getDefaultDurability() {
        return ToolMaterials.WOOD.getDurability();
    }
}
