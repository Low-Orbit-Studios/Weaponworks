package net.crazedaerialcable.weaponworks.config.objects.mace;

import net.minecraft.item.ToolMaterials;

import java.lang.reflect.Type;

import static net.crazedaerialcable.weaponworks.constants.WeaponDataConstants.IRON_MACE_DEFAULT_DMG;
import static net.crazedaerialcable.weaponworks.constants.WeaponDataConstants.IRON_MACE_DEFAULT_TIER_NAME;

public class IronMaceConfigObj extends MaceConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public IronMaceConfigObj(Type myType, String myID) {
        super(myType, myID);
    }
    public IronMaceConfigObj(String myId){
        super(IronMaceConfigObj.class, myId);
    }

    



    @Override
    protected String getDefaultTier() {
        return IRON_MACE_DEFAULT_TIER_NAME;
    }

    @Override
    protected Integer getDefaultDamage() {
        return IRON_MACE_DEFAULT_DMG;
    }

    @Override
    protected Integer getDefaultDurability() {
        return ToolMaterials.IRON.getDurability();
    }
}
