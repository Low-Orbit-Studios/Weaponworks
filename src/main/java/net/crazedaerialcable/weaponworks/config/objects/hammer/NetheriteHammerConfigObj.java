package net.crazedaerialcable.weaponworks.config.objects.hammer;

import net.minecraft.item.ToolMaterials;

import java.lang.reflect.Type;

import static net.crazedaerialcable.weaponworks.constants.WeaponDataConstants.*;

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
        return ToolMaterials.NETHERITE.getDurability();
    }

    @Override
    protected Boolean getDefaultFireResistance(){
        return NETHERITE_HAMMER_DEFAULT_FIRE_RESISTANCE;
    }
}
