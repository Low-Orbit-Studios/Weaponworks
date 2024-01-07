package net.twomoonsstudios.moonsweaponry.config.objects.halberd;

import net.minecraft.world.item.Tiers;
import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;

import java.lang.reflect.Type;

import static net.twomoonsstudios.moonsweaponry.constants.WeaponDataConstants.GOLDEN_HALBERD_DEFAULT_DMG;
import static net.twomoonsstudios.moonsweaponry.constants.WeaponDataConstants.GOLDEN_HALBERD_DEFAULT_TIER_NAME;

public class GoldenHalberdConfigObj extends HalberdConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public GoldenHalberdConfigObj(Type myType, String myID) {
        super(myType, myID);
    }
    public GoldenHalberdConfigObj(String myId){
        super(GoldenHalberdConfigObj.class, myId);
    }

    public GoldenHalberdConfigObj(String weaponId, MoonsWeaponsConfig.WeaponInfo objData) {
        super(GoldenHalberdConfigObj.class, weaponId, objData);
    }

    @Override
    protected String getDefaultTier() {
        return GOLDEN_HALBERD_DEFAULT_TIER_NAME;
    }

    @Override
    protected Integer getDefaultDamage() {
        return GOLDEN_HALBERD_DEFAULT_DMG;
    }

    @Override
    protected Integer getDefaultDurability() {
        return Tiers.GOLD.getUses();
    }
}
