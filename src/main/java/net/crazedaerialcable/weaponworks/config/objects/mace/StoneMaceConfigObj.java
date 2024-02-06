package net.crazedaerialcable.weaponworks.config.objects.mace;

import net.minecraft.item.ToolMaterials;

import java.lang.reflect.Type;

import static net.crazedaerialcable.weaponworks.constants.WeaponDataConstants.STONE_MACE_DEFAULT_DMG;
import static net.crazedaerialcable.weaponworks.constants.WeaponDataConstants.STONE_MACE_DEFAULT_TIER_NAME;

public class StoneMaceConfigObj extends MaceConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public StoneMaceConfigObj(Type myType, String myID) {
        super(myType, myID);
    }
    public StoneMaceConfigObj(String myId){
        super(StoneMaceConfigObj.class, myId);
    }

    



    @Override
    protected String getDefaultTier() {
        return STONE_MACE_DEFAULT_TIER_NAME;
    }

    @Override
    protected Integer getDefaultDamage() {
        return STONE_MACE_DEFAULT_DMG;
    }

    @Override
    protected Integer getDefaultDurability() {
        return ToolMaterials.STONE.getDurability();
    }
}
