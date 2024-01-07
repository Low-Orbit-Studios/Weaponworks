package net.twomoonsstudios.moonsweaponry.config.objects.mace;

import net.minecraft.world.item.Tiers;
import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.mace.MaceConfigObj;

import java.lang.reflect.Type;

import static net.twomoonsstudios.moonsweaponry.constants.WeaponDataConstants.IRON_MACE_DEFAULT_DMG;
import static net.twomoonsstudios.moonsweaponry.constants.WeaponDataConstants.IRON_MACE_DEFAULT_TIER_NAME;

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

    public IronMaceConfigObj(Type myType, String myID, MoonsWeaponsConfig.WeaponInfo configData) {
        super(myType, myID, configData);
    }

    public IronMaceConfigObj(String weaponId, MoonsWeaponsConfig.WeaponInfo objData) {
        super(IronMaceConfigObj.class, weaponId, objData);
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
        return Tiers.IRON.getUses();
    }
}
