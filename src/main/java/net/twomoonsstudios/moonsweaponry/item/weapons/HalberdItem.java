package net.twomoonsstudios.moonsweaponry.item.weapons;

import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.WeaponConfigObj;
import net.twomoonsstudios.moonsweaponry.item.WeaponSwordItem;

public class HalberdItem extends WeaponSwordItem {
    public HalberdItem(MoonsWeaponsConfig.WeaponInfo stats) {
        super(stats);
    }

    public HalberdItem(WeaponConfigObj weaponConfig) {
        super(weaponConfig);
    }
}
