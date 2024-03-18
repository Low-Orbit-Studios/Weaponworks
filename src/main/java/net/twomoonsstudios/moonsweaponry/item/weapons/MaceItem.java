package net.twomoonsstudios.moonsweaponry.item.weapons;

import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.WeaponConfigObj;
import net.twomoonsstudios.moonsweaponry.item.WeaponSwordItem;

public class MaceItem extends WeaponSwordItem {
    public MaceItem(MoonsWeaponsConfig.WeaponInfo stats) {
        super(stats);
    }

    public MaceItem(WeaponConfigObj weaponConfig) {
        super(weaponConfig);
    }
}
