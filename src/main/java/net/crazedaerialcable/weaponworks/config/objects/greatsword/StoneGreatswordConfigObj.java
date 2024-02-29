package net.crazedaerialcable.weaponworks.config.objects.greatsword;

import net.minecraft.item.ToolMaterials;

import java.lang.reflect.Type;

import static net.crazedaerialcable.weaponworks.constants.WeaponDataConstants.*;

public class StoneGreatswordConfigObj extends GreatswordConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public StoneGreatswordConfigObj(Type myType, String myID) {
        super(myType, myID);
    }
    public StoneGreatswordConfigObj(String myId){
        super(StoneGreatswordConfigObj.class, myId);
    }

    



    @Override
    protected String getDefaultTier() {
        return STONE_GREATSWORD_DEFAULT_TIER_NAME;
    }

    @Override
    protected Integer getDefaultDamage() {
        return STONE_GREATSWORD_DEFAULT_DMG;
    }

    @Override
    protected Integer getDefaultDurability() {
        return ToolMaterials.STONE.getDurability();
    }
}