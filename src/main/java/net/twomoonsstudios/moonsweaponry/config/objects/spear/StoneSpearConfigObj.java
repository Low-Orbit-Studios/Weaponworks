package net.twomoonsstudios.moonsweaponry.config.objects.spear;

import net.minecraft.world.item.Tiers;
import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.spear.SpearConfigObj;

import java.lang.reflect.Type;

import static net.twomoonsstudios.moonsweaponry.constants.WeaponDataConstants.STONE_SPEAR_DEFAULT_DMG;
import static net.twomoonsstudios.moonsweaponry.constants.WeaponDataConstants.STONE_SPEAR_DEFAULT_TIER_NAME;

public class StoneSpearConfigObj extends SpearConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public StoneSpearConfigObj(Type myType, String myID) {
        super(myType, myID);
    }
    public StoneSpearConfigObj(String myId){
        super(StoneSpearConfigObj.class, myId);
    }

    public StoneSpearConfigObj(Type myType, String myID, MoonsWeaponsConfig.WeaponInfo configData) {
        super(myType, myID, configData);
    }

    public StoneSpearConfigObj(String weaponId, MoonsWeaponsConfig.WeaponInfo objData) {
        super(StoneSpearConfigObj.class, weaponId, objData);
    }

    @Override
    protected String getDefaultTier() {
        return STONE_SPEAR_DEFAULT_TIER_NAME;
    }

    @Override
    protected Integer getDefaultDamage() {
        return STONE_SPEAR_DEFAULT_DMG;
    }

    @Override
    protected Integer getDefaultDurability() {
        return Tiers.STONE.getUses();
    }
}
