package net.twomoonsstudios.moonsweaponry.config.objects.warglaive;

import net.minecraft.world.item.Tiers;

import java.lang.reflect.Type;

import static net.twomoonsstudios.moonsweaponry.constants.WeaponDataConstants.*;

public class NetheriteWarglaiveConfigObj extends WarglaiveConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public NetheriteWarglaiveConfigObj(Type myType, String myID) {
        super(myType, myID);
    }
    public NetheriteWarglaiveConfigObj(String myId){
        super(NetheriteWarglaiveConfigObj.class, myId);
    }
    @Override
    protected String getDefaultTier() {
        return NETHERITE_WARGLAIVE_DEFAULT_TIER_NAME;
    }

    @Override
    protected Integer getDefaultDamage() {
        return NETHERITE_WARGLAIVE_DEFAULT_DMG;
    }

    @Override
    protected Integer getDefaultDurability() {
        return Tiers.NETHERITE.getUses();
    }

    @Override
    protected Boolean getDefaultFireResistance(){
        return NETHERITE_WARGLAIVE_DEFAULT_FIRE_RESISTANCE;
    }
}
