package net.crazedaerialcable.weaponworks.config.objects.mace;

import net.minecraft.item.ToolMaterials;

import java.lang.reflect.Type;

import static net.crazedaerialcable.weaponworks.constants.WeaponDataConstants.*;

public class NetheriteMaceConfigObj extends MaceConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public NetheriteMaceConfigObj(Type myType, String myID) {
        super(myType, myID);
    }
    public NetheriteMaceConfigObj(String myId){
        super(NetheriteMaceConfigObj.class, myId);
    }

    



    @Override
    protected String getDefaultTier() {
        return NETHERITE_MACE_DEFAULT_TIER_NAME;
    }

    @Override
    protected Integer getDefaultDamage() {
        return NETHERITE_MACE_DEFAULT_DMG;
    }

    @Override
    protected Integer getDefaultDurability() {
        return ToolMaterials.NETHERITE.getDurability();
    }

    @Override
    protected Boolean getDefaultFireResistance(){
        return NETHERITE_MACE_DEFAULT_FIRE_RESISTANCE;
    }
}