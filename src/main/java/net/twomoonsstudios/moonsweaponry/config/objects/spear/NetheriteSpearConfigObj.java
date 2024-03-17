package net.twomoonsstudios.moonsweaponry.config.objects.spear;

import net.minecraft.world.item.Tiers;
import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.spear.SpearConfigObj;

import java.lang.reflect.Type;

import static net.twomoonsstudios.moonsweaponry.constants.WeaponDataConstants.*;

public class NetheriteSpearConfigObj extends SpearConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public NetheriteSpearConfigObj(Type myType, String myID) {
        super(myType, myID);
    }
    public NetheriteSpearConfigObj(String myId){
        super(NetheriteSpearConfigObj.class, myId);
    }

    public NetheriteSpearConfigObj(Type myType, String myID, MoonsWeaponsConfig.WeaponInfo configData) {
        super(myType, myID, configData);
    }

    public NetheriteSpearConfigObj(String weaponId, MoonsWeaponsConfig.WeaponInfo objData) {
        super(NetheriteSpearConfigObj.class, weaponId, objData);
    }

    @Override
    protected String getDefaultTier() {
        return NETHERITE_SPEAR_DEFAULT_TIER_NAME;
    }

    @Override
    protected Integer getDefaultDamage() {
        return NETHERITE_SPEAR_DEFAULT_DMG;
    }

    @Override
    protected Integer getDefaultDurability() {
        return Tiers.NETHERITE.getUses();
    }

    @Override
    protected Boolean getDefaultFireResistance(){
        return NETHERITE_SPEAR_DEFAULT_FIRE_RESISTANCE;
    }
}
