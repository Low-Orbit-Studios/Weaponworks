package net.twomoonsstudios.moonsweaponry.config.objects.warglaive;

import net.minecraft.world.item.Tiers;

import java.lang.reflect.Type;

import static net.twomoonsstudios.moonsweaponry.constants.WeaponDataConstants.STONE_WARGLAIVE_DEFAULT_DMG;
import static net.twomoonsstudios.moonsweaponry.constants.WeaponDataConstants.STONE_WARGLAIVE_DEFAULT_TIER_NAME;

public class StoneWarglaiveConfigObj extends WarglaiveConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public StoneWarglaiveConfigObj(Type myType, String myID) {
        super(myType, myID);
    }
    public StoneWarglaiveConfigObj(String myId){
        super(StoneWarglaiveConfigObj.class, myId);
    }
    @Override
    protected String getDefaultTier() {
        return STONE_WARGLAIVE_DEFAULT_TIER_NAME;
    }

    @Override
    protected Integer getDefaultDamage() {
        return STONE_WARGLAIVE_DEFAULT_DMG;
    }

    @Override
    protected Integer getDefaultDurability() {
        return Tiers.STONE.getUses();
    }
}
