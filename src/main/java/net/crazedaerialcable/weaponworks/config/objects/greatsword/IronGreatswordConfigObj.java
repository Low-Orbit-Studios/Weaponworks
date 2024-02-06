package net.crazedaerialcable.weaponworks.config.objects.greatsword;

import net.minecraft.item.ToolMaterials;

import java.lang.reflect.Type;

import static net.crazedaerialcable.weaponworks.constants.WeaponDataConstants.*;

public class IronGreatswordConfigObj extends GreatswordConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public IronGreatswordConfigObj(Type myType, String myID) {
        super(myType, myID);
    }
    public IronGreatswordConfigObj(String myId){
        super(IronGreatswordConfigObj.class, myId);
    }

    



    @Override
    protected String getDefaultTier() {
        return IRON_GREATSWORD_DEFAULT_TIER_NAME;
    }

    @Override
    protected Integer getDefaultDamage() {
        return IRON_GREATSWORD_DEFAULT_DMG;
    }

    @Override
    protected Integer getDefaultDurability() {
        return ToolMaterials.IRON.getDurability();
    }
}
