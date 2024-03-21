package net.twomoonsstudios.moonsweaponry.item;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

import static net.twomoonsstudios.moonsweaponry.constants.ThrownWeaponDataConstants.THROWABLES_FLAME_ENCHANT_SECONDS;

public abstract class ThrowableWeaponItem extends TieredItem {
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
        else if(enchantment.equals(Enchantments.FLAMING_ARROWS) || enchantment.equals(Enchantments.PUNCH_ARROWS)){
            return true;
        }
        else{
            return super.canApplyAtEnchantingTable(stack, enchantment);
        }
    }
    protected void applyEnchantments(ItemStack itemStack, AbstractArrow projectile){
        var punchEnchantmentLevel = itemStack.getEnchantmentLevel(Enchantments.PUNCH_ARROWS);
        var flameEnchantmentLevel = itemStack.getEnchantmentLevel(Enchantments.FLAMING_ARROWS);

        if(punchEnchantmentLevel > 0){
            projectile.setKnockback(punchEnchantmentLevel);
        }

        if(flameEnchantmentLevel > 0){
            projectile.setSecondsOnFire(THROWABLES_FLAME_ENCHANT_SECONDS);
        }
    }

}
