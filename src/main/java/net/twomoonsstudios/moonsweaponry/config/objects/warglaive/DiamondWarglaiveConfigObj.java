package net.twomoonsstudios.moonsweaponry.config.objects.warglaive;

import net.minecraft.world.item.Tiers;
import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;

import java.lang.reflect.Type;

import static net.twomoonsstudios.moonsweaponry.constants.MeleeWeaponDataConstants.DIAMOND_WARGLAIVE_DEFAULT_DMG;
import static net.twomoonsstudios.moonsweaponry.constants.MeleeWeaponDataConstants.DIAMOND_WARGLAIVE_DEFAULT_TIER_NAME;

public class DiamondWarglaiveConfigObj extends WarglaiveConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public DiamondWarglaiveConfigObj(Type myType, String myID) {
        super(myType, myID);
    }
    public DiamondWarglaiveConfigObj(String myId){
        super(DiamondWarglaiveConfigObj.class, myId);
    }

    public DiamondWarglaiveConfigObj(String weaponId, MoonsWeaponsConfig.WeaponInfo objData) {
        super(DiamondWarglaiveConfigObj.class, weaponId, objData);
    }

    @Override
    protected String getDefaultTier() {
        return DIAMOND_WARGLAIVE_DEFAULT_TIER_NAME;
    }

    @Override
    protected Integer getDefaultDamage() {
        return DIAMOND_WARGLAIVE_DEFAULT_DMG;
    }

    @Override
    protected Integer getDefaultDurability() {
        return Tiers.DIAMOND.getUses();
    }
}
