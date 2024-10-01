package net.twomoonsstudios.moonsweaponry.item.weapons;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.twomoonsstudios.moonsweaponry.entity.AbstractThrowable;
import net.twomoonsstudios.moonsweaponry.entity.ThrownHatchetEntity;
import net.twomoonsstudios.moonsweaponry.item.ThrowableWeaponItem;

public class HatchetItem extends ThrowableWeaponItem {
    public HatchetItem(Tier tier, ThrowableProperties throwableProperties, Item.Properties properties) {
        super(tier, throwableProperties, properties);
    }

    @Override
    protected AbstractThrowable createThrownEntity(Level level, Player player, ItemStack itemStack, float initialVelocity) {
        return new ThrownHatchetEntity(level,player,itemStack,initialVelocity);
    }
}
