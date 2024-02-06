package net.crazedaerialcable.weaponworks.config.objects.scythe;

import net.minecraft.item.ToolMaterials;

import java.lang.reflect.Type;

import static net.crazedaerialcable.weaponworks.constants.WeaponDataConstants.DIAMOND_SCYTHE_DEFAULT_DMG;
import static net.crazedaerialcable.weaponworks.constants.WeaponDataConstants.DIAMOND_SCYTHE_DEFAULT_TIER_NAME;

public class DiamondScytheConfigObj extends ScytheConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public DiamondScytheConfigObj(Type myType, String myID) {
        super(myType, myID);
    }
    public DiamondScytheConfigObj(String myId){
        super(DiamondScytheConfigObj.class, myId);
    }



    @Override
    protected String getDefaultTier() {
        return DIAMOND_SCYTHE_DEFAULT_TIER_NAME;
    }

    @Override
    protected Integer getDefaultDamage() {
        return DIAMOND_SCYTHE_DEFAULT_DMG;
    }

    @Override
    protected Integer getDefaultDurability() {
        return ToolMaterials.DIAMOND.getDurability();
    }
}
