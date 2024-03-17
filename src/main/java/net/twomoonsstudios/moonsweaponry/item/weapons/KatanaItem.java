package net.twomoonsstudios.moonsweaponry.item.weapons;

import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.WeaponConfigObj;
import net.twomoonsstudios.moonsweaponry.item.TriforgeSwordItem;

public class KatanaItem extends TriforgeSwordItem {
    public KatanaItem(MoonsWeaponsConfig.WeaponInfo stats) {
        super(stats);
    }

    public KatanaItem(WeaponConfigObj weaponConfig) {
        super(weaponConfig);
    }
}
