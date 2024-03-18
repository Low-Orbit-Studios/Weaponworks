package net.twomoonsstudios.moonsweaponry.item.weapons;

import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.WeaponConfigObj;
import net.twomoonsstudios.moonsweaponry.item.WeaponSwordItem;

public class WarglaiveItem extends WeaponSwordItem {
    public WarglaiveItem(MoonsWeaponsConfig.WeaponInfo stats) {
        super(stats);
    }

    public WarglaiveItem(WeaponConfigObj weaponConfig) {
        super(weaponConfig);
    }
}
