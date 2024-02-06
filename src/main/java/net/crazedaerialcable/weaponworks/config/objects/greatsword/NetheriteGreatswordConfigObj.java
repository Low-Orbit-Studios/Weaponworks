package net.crazedaerialcable.weaponworks.config.objects.greatsword;

import net.minecraft.item.ToolMaterials;

import java.lang.reflect.Type;

import static net.crazedaerialcable.weaponworks.constants.WeaponDataConstants.*;

public class NetheriteGreatswordConfigObj extends GreatswordConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public NetheriteGreatswordConfigObj(Type myType, String myID) {
        super(myType, myID);
    }
    public NetheriteGreatswordConfigObj(String myId){
        super(NetheriteGreatswordConfigObj.class, myId);
    }

    



    @Override
    protected String getDefaultTier() {
        return NETHERITE_GREATSWORD_DEFAULT_TIER_NAME;
    }

    @Override
    protected Integer getDefaultDamage() {
        return NETHERITE_GREATSWORD_DEFAULT_DMG;
    }

    @Override
    protected Integer getDefaultDurability() {
        return ToolMaterials.NETHERITE.getDurability();
    }

    @Override
    protected Boolean getDefaultFireResistance(){
        return NETHERITE_GREATSWORD_DEFAULT_FIRE_RESISTANCE;
    }
}
