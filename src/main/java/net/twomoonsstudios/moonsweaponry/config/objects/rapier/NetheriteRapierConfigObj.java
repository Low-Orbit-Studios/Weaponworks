package net.twomoonsstudios.moonsweaponry.config.objects.rapier;

import net.minecraft.world.item.Tiers;
import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;

import java.lang.reflect.Type;

import static net.twomoonsstudios.moonsweaponry.constants.WeaponDataConstants.*;

public class NetheriteRapierConfigObj extends RapierConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public NetheriteRapierConfigObj(Type myType, String myID) {
        super(myType, myID);
    }
    public NetheriteRapierConfigObj(String myId){
        super(NetheriteRapierConfigObj.class, myId);
    }

    public NetheriteRapierConfigObj(String weaponId, MoonsWeaponsConfig.WeaponInfo objData) {
        super(NetheriteRapierConfigObj.class, weaponId, objData);
    }

    @Override
    protected String getDefaultTier() {
        return NETHERITE_RAPIER_DEFAULT_TIER_NAME;
    }

    @Override
    protected Integer getDefaultDamage() {
        return NETHERITE_RAPIER_DEFAULT_DMG;
    }

    @Override
    protected Integer getDefaultDurability() {
        return Tiers.NETHERITE.getUses();
    }

    @Override
    protected Boolean getDefaultFireResistance(){
        return NETHERITE_RAPIER_DEFAULT_FIRE_RESISTANCE;
    }
}
