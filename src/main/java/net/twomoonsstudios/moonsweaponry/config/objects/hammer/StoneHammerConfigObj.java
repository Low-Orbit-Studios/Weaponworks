package net.twomoonsstudios.moonsweaponry.config.objects.hammer;

import net.minecraft.world.item.Tiers;
import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;

import java.lang.reflect.Type;

import static net.twomoonsstudios.moonsweaponry.constants.MeleeWeaponDataConstants.STONE_HAMMER_DEFAULT_DMG;
import static net.twomoonsstudios.moonsweaponry.constants.MeleeWeaponDataConstants.STONE_HAMMER_DEFAULT_TIER_NAME;

public class StoneHammerConfigObj extends HammerConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public StoneHammerConfigObj(Type myType, String myID) {
        super(myType, myID);
    }
    public StoneHammerConfigObj(String myId){
        super(StoneHammerConfigObj.class, myId);
    }

    public StoneHammerConfigObj(String weaponId, MoonsWeaponsConfig.WeaponInfo objData) {
        super(StoneHammerConfigObj.class, weaponId, objData);
    }

    @Override
    protected String getDefaultTier() {
        return STONE_HAMMER_DEFAULT_TIER_NAME;
    }

    @Override
    protected Integer getDefaultDamage() {
        return STONE_HAMMER_DEFAULT_DMG;
    }

    @Override
    protected Integer getDefaultDurability() {
        return Tiers.STONE.getUses();
    }
}
