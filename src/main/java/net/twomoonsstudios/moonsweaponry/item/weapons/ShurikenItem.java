package net.twomoonsstudios.moonsweaponry.item.weapons;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.twomoonsstudios.moonsweaponry.entity.AbstractThrowable;
import net.twomoonsstudios.moonsweaponry.entity.ThrownShurikenEntity;
import net.twomoonsstudios.moonsweaponry.item.ThrowableWeaponItem;

public class ShurikenItem extends ThrowableWeaponItem {
    public ShurikenItem(Tier tier, ThrowableProperties throwableProperties, Item.Properties properties) {
        super(tier,throwableProperties,properties);
    }

    @Override
    protected AbstractThrowable createThrownEntity(Level level, Player player, ItemStack itemStack, float initialVelocity) {
        return new ThrownShurikenEntity(level,player,itemStack,initialVelocity);
    }

    @Override
    public void shootingAction(Level level, AbstractThrowable entity, Player player, float xRot, float yRot, float zRot, float initialVelocity, float inaccuracy, ItemStack itemStack) {
        entity.shootFromRotation(player, xRot, yRot, zRot, initialVelocity, inaccuracy);
        level.addFreshEntity(entity);
        
        AbstractThrowable left = createThrownEntity(level, player, itemStack, initialVelocity);
        left.setOwner(player);
        applyEnchantments(itemStack, left);
        left.shootFromRotation(player,xRot, yRot - 20, zRot, initialVelocity, inaccuracy);
        level.addFreshEntity(left);

        AbstractThrowable right = createThrownEntity(level, player, itemStack, initialVelocity);
        right.setOwner(player);
        applyEnchantments(itemStack, right);
        right.shootFromRotation(player,xRot, yRot + 20, zRot, initialVelocity, inaccuracy);
        level.addFreshEntity(right);
    }

    @Override
    public int useCost() {
        return 3;
    }
}
