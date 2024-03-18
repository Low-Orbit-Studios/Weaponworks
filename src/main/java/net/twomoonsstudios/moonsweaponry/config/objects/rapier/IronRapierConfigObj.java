package net.twomoonsstudios.moonsweaponry.config.objects.rapier;

import net.minecraft.world.item.Tiers;
import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;

import java.lang.reflect.Type;

import static net.twomoonsstudios.moonsweaponry.constants.MeleeWeaponDataConstants.IRON_RAPIER_DEFAULT_DMG;
import static net.twomoonsstudios.moonsweaponry.constants.MeleeWeaponDataConstants.IRON_RAPIER_DEFAULT_TIER_NAME;

public class IronRapierConfigObj extends RapierConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public IronRapierConfigObj(Type myType, String myID) {
        super(myType, myID);
    }
    public IronRapierConfigObj(String myId){
        super(IronRapierConfigObj.class, myId);
    }

    public IronRapierConfigObj(String weaponId, MoonsWeaponsConfig.WeaponInfo objData) {
        super(IronRapierConfigObj.class, weaponId, objData);
    }

    @Override
    protected String getDefaultTier() {
        return IRON_RAPIER_DEFAULT_TIER_NAME;
    }

    @Override
    protected Integer getDefaultDamage() {
        return IRON_RAPIER_DEFAULT_DMG;
    }

    @Override
    protected Integer getDefaultDurability() {
        return Tiers.IRON.getUses();
    }
}
