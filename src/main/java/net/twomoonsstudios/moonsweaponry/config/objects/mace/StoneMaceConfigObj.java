package net.twomoonsstudios.moonsweaponry.config.objects.mace;

import net.minecraft.world.item.Tiers;
import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.mace.MaceConfigObj;

import java.lang.reflect.Type;

import static net.twomoonsstudios.moonsweaponry.constants.WeaponDataConstants.STONE_MACE_DEFAULT_DMG;
import static net.twomoonsstudios.moonsweaponry.constants.WeaponDataConstants.STONE_MACE_DEFAULT_TIER_NAME;

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

    public StoneMaceConfigObj(Type myType, String myID, MoonsWeaponsConfig.WeaponInfo configData) {
        super(myType, myID, configData);
    }

    public StoneMaceConfigObj(String weaponId, MoonsWeaponsConfig.WeaponInfo objData) {
        super(StoneMaceConfigObj.class, weaponId, objData);
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
        return Tiers.STONE.getUses();
    }
}
