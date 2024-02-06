package net.crazedaerialcable.weaponworks.config.objects.katana;

import net.minecraft.item.ToolMaterials;

import java.lang.reflect.Type;

import static net.crazedaerialcable.weaponworks.constants.WeaponDataConstants.IRON_KATANA_DEFAULT_DMG;
import static net.crazedaerialcable.weaponworks.constants.WeaponDataConstants.IRON_KATANA_DEFAULT_TIER_NAME;

public class IronKatanaConfigObj extends KatanaConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public IronKatanaConfigObj(Type myType, String myID) {
        super(myType, myID);
    }
    public IronKatanaConfigObj(String myId){
        super(IronKatanaConfigObj.class, myId);
    }



    @Override
    protected String getDefaultTier() {
        return IRON_KATANA_DEFAULT_TIER_NAME;
    }

    @Override
    protected Integer getDefaultDamage() {
        return IRON_KATANA_DEFAULT_DMG;
    }

    @Override
    protected Integer getDefaultDurability() {
        return ToolMaterials.IRON.getDurability();
    }
}
