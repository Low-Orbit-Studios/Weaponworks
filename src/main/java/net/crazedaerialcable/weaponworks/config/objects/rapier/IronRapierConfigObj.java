package net.crazedaerialcable.weaponworks.config.objects.rapier;

import net.minecraft.item.ToolMaterials;

import java.lang.reflect.Type;

import static net.crazedaerialcable.weaponworks.constants.WeaponDataConstants.IRON_RAPIER_DEFAULT_DMG;
import static net.crazedaerialcable.weaponworks.constants.WeaponDataConstants.IRON_RAPIER_DEFAULT_TIER_NAME;

public class IronRapierConfigObj extends RapierConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public IronRapierConfigObj(Type myType, String myID) {
        super(myType, myID);
    }
    public IronRapierConfigObj(String myId){
        super(IronRapierConfigObj.class, myId);
    }



    @Override
    protected String getDefaultTier() {
        return IRON_RAPIER_DEFAULT_TIER_NAME;
    }

    @Override
    protected Integer getDefaultDamage() {
        return IRON_RAPIER_DEFAULT_DMG;
    }

    @Override
    protected Integer getDefaultDurability() {
        return ToolMaterials.IRON.getDurability();
    }
}
