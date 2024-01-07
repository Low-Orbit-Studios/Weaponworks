package net.twomoonsstudios.moonsweaponry.config.objects.scythe;

import net.minecraft.world.item.Tiers;
import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;

import java.lang.reflect.Type;

import static net.twomoonsstudios.moonsweaponry.constants.WeaponDataConstants.*;

public class NetheriteScytheConfigObj extends ScytheConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public NetheriteScytheConfigObj(Type myType, String myID) {
        super(myType, myID);
    }
    public NetheriteScytheConfigObj(String myId){
        super(NetheriteScytheConfigObj.class, myId);
    }

    public NetheriteScytheConfigObj(String weaponId, MoonsWeaponsConfig.WeaponInfo objData) {
        super(NetheriteScytheConfigObj.class, weaponId, objData);
    }

    @Override
    protected String getDefaultTier() {
        return NETHERITE_SCYTHE_DEFAULT_TIER_NAME;
    }

    @Override
    protected Integer getDefaultDamage() {
        return NETHERITE_SCYTHE_DEFAULT_DMG;
    }

    @Override
    protected Integer getDefaultDurability() {
        return Tiers.NETHERITE.getUses();
    }

    @Override
    protected Boolean getDefaultFireResistance(){
        return NETHERITE_SCYTHE_DEFAULT_FIRE_RESISTANCE;
    }
}
