package net.twomoonsstudios.moonsweaponry.config.objects.scythe;

import net.minecraft.world.item.Tiers;
import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;

import java.lang.reflect.Type;

import static net.twomoonsstudios.moonsweaponry.constants.MeleeWeaponDataConstants.DIAMOND_SCYTHE_DEFAULT_DMG;
import static net.twomoonsstudios.moonsweaponry.constants.MeleeWeaponDataConstants.DIAMOND_SCYTHE_DEFAULT_TIER_NAME;

public class DiamondScytheConfigObj extends ScytheConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public DiamondScytheConfigObj(Type myType, String myID) {
        super(myType, myID);
    }
    public DiamondScytheConfigObj(String myId){
        super(DiamondScytheConfigObj.class, myId);
    }

    public DiamondScytheConfigObj(String weaponId, MoonsWeaponsConfig.WeaponInfo objData) {
        super(DiamondScytheConfigObj.class, weaponId, objData);
    }

    @Override
    protected String getDefaultTier() {
        return DIAMOND_SCYTHE_DEFAULT_TIER_NAME;
    }

    @Override
    protected Integer getDefaultDamage() {
        return DIAMOND_SCYTHE_DEFAULT_DMG;
    }

    @Override
    protected Integer getDefaultDurability() {
        return Tiers.DIAMOND.getUses();
    }
}
