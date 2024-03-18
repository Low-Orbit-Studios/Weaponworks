package net.twomoonsstudios.moonsweaponry.config.objects.hammer;

import net.minecraft.world.item.Tiers;
import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;

import java.lang.reflect.Type;

import static net.twomoonsstudios.moonsweaponry.constants.MeleeWeaponDataConstants.DIAMOND_HAMMER_DEFAULT_DMG;
import static net.twomoonsstudios.moonsweaponry.constants.MeleeWeaponDataConstants.DIAMOND_HAMMER_DEFAULT_TIER_NAME;

public class DiamondHammerConfigObj extends HammerConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public DiamondHammerConfigObj(Type myType, String myID) {
        super(myType, myID);
    }
    public DiamondHammerConfigObj(String myId){
        super(DiamondHammerConfigObj.class, myId);
    }

    public DiamondHammerConfigObj(String weaponId, MoonsWeaponsConfig.WeaponInfo objData) {
        super(DiamondHammerConfigObj.class, weaponId, objData);
    }

    @Override
    protected String getDefaultTier() {
        return DIAMOND_HAMMER_DEFAULT_TIER_NAME;
    }

    @Override
    protected Integer getDefaultDamage() {
        return DIAMOND_HAMMER_DEFAULT_DMG;
    }

    @Override
    protected Integer getDefaultDurability() {
        return Tiers.DIAMOND.getUses();
    }
}
