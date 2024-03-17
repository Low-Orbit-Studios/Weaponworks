package net.twomoonsstudios.moonsweaponry.config.objects.katana;

import net.minecraft.world.item.Tiers;
import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;

import java.lang.reflect.Type;

import static net.twomoonsstudios.moonsweaponry.constants.WeaponDataConstants.DIAMOND_KATANA_DEFAULT_DMG;
import static net.twomoonsstudios.moonsweaponry.constants.WeaponDataConstants.DIAMOND_KATANA_DEFAULT_TIER_NAME;

public class DiamondKatanaConfigObj extends KatanaConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public DiamondKatanaConfigObj(Type myType, String myID) {
        super(myType, myID);
    }
    public DiamondKatanaConfigObj(String myId){
        super(DiamondKatanaConfigObj.class, myId);
    }

    public DiamondKatanaConfigObj(String weaponId, MoonsWeaponsConfig.WeaponInfo objData) {
        super(DiamondKatanaConfigObj.class, weaponId, objData);
    }

    @Override
    protected String getDefaultTier() {
        return DIAMOND_KATANA_DEFAULT_TIER_NAME;
    }

    @Override
    protected Integer getDefaultDamage() {
        return DIAMOND_KATANA_DEFAULT_DMG;
    }

    @Override
    protected Integer getDefaultDurability() {
        return Tiers.DIAMOND.getUses();
    }
}
