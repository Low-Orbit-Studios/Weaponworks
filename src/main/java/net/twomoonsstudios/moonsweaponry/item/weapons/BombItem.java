package net.twomoonsstudios.moonsweaponry.item.weapons;

import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;
import net.twomoonsstudios.moonsweaponry.entity.AbstractThrowable;
import net.twomoonsstudios.moonsweaponry.entity.ThrownBombEntity;
import net.twomoonsstudios.moonsweaponry.item.ThrowableWeaponItem;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BombItem extends ThrowableWeaponItem {


    public BombItem(Tier pTier, ThrowableProperties throwableProperties, Properties pProperties) {
        super(pTier, throwableProperties, pProperties);
    }


    @Override
    protected AbstractThrowable createThrownEntity(Level level, Player player, ItemStack itemStack, float initialVelocity) throws ClassNotFoundException {
        return new ThrownBombEntity(level, player, itemStack, initialVelocity);
    }

    @Override
    public int useCost() {
        return 0;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return false;
    }

    @Override
    public int getMaxStackSize(ItemStack stack) {
        return 16;
    }

    @Override
    public boolean isBarVisible(ItemStack pStack) {
        return false;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.literal("Five second fuse, throw and run!"));
    }
}
