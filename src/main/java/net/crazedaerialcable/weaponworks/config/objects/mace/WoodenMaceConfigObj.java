package net.crazedaerialcable.weaponworks.config.objects.mace;

import net.minecraft.item.ToolMaterials;

import java.lang.reflect.Type;

import static net.crazedaerialcable.weaponworks.constants.WeaponDataConstants.WOODEN_MACE_DEFAULT_DMG;
import static net.crazedaerialcable.weaponworks.constants.WeaponDataConstants.WOODEN_MACE_DEFAULT_TIER_NAME;

public class WoodenMaceConfigObj extends MaceConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public WoodenMaceConfigObj(Type myType, String myID) {
        super(myType, myID);
    }
    public WoodenMaceConfigObj(String myId){
        super(WoodenMaceConfigObj.class, myId);
    }

    



    @Override
    protected String getDefaultTier() {
        return WOODEN_MACE_DEFAULT_TIER_NAME;
    }

    @Override
    protected Integer getDefaultDamage() {
        return WOODEN_MACE_DEFAULT_DMG;
    }

    @Override
    protected Integer getDefaultDurability() {
        return ToolMaterials.WOOD.getDurability();
    }
}
