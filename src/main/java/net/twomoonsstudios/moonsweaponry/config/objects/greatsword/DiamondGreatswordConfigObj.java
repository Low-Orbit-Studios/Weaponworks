package net.twomoonsstudios.moonsweaponry.config.objects.greatsword;

import net.minecraft.world.item.Tiers;
import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;

import java.lang.reflect.Type;

import static net.twomoonsstudios.moonsweaponry.constants.WeaponDataConstants.*;

public class DiamondGreatswordConfigObj extends GreatswordConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public DiamondGreatswordConfigObj(Type myType, String myID) {
        super(myType, myID);
    }
    public DiamondGreatswordConfigObj(Type myType, String myID, MoonsWeaponsConfig.WeaponInfo configData){
        super(myType, myID, configData);
    }

    public DiamondGreatswordConfigObj(String myId){
        super(DiamondGreatswordConfigObj.class, myId);
    }

    public DiamondGreatswordConfigObj(String weaponId, MoonsWeaponsConfig.WeaponInfo objData) {
        super(DiamondGreatswordConfigObj.class, weaponId, objData);
    }

    @Override
    protected String getDefaultTier() {
        return DIAMOND_GREATSWORD_DEFAULT_TIER_NAME;
    }

    @Override
    protected Integer getDefaultDamage() {
        return DIAMOND_GREATSWORD_DEFAULT_DMG;
    }

    @Override
    protected Integer getDefaultDurability() {
        return Tiers.DIAMOND.getUses();
    }
}
