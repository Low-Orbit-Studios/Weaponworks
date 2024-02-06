package net.crazedaerialcable.weaponworks.config.objects.spear;

import net.minecraft.item.ToolMaterials;

import java.lang.reflect.Type;

import static net.crazedaerialcable.weaponworks.constants.WeaponDataConstants.IRON_SPEAR_DEFAULT_DMG;
import static net.crazedaerialcable.weaponworks.constants.WeaponDataConstants.IRON_SPEAR_DEFAULT_TIER_NAME;

public class IronSpearConfigObj extends SpearConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public IronSpearConfigObj(Type myType, String myID) {
        super(myType, myID);
    }
    public IronSpearConfigObj(String myId){
        super(IronSpearConfigObj.class, myId);
    }

    @Override
    protected String getDefaultTier() {
        return IRON_SPEAR_DEFAULT_TIER_NAME;
    }

    @Override
    protected Integer getDefaultDamage() {
        return IRON_SPEAR_DEFAULT_DMG;
    }

    @Override
    protected Integer getDefaultDurability() {
        return ToolMaterials.IRON.getDurability();
    }
}
