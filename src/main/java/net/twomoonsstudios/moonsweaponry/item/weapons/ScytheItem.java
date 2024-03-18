package net.twomoonsstudios.moonsweaponry.item.weapons;

import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.WeaponConfigObj;
import net.twomoonsstudios.moonsweaponry.item.WeaponSwordItem;

public class ScytheItem extends WeaponSwordItem {
    public ScytheItem(MoonsWeaponsConfig.WeaponInfo stats) {
        super(stats);
    }

    public ScytheItem(WeaponConfigObj weaponConfig) {
        super(weaponConfig);
    }
}
