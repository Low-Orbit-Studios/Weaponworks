package net.twomoonsstudios.moonsweaponry.item.weapons;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.twomoonsstudios.moonsweaponry.entity.AbstractThrowable;
import net.twomoonsstudios.moonsweaponry.entity.ThrownJavelinEntity;
import net.twomoonsstudios.moonsweaponry.item.ThrowableWeaponItem;

public class JavelinItem extends ThrowableWeaponItem {

    public JavelinItem(Tier tier, ThrowableProperties throwableProperties, Item.Properties properties) {
        super(tier, throwableProperties, properties);
    }

    @Override
    protected AbstractThrowable createThrownEntity(Level level, Player player, ItemStack itemStack, float initialVelocity) {
        return new ThrownJavelinEntity(level,player,itemStack,initialVelocity);
    }
}
