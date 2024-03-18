package net.twomoonsstudios.moonsweaponry.item.weapons;

import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.WeaponConfigObj;
import net.twomoonsstudios.moonsweaponry.item.WeaponSwordItem;

public class SpearItem extends WeaponSwordItem {
    public SpearItem(MoonsWeaponsConfig.WeaponInfo stats) {
        super(stats);
    }

    public SpearItem(WeaponConfigObj weaponConfig) {
        super(weaponConfig);
    }
}
