package net.twomoonsstudios.moonsweaponry.config.objects.spear;

import net.minecraft.world.item.Tiers;
import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;

import java.lang.reflect.Type;

import static net.twomoonsstudios.moonsweaponry.constants.MeleeWeaponDataConstants.DIAMOND_SPEAR_DEFAULT_DMG;
import static net.twomoonsstudios.moonsweaponry.constants.MeleeWeaponDataConstants.DIAMOND_SPEAR_DEFAULT_TIER_NAME;

public class DiamondSpearConfigObj extends SpearConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public DiamondSpearConfigObj(Type myType, String myID) {
        super(myType, myID);
    }
    public DiamondSpearConfigObj(Type myType, String myID, MoonsWeaponsConfig.WeaponInfo configData){
        super(myType, myID, configData);
    }

    public DiamondSpearConfigObj(String myId){
        super(DiamondSpearConfigObj.class, myId);
    }

    public DiamondSpearConfigObj(String weaponId, MoonsWeaponsConfig.WeaponInfo objData) {
        super(DiamondSpearConfigObj.class, weaponId, objData);
    }

    @Override
    protected String getDefaultTier() {
        return DIAMOND_SPEAR_DEFAULT_TIER_NAME;
    }

    @Override
    protected Integer getDefaultDamage() {
        return DIAMOND_SPEAR_DEFAULT_DMG;
    }

    @Override
    protected Integer getDefaultDurability() {
        return Tiers.DIAMOND.getUses();
    }
}
