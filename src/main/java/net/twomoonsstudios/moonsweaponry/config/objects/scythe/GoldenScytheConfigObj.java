package net.twomoonsstudios.moonsweaponry.config.objects.scythe;

import net.minecraft.world.item.Tiers;

import java.lang.reflect.Type;

import static net.twomoonsstudios.moonsweaponry.constants.WeaponDataConstants.GOLDEN_SCYTHE_DEFAULT_DMG;
import static net.twomoonsstudios.moonsweaponry.constants.WeaponDataConstants.GOLDEN_SCYTHE_DEFAULT_TIER_NAME;

public class GoldenScytheConfigObj extends ScytheConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public GoldenScytheConfigObj(Type myType, String myID) {
        super(myType, myID);
    }
    public GoldenScytheConfigObj(String myId){
        super(GoldenScytheConfigObj.class, myId);
    }

    @Override
    protected String getDefaultTier() {
        return GOLDEN_SCYTHE_DEFAULT_TIER_NAME;
    }

    @Override
    protected Integer getDefaultDamage() {
        return GOLDEN_SCYTHE_DEFAULT_DMG;
    }

    @Override
    protected Integer getDefaultDurability() {
        return Tiers.GOLD.getUses();
    }
}
