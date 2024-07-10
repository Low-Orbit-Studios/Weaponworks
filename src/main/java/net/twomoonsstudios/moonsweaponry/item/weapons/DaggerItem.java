package net.twomoonsstudios.moonsweaponry.item.weapons;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.twomoonsstudios.moonsweaponry.entity.AbstractThrowable;
import net.twomoonsstudios.moonsweaponry.entity.ThrownDaggerEntity;
import net.twomoonsstudios.moonsweaponry.item.ThrowableWeaponItem;

public class DaggerItem extends ThrowableWeaponItem {

    Tier tier;
    public DaggerItem(Tier tier, ThrowableProperties throwableProperties, Item.Properties properties) {
        super(tier, throwableProperties, properties);
        this.tier = tier;
    }

    // I really gotta find out how to call different classes based on the string. idk how.
    @Override
    protected AbstractThrowable createThrownEntity(Level level, Player player, ItemStack itemStack, float initialVelocity) {
        return new ThrownDaggerEntity(level,player,itemStack,initialVelocity);
    }
}
