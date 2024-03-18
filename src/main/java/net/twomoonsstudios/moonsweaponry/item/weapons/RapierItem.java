package net.twomoonsstudios.moonsweaponry.item.weapons;

import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.WeaponConfigObj;
import net.twomoonsstudios.moonsweaponry.item.WeaponSwordItem;

public class RapierItem extends WeaponSwordItem {
    public RapierItem(MoonsWeaponsConfig.WeaponInfo stats) {
        super(stats);
    }

    public RapierItem(WeaponConfigObj weaponConfig) {
        super(weaponConfig);
    }
}
