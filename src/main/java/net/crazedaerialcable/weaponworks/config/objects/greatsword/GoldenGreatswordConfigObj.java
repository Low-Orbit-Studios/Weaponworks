package net.crazedaerialcable.weaponworks.config.objects.greatsword;

import net.minecraft.item.ToolMaterials;

import java.lang.reflect.Type;

import static net.crazedaerialcable.weaponworks.constants.WeaponDataConstants.*;

public class GoldenGreatswordConfigObj extends GreatswordConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public GoldenGreatswordConfigObj(Type myType, String myID) {
        super(myType, myID);
    }
    public GoldenGreatswordConfigObj(String myId){
        super(GoldenGreatswordConfigObj.class, myId);
    }

    



    @Override
    protected String getDefaultTier() {
        return GOLDEN_GREATSWORD_DEFAULT_TIER_NAME;
    }

    @Override
    protected Integer getDefaultDamage() {
        return GOLDEN_GREATSWORD_DEFAULT_DMG;
    }

    @Override
    protected Integer getDefaultDurability() {
        return GOLDEN_ITEMS_DURABILITY;
    }
}
