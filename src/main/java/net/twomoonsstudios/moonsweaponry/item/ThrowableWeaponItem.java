package net.twomoonsstudios.moonsweaponry.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.twomoonsstudios.moonsweaponry.enchanting.CapacityEnchantment;
import net.twomoonsstudios.moonsweaponry.enchanting.ModEnchantments;
import net.twomoonsstudios.moonsweaponry.enchanting.VelocityEnchantment;
import net.twomoonsstudios.moonsweaponry.entity.AbstractThrowable;
import net.twomoonsstudios.moonsweaponry.entity.ThrownKnifeEntity;
import net.twomoonsstudios.moonsweaponry.entity.thrownKnife.ThrownIronKnifeEntity;

import static net.twomoonsstudios.moonsweaponry.constants.ThrownWeaponDataConstants.THROWABLES_FLAME_ENCHANT_SECONDS;

public abstract class ThrowableWeaponItem extends TieredItem {

    protected float throwVelocity;
    /**
     * Cooldown, in ticks, between throwing two throwables.*/
    protected int cooldown;
    protected float inaccuracy;
    public ThrowableWeaponItem(Tier pTier, ThrowableProperties throwableProperties, Properties pProperties) {
        super(pTier, pProperties);
        this.throwVelocity = throwableProperties.throwVelocity;
        this.cooldown = throwableProperties.cooldown;
        this.inaccuracy = throwableProperties.inaccuracy;
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
    @Override
    public int getMaxDamage(ItemStack stack) {
        var baseMaxDurability = super.getMaxDamage(stack);
        var capacityLevel = stack.getEnchantmentLevel(ModEnchantments.CAPACITY_ENCHANTMENT.get());
        var modifiedDurability = CapacityEnchantment.modifyDurability(baseMaxDurability, capacityLevel);
        return modifiedDurability;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {

        ItemStack itemStack = player.getItemInHand(hand);

        if (itemStack.getDamageValue() < itemStack.getMaxDamage() && !level.isClientSide) {
            //We throw one item at a time - hence 1
            itemStack.hurt(1, null, null);
            var thrownKnifeEntity = createThrownEntity(level, player, itemStack, throwVelocity);//new ThrownIronKnifeEntity(level, player, itemStack);
            this.applyEnchantments(itemStack, thrownKnifeEntity);
            thrownKnifeEntity.setOwner(player);
            //for easier debugging.
            var playerXRot = player.getXRot();
            var playerYRot = player.getYRot();
            thrownKnifeEntity.shootFromRotation(player, playerXRot, playerYRot, 0, thrownKnifeEntity.getInitialVelocity(), inaccuracy);
            level.addFreshEntity(thrownKnifeEntity);
            player.getCooldowns().addCooldown(this, cooldown);
        }
        return super.use(level, player, hand);
    }
    protected void applyEnchantments(ItemStack itemStack, AbstractThrowable projectile){
        var punchEnchantmentLevel = itemStack.getEnchantmentLevel(Enchantments.PUNCH_ARROWS);
        var flameEnchantmentLevel = itemStack.getEnchantmentLevel(Enchantments.FLAMING_ARROWS);
        var velocityEnchantmentLevel = itemStack.getEnchantmentLevel(ModEnchantments.VELOCITY_ENCHANTMENT.get());

        if(punchEnchantmentLevel > 0){
            projectile.setKnockback(punchEnchantmentLevel);
        }

        if(flameEnchantmentLevel > 0){
            projectile.setSecondsOnFire(THROWABLES_FLAME_ENCHANT_SECONDS);
        }

        if(velocityEnchantmentLevel > 0){
            var newThrownVelocity = VelocityEnchantment.modifyVelocity(throwVelocity, velocityEnchantmentLevel);
            projectile.setInitialVelocity(newThrownVelocity);
            projectile.setVelocityEnchantmentLevel(velocityEnchantmentLevel);
        }
    }

    protected abstract AbstractThrowable createThrownEntity(Level level, Player player, ItemStack itemStack, float initialVelocity);

    public static class ThrowableProperties {
        float throwVelocity;
        float inaccuracy;
        int cooldown;

        public ThrowableWeaponItem.ThrowableProperties setThrowVelocity(float velocity){
            throwVelocity = velocity;
            return this;
        }
        public ThrowableWeaponItem.ThrowableProperties setInaccuracy(float inaccuracy){
            this.inaccuracy = inaccuracy;
            return this;
        }
        public ThrowableWeaponItem.ThrowableProperties setCooldown(int cooldown){
            this.cooldown = cooldown;
            return this;
        }
    }
}
