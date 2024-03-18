package net.twomoonsstudios.moonsweaponry.config.objects.greatsword;

import net.minecraft.world.item.Tiers;
import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;

import java.lang.reflect.Type;

import static net.twomoonsstudios.moonsweaponry.constants.MeleeWeaponDataConstants.WOODEN_GREATSWORD_DEFAULT_DMG;
import static net.twomoonsstudios.moonsweaponry.constants.MeleeWeaponDataConstants.WOODEN_GREATSWORD_DEFAULT_TIER_NAME;

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

    public WoodenGreatswordConfigObj(Type myType, String myID, MoonsWeaponsConfig.WeaponInfo configData) {
        super(myType, myID, configData);
    }

    public WoodenGreatswordConfigObj(String weaponId, MoonsWeaponsConfig.WeaponInfo objData) {
        super(WoodenGreatswordConfigObj.class, weaponId, objData);
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
        return Tiers.WOOD.getUses();
    }
}
