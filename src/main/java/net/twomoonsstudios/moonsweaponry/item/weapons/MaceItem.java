package net.twomoonsstudios.moonsweaponry.item.weapons;

import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.WeaponConfigObj;
import net.twomoonsstudios.moonsweaponry.item.TriforgeSwordItem;

public class MaceItem extends TriforgeSwordItem {
    public MaceItem(MoonsWeaponsConfig.WeaponInfo stats) {
        super(stats);
    }

    public MaceItem(WeaponConfigObj weaponConfig) {
        super(weaponConfig);
    }
}
