package net.twomoonsstudios.moonsweaponry.item.weapons;

import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.WeaponConfigObj;
import net.twomoonsstudios.moonsweaponry.item.WeaponSwordItem;

public class GreatswordItem extends WeaponSwordItem {
    public GreatswordItem(MoonsWeaponsConfig.WeaponInfo stats) {
        super(stats);
    }

    public GreatswordItem(WeaponConfigObj weaponConfig) {
        super(weaponConfig);
    }
}
