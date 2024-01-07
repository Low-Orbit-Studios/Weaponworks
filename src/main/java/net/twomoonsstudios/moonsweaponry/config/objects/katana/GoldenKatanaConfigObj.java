package net.twomoonsstudios.moonsweaponry.config.objects.katana;

import net.minecraft.world.item.Tiers;
import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;

import java.lang.reflect.Type;

import static net.twomoonsstudios.moonsweaponry.constants.WeaponDataConstants.GOLDEN_KATANA_DEFAULT_DMG;
import static net.twomoonsstudios.moonsweaponry.constants.WeaponDataConstants.GOLDEN_KATANA_DEFAULT_TIER_NAME;

public class GoldenKatanaConfigObj extends KatanaConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public GoldenKatanaConfigObj(Type myType, String myID) {
        super(myType, myID);
    }
    public GoldenKatanaConfigObj(String myId){
        super(GoldenKatanaConfigObj.class, myId);
    }

    public GoldenKatanaConfigObj(String weaponId, MoonsWeaponsConfig.WeaponInfo objData) {
        super(GoldenKatanaConfigObj.class, weaponId, objData);
    }

    @Override
    protected String getDefaultTier() {
        return GOLDEN_KATANA_DEFAULT_TIER_NAME;
    }

    @Override
    protected Integer getDefaultDamage() {
        return GOLDEN_KATANA_DEFAULT_DMG;
    }

    @Override
    protected Integer getDefaultDurability() {
        return Tiers.GOLD.getUses();
    }
}
