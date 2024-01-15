package net.twomoonsstudios.moonsweaponry.config.objects.mace;

import net.minecraft.world.item.Tiers;
import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.mace.MaceConfigObj;

import java.lang.reflect.Type;

import static net.twomoonsstudios.moonsweaponry.constants.WeaponDataConstants.WOODEN_MACE_DEFAULT_DMG;
import static net.twomoonsstudios.moonsweaponry.constants.WeaponDataConstants.WOODEN_MACE_DEFAULT_TIER_NAME;

public class WoodenMaceConfigObj extends MaceConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public WoodenMaceConfigObj(Type myType, String myID) {
        super(myType, myID);
    }
    public WoodenMaceConfigObj(String myId){
        super(WoodenMaceConfigObj.class, myId);
    }

    public WoodenMaceConfigObj(Type myType, String myID, MoonsWeaponsConfig.WeaponInfo configData) {
        super(myType, myID, configData);
    }

    public WoodenMaceConfigObj(String weaponId, MoonsWeaponsConfig.WeaponInfo objData) {
        super(WoodenMaceConfigObj.class, weaponId, objData);
    }

    @Override
    protected String getDefaultTier() {
        return WOODEN_MACE_DEFAULT_TIER_NAME;
    }

    @Override
    protected Integer getDefaultDamage() {
        return WOODEN_MACE_DEFAULT_DMG;
    }

    @Override
    protected Integer getDefaultDurability() {
        return Tiers.WOOD.getUses();
    }
}
