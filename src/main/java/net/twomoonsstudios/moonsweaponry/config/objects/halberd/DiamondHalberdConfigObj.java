package net.twomoonsstudios.moonsweaponry.config.objects.halberd;

import net.minecraft.world.item.Tiers;

import java.lang.reflect.Type;

import static net.twomoonsstudios.moonsweaponry.constants.WeaponDataConstants.DIAMOND_HALBERD_DEFAULT_DMG;
import static net.twomoonsstudios.moonsweaponry.constants.WeaponDataConstants.DIAMOND_HALBERD_DEFAULT_TIER_NAME;

public class DiamondHalberdConfigObj extends HalberdConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public DiamondHalberdConfigObj(Type myType, String myID) {
        super(myType, myID);
    }
    public DiamondHalberdConfigObj(String myId){
        super(DiamondHalberdConfigObj.class, myId);
    }
    @Override
    protected String getDefaultTier() {
        return DIAMOND_HALBERD_DEFAULT_TIER_NAME;
    }

    @Override
    protected Integer getDefaultDamage() {
        return DIAMOND_HALBERD_DEFAULT_DMG;
    }

    @Override
    protected Integer getDefaultDurability() {
        return Tiers.DIAMOND.getUses();
    }
}
