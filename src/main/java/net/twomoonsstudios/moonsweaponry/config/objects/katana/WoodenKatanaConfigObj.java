package net.twomoonsstudios.moonsweaponry.config.objects.katana;

import net.minecraft.world.item.Tiers;

import java.lang.reflect.Type;

import static net.twomoonsstudios.moonsweaponry.constants.WeaponDataConstants.WOODEN_KATANA_DEFAULT_DMG;
import static net.twomoonsstudios.moonsweaponry.constants.WeaponDataConstants.WOODEN_KATANA_DEFAULT_TIER_NAME;

public class WoodenKatanaConfigObj extends KatanaConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public WoodenKatanaConfigObj(Type myType, String myID) {
        super(myType, myID);
    }
    public WoodenKatanaConfigObj(String myId){
        super(WoodenKatanaConfigObj.class, myId);
    }
    @Override
    protected String getDefaultTier() {
        return WOODEN_KATANA_DEFAULT_TIER_NAME;
    }

    @Override
    protected Integer getDefaultDamage() {
        return WOODEN_KATANA_DEFAULT_DMG;
    }

    @Override
    protected Integer getDefaultDurability() {
        return Tiers.WOOD.getUses();
    }
}
