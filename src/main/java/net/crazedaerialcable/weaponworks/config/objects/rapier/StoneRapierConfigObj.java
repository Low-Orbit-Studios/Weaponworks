package net.crazedaerialcable.weaponworks.config.objects.rapier;

import net.minecraft.item.ToolMaterials;

import java.lang.reflect.Type;

import static net.crazedaerialcable.weaponworks.constants.WeaponDataConstants.STONE_RAPIER_DEFAULT_DMG;
import static net.crazedaerialcable.weaponworks.constants.WeaponDataConstants.STONE_RAPIER_DEFAULT_TIER_NAME;

public class StoneRapierConfigObj extends RapierConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public StoneRapierConfigObj(Type myType, String myID) {
        super(myType, myID);
    }
    public StoneRapierConfigObj(String myId){
        super(StoneRapierConfigObj.class, myId);
    }



    @Override
    protected String getDefaultTier() {
        return STONE_RAPIER_DEFAULT_TIER_NAME;
    }

    @Override
    protected Integer getDefaultDamage() {
        return STONE_RAPIER_DEFAULT_DMG;
    }

    @Override
    protected Integer getDefaultDurability() {
        return ToolMaterials.STONE.getDurability();
    }
}
