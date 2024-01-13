package net.twomoonsstudios.moonsweaponry.config.objects.scythe;

import net.minecraft.world.item.Tiers;
import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;

import java.lang.reflect.Type;

import static net.twomoonsstudios.moonsweaponry.constants.WeaponDataConstants.*;

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

    public GoldenScytheConfigObj(String weaponId, MoonsWeaponsConfig.WeaponInfo objData) {
        super(GoldenScytheConfigObj.class, weaponId, objData);
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
        return GOLDEN_ITEMS_DURABILITY;
    }
}
