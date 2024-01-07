package net.twomoonsstudios.moonsweaponry.config.objects.hammer;

import net.minecraft.world.item.Tiers;
import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.halberd.NetheriteHalberdConfigObj;

import java.lang.reflect.Type;

import static net.twomoonsstudios.moonsweaponry.constants.WeaponDataConstants.*;

public class NetheriteHammerConfigObj extends HammerConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public NetheriteHammerConfigObj(Type myType, String myID) {
        super(myType, myID);
    }
    public NetheriteHammerConfigObj(String myId){
        super(NetheriteHammerConfigObj.class, myId);
    }

    public NetheriteHammerConfigObj(String weaponId, MoonsWeaponsConfig.WeaponInfo objData) {
        super(NetheriteHalberdConfigObj.class, weaponId, objData);
    }

    @Override
    protected String getDefaultTier() {
        return NETHERITE_HAMMER_DEFAULT_TIER_NAME;
    }

    @Override
    protected Integer getDefaultDamage() {
        return NETHERITE_HAMMER_DEFAULT_DMG;
    }

    @Override
    protected Integer getDefaultDurability() {
        return Tiers.NETHERITE.getUses();
    }

    @Override
    protected Boolean getDefaultFireResistance(){
        return NETHERITE_HAMMER_DEFAULT_FIRE_RESISTANCE;
    }
}
