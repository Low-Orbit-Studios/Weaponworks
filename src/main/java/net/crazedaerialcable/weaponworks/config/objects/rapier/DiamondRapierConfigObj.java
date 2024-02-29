package net.crazedaerialcable.weaponworks.config.objects.rapier;

import net.minecraft.item.ToolMaterials;

import java.lang.reflect.Type;

import static net.crazedaerialcable.weaponworks.constants.WeaponDataConstants.DIAMOND_RAPIER_DEFAULT_DMG;
import static net.crazedaerialcable.weaponworks.constants.WeaponDataConstants.DIAMOND_RAPIER_DEFAULT_TIER_NAME;

public class DiamondRapierConfigObj extends RapierConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public DiamondRapierConfigObj(Type myType, String myID) {
        super(myType, myID);
    }
    public DiamondRapierConfigObj(String myId){
        super(DiamondRapierConfigObj.class, myId);
    }



    @Override
    protected String getDefaultTier() {
        return DIAMOND_RAPIER_DEFAULT_TIER_NAME;
    }

    @Override
    protected Integer getDefaultDamage() {
        return DIAMOND_RAPIER_DEFAULT_DMG;
    }

    @Override
    protected Integer getDefaultDurability() {
        return ToolMaterials.DIAMOND.getDurability();
    }
}