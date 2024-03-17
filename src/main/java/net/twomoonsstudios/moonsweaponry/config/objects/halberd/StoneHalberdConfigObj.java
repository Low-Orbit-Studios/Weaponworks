package net.twomoonsstudios.moonsweaponry.config.objects.halberd;

import net.minecraft.world.item.Tiers;
import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;

import java.lang.reflect.Type;

import static net.twomoonsstudios.moonsweaponry.constants.WeaponDataConstants.STONE_HALBERD_DEFAULT_DMG;
import static net.twomoonsstudios.moonsweaponry.constants.WeaponDataConstants.STONE_HALBERD_DEFAULT_TIER_NAME;

public class StoneHalberdConfigObj extends HalberdConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public StoneHalberdConfigObj(Type myType, String myID) {
        super(myType, myID);
    }
    public StoneHalberdConfigObj(String myId){
        super(StoneHalberdConfigObj.class, myId);
    }

    public StoneHalberdConfigObj(String weaponId, MoonsWeaponsConfig.WeaponInfo objData) {
        super(StoneHalberdConfigObj.class, weaponId, objData);
    }

    @Override
    protected String getDefaultTier() {
        return STONE_HALBERD_DEFAULT_TIER_NAME;
    }

    @Override
    protected Integer getDefaultDamage() {
        return STONE_HALBERD_DEFAULT_DMG;
    }

    @Override
    protected Integer getDefaultDurability() {
        return Tiers.STONE.getUses();
    }
}
