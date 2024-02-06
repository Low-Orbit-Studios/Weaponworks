package net.crazedaerialcable.weaponworks.config.objects.greatsword;

import net.minecraft.item.ToolMaterials;

import java.lang.reflect.Type;

import static net.crazedaerialcable.weaponworks.constants.WeaponDataConstants.WOODEN_GREATSWORD_DEFAULT_DMG;
import static net.crazedaerialcable.weaponworks.constants.WeaponDataConstants.WOODEN_GREATSWORD_DEFAULT_TIER_NAME;

public class WoodenGreatswordConfigObj extends GreatswordConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public WoodenGreatswordConfigObj(Type myType, String myID) {
        super(myType, myID);
    }
    public WoodenGreatswordConfigObj(String myId){
        super(WoodenGreatswordConfigObj.class, myId);
    }

    



    @Override
    protected String getDefaultTier() {
        return WOODEN_GREATSWORD_DEFAULT_TIER_NAME;
    }

    @Override
    protected Integer getDefaultDamage() {
        return WOODEN_GREATSWORD_DEFAULT_DMG;
    }

    @Override
    protected Integer getDefaultDurability() {
        return ToolMaterials.WOOD.getDurability();
    }
}
