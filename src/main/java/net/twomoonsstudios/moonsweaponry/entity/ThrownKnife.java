package net.twomoonsstudios.moonsweaponry.entity;

import net.minecraft.core.NonNullList;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.twomoonsstudios.moonsweaponry.item.ModItems;
import org.jetbrains.annotations.NotNull;


public class ThrownKnife extends AbstractArrow {

    private ItemStack usedItem = new ItemStack(ModItems.THROWING_KNIFE.get());

    public ThrownKnife(EntityType<? extends AbstractArrow> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public ThrownKnife(Level level, LivingEntity entity, ItemStack stack) {
        super(WeaponworksEntities.THROWN_KNIFE.get(), entity, level);
        this.usedItem = stack.copy();
    }

    public ItemStack getUsedItem() {
        return this.usedItem.copy();
    }
    @Override
    public void playerTouch(Player pEntity) {
        if (this.onGround && matchingItem(pEntity, this.usedItem)) {
            this.usedItem.setDamageValue(Math.max((this.getUsedItem().getDamageValue() + 1), this.getUsedItem().getMaxDamage()));
            this.discard();
        }
        super.playerTouch(pEntity);
    }

    @Override
    protected boolean tryPickup(Player pPlayer) {
        return false;
    }

    public boolean matchingItem(Player player, ItemStack itemStack) {
        NonNullList<ItemStack> inventory = player.getInventory().items;
        return inventory.iterator().equals(itemStack);
    }

    @Override
    protected @NotNull ItemStack getPickupItem() {
        if (this.usedItem == null) {
            return ItemStack.EMPTY;
        } else return this.getUsedItem().copy();
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        pResult.getEntity().hurt(DamageSource.mobAttack((LivingEntity) this.getOwner()), 4);
        super.onHitEntity(pResult);
    }
}
