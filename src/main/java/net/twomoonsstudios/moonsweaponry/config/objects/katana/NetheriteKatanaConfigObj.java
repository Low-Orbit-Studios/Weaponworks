package net.twomoonsstudios.moonsweaponry.config.objects.katana;

import net.minecraft.world.item.Tiers;
import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;

import java.lang.reflect.Type;

import static net.twomoonsstudios.moonsweaponry.constants.WeaponDataConstants.*;

public class NetheriteKatanaConfigObj extends KatanaConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public NetheriteKatanaConfigObj(Type myType, String myID) {
        super(myType, myID);
    }
    public NetheriteKatanaConfigObj(String myId){
        super(NetheriteKatanaConfigObj.class, myId);
    }

    public NetheriteKatanaConfigObj(String weaponId, MoonsWeaponsConfig.WeaponInfo objData) {
        super(NetheriteKatanaConfigObj.class, weaponId, objData);
    }

    @Override
    protected String getDefaultTier() {
        return NETHERITE_KATANA_DEFAULT_TIER_NAME;
    }

    @Override
    protected Integer getDefaultDamage() {
        return NETHERITE_KATANA_DEFAULT_DMG;
    }

    @Override
    protected Integer getDefaultDurability() {
        return Tiers.NETHERITE.getUses();
    }

    @Override
    protected Boolean getDefaultFireResistance(){
        return NETHERITE_KATANA_DEFAULT_FIRE_RESISTANCE;
    }
}
