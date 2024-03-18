package net.twomoonsstudios.moonsweaponry.item.weapons;

import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.WeaponConfigObj;
import net.twomoonsstudios.moonsweaponry.item.WeaponSwordItem;

public class HammerItem extends WeaponSwordItem {
    public HammerItem(MoonsWeaponsConfig.WeaponInfo stats) {
        super(stats);
    }

    public HammerItem(WeaponConfigObj weaponConfig) {
        super(weaponConfig);
    }
}
