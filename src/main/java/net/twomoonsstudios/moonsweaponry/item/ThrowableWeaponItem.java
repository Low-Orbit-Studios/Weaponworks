package net.twomoonsstudios.moonsweaponry.item;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;

import javax.annotation.Nullable;

public class ThrowableWeaponItem extends TieredItem {
    protected float throwVelocity;
    /**
     * Cooldown, in ticks, between throwing two throwables.*/
    protected int cooldown;
    protected float inaccuracy;
    public ThrowableWeaponItem(Tier pTier, float throwVelocity, int cooldown, float inaccuracy, Properties pProperties) {
        super(pTier, pProperties);
        this.throwVelocity = throwVelocity;
        this.cooldown = cooldown;
        this.inaccuracy = inaccuracy;
    }

    @Override
    public int getBarColor(ItemStack pStack) {
        return 0x0e629e;
    }

    @Override
    public boolean isBarVisible(ItemStack pStack) {
        return true;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        if(enchantment.equals(Enchantments.UNBREAKING)){
            return false;
        }
        else{
            return super.canApplyAtEnchantingTable(stack, enchantment);
        }
    }
}
