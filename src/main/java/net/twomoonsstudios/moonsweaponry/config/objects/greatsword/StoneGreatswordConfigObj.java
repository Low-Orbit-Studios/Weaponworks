package net.twomoonsstudios.moonsweaponry.config.objects.greatsword;

import net.minecraft.world.item.Tiers;
import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;

import java.lang.reflect.Type;

import static net.twomoonsstudios.moonsweaponry.constants.WeaponDataConstants.*;

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

    public StoneGreatswordConfigObj(Type myType, String myID, MoonsWeaponsConfig.WeaponInfo configData) {
        super(myType, myID, configData);
    }

    public StoneGreatswordConfigObj(String weaponId, MoonsWeaponsConfig.WeaponInfo objData) {
        super(StoneGreatswordConfigObj.class, weaponId, objData);
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
        return Tiers.STONE.getUses();
    }
}
