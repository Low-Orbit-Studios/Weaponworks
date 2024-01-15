package net.twomoonsstudios.moonsweaponry.config.objects.greatsword;

import net.minecraft.world.item.Tiers;
import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;

import java.lang.reflect.Type;

import static net.twomoonsstudios.moonsweaponry.constants.WeaponDataConstants.*;

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

    public IronGreatswordConfigObj(Type myType, String myID, MoonsWeaponsConfig.WeaponInfo configData) {
        super(myType, myID, configData);
    }

    public IronGreatswordConfigObj(String weaponId, MoonsWeaponsConfig.WeaponInfo objData) {
        super(IronGreatswordConfigObj.class, weaponId, objData);
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
        return Tiers.IRON.getUses();
    }
}
