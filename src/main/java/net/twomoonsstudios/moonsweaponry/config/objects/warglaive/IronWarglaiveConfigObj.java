package net.twomoonsstudios.moonsweaponry.config.objects.warglaive;

import net.minecraft.world.item.Tiers;
import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;

import java.lang.reflect.Type;

import static net.twomoonsstudios.moonsweaponry.constants.MeleeWeaponDataConstants.IRON_WARGLAIVE_DEFAULT_DMG;
import static net.twomoonsstudios.moonsweaponry.constants.MeleeWeaponDataConstants.IRON_WARGLAIVE_DEFAULT_TIER_NAME;

public class IronWarglaiveConfigObj extends WarglaiveConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public IronWarglaiveConfigObj(Type myType, String myID) {
        super(myType, myID);
    }
    public IronWarglaiveConfigObj(String myId){
        super(IronWarglaiveConfigObj.class, myId);
    }

    public IronWarglaiveConfigObj(String weaponId, MoonsWeaponsConfig.WeaponInfo objData) {
        super(IronWarglaiveConfigObj.class, weaponId, objData);
    }

    @Override
    protected String getDefaultTier() {
        return IRON_WARGLAIVE_DEFAULT_TIER_NAME;
    }

    @Override
    protected Integer getDefaultDamage() {
        return IRON_WARGLAIVE_DEFAULT_DMG;
    }

    @Override
    protected Integer getDefaultDurability() {
        return Tiers.IRON.getUses();
    }
}
