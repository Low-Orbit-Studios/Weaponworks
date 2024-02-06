package net.crazedaerialcable.weaponworks.config.objects.katana;

import net.minecraft.item.ToolMaterials;

import java.lang.reflect.Type;

import static net.crazedaerialcable.weaponworks.constants.WeaponDataConstants.DIAMOND_KATANA_DEFAULT_DMG;
import static net.crazedaerialcable.weaponworks.constants.WeaponDataConstants.DIAMOND_KATANA_DEFAULT_TIER_NAME;

public class DiamondKatanaConfigObj extends KatanaConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public DiamondKatanaConfigObj(Type myType, String myID) {
        super(myType, myID);
    }
    public DiamondKatanaConfigObj(String myId){
        super(DiamondKatanaConfigObj.class, myId);
    }



    @Override
    protected String getDefaultTier() {
        return DIAMOND_KATANA_DEFAULT_TIER_NAME;
    }

    @Override
    protected Integer getDefaultDamage() {
        return DIAMOND_KATANA_DEFAULT_DMG;
    }

    @Override
    protected Integer getDefaultDurability() {
        return ToolMaterials.DIAMOND.getDurability();
    }
}
