package net.twomoonsstudios.moonsweaponry.item.weapons;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.twomoonsstudios.moonsweaponry.enchanting.ModEnchantments;
import net.twomoonsstudios.moonsweaponry.enchanting.WeaponworksEnchantment;
import net.twomoonsstudios.moonsweaponry.enchanting.WeaponworksThrowableEnchantment;
import net.twomoonsstudios.moonsweaponry.entity.AbstractThrowable;
import net.twomoonsstudios.moonsweaponry.entity.ThrownBoomerangEntity;
import net.twomoonsstudios.moonsweaponry.item.ThrowableWeaponItem;

public class BoomerangItem extends ThrowableWeaponItem {
    public BoomerangItem(Tier pTier, ThrowableProperties throwableProperties, Properties pProperties) {
        super(pTier, throwableProperties, pProperties);
    }

    @Override
    protected AbstractThrowable createThrownEntity(Level level, Player player, ItemStack itemStack, float initialVelocity) throws ClassNotFoundException {
        return new ThrownBoomerangEntity(level,player,itemStack,initialVelocity);
    }

    @Override
    public void applyEnchantments(ItemStack itemStack, AbstractThrowable projectile) {
        super.applyEnchantments(itemStack, projectile);
        var piercingEnchantmentLevel = itemStack.getEnchantmentLevel(Enchantments.PIERCING);
        if (piercingEnchantmentLevel > 0) {
            ((ThrownBoomerangEntity) projectile).setPiercingLevel(piercingEnchantmentLevel);
        }
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        if (enchantment.equals(Enchantments.PIERCING)) {return true;}
        if (enchantment.equals(ModEnchantments.CAPACITY_ENCHANTMENT.get())) {return false;}
        return super.canApplyAtEnchantingTable(stack, enchantment);
    }

}
