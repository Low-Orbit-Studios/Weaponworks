package net.twomoonsstudios.moonsweaponry.item.weapons;

import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.WeaponConfigObj;
import net.twomoonsstudios.moonsweaponry.item.TriforgeSwordItem;

public class RapierItem extends TriforgeSwordItem {
    public RapierItem(MoonsWeaponsConfig.WeaponInfo stats) {
        super(stats);
    }

    public RapierItem(WeaponConfigObj weaponConfig) {
        super(weaponConfig);
    }
}
