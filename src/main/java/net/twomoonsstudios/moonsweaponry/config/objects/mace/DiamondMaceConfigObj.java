package net.twomoonsstudios.moonsweaponry.config.objects.mace;

import net.minecraft.world.item.Tiers;
import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;

import java.lang.reflect.Type;

import static net.twomoonsstudios.moonsweaponry.constants.MeleeWeaponDataConstants.DIAMOND_MACE_DEFAULT_DMG;
import static net.twomoonsstudios.moonsweaponry.constants.MeleeWeaponDataConstants.DIAMOND_MACE_DEFAULT_TIER_NAME;

public class DiamondMaceConfigObj extends MaceConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public DiamondMaceConfigObj(Type myType, String myID) {
        super(myType, myID);
    }
    public DiamondMaceConfigObj(Type myType, String myID, MoonsWeaponsConfig.WeaponInfo configData){
        super(myType, myID, configData);
    }

    public DiamondMaceConfigObj(String myId){
        super(DiamondMaceConfigObj.class, myId);
    }

    public DiamondMaceConfigObj(String weaponId, MoonsWeaponsConfig.WeaponInfo objData) {
        super(DiamondMaceConfigObj.class, weaponId, objData);
    }

    @Override
    protected String getDefaultTier() {
        return DIAMOND_MACE_DEFAULT_TIER_NAME;
    }

    @Override
    protected Integer getDefaultDamage() {
        return DIAMOND_MACE_DEFAULT_DMG;
    }

    @Override
    protected Integer getDefaultDurability() {
        return Tiers.DIAMOND.getUses();
    }
}
