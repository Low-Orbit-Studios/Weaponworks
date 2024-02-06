package net.crazedaerialcable.weaponworks.config.objects.katana;

import net.minecraft.item.ToolMaterials;

import java.lang.reflect.Type;

import static net.crazedaerialcable.weaponworks.constants.WeaponDataConstants.STONE_KATANA_DEFAULT_DMG;
import static net.crazedaerialcable.weaponworks.constants.WeaponDataConstants.STONE_KATANA_DEFAULT_TIER_NAME;

public class StoneKatanaConfigObj extends KatanaConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public StoneKatanaConfigObj(Type myType, String myID) {
        super(myType, myID);
    }
    public StoneKatanaConfigObj(String myId){
        super(StoneKatanaConfigObj.class, myId);
    }



    @Override
    protected String getDefaultTier() {
        return STONE_KATANA_DEFAULT_TIER_NAME;
    }

    @Override
    protected Integer getDefaultDamage() {
        return STONE_KATANA_DEFAULT_DMG;
    }

    @Override
    protected Integer getDefaultDurability() {
        return ToolMaterials.STONE.getDurability();
    }
}
