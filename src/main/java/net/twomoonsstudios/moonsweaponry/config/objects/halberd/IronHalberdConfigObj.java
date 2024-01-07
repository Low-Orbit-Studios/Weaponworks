package net.twomoonsstudios.moonsweaponry.config.objects.halberd;

import net.minecraft.world.item.Tiers;
import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;

import java.lang.reflect.Type;

import static net.twomoonsstudios.moonsweaponry.constants.WeaponDataConstants.IRON_HALBERD_DEFAULT_DMG;
import static net.twomoonsstudios.moonsweaponry.constants.WeaponDataConstants.IRON_HALBERD_DEFAULT_TIER_NAME;

public class IronHalberdConfigObj extends HalberdConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public IronHalberdConfigObj(Type myType, String myID) {
        super(myType, myID);
    }
    public IronHalberdConfigObj(String myId){
        super(IronHalberdConfigObj.class, myId);
    }

    public IronHalberdConfigObj(String weaponId, MoonsWeaponsConfig.WeaponInfo objData) {
        super(IronHalberdConfigObj.class, weaponId, objData);
    }

    @Override
    protected String getDefaultTier() {
        return IRON_HALBERD_DEFAULT_TIER_NAME;
    }

    @Override
    protected Integer getDefaultDamage() {
        return IRON_HALBERD_DEFAULT_DMG;
    }

    @Override
    protected Integer getDefaultDurability() {
        return Tiers.IRON.getUses();
    }
}
