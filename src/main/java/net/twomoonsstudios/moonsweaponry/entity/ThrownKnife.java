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

    public ItemStack usedItem = new ItemStack(ModItems.THROWING_KNIFE.get());

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

    private boolean pickupItem(Player pPlayer) {
        var matchingItem =  matchingItem(pPlayer,usedItem);
        if(matchingItem != null){
            matchingItem.hurt(-1, null, null);
            //We can pick up the item (we have proper itemstack). Return true to pick
            //the entity up.
            return true;
        }
        //We do not seem to have proper itemstack to be able to pick up the item. Do not pick it up.
        return false;
    }
    // Since there isn't a repair function, maybe negative hurting the item?
    // Also, I don't think it recognizes the itemstack with a different durability, so perhaps we might need to try another way.
    @Override
    protected boolean tryPickup(Player pPlayer) {
        //TODO: Make sure that the item is picked up only ONCE.
        switch (this.pickup) {
            case ALLOWED:
                return pickupItem(pPlayer);
            case CREATIVE_ONLY:
                return pPlayer.getAbilities().instabuild;
            default:
                return false;
            }
    }

    public ItemStack matchingItem(Player player, ItemStack itemStack) {
        NonNullList<ItemStack> inventory = player.getInventory().items;
        for (var stack : inventory) {
            if (stack.sameItem(itemStack)) {
                return stack;
            }
        }
        return null;
    }

    // Use a separate variable for saving and rendering the item
    @Override
    protected @NotNull ItemStack getPickupItem() {
        return ItemStack.EMPTY;
    }

    // TODO: The 4 here is going to be inherited from the itemstack in the future.
    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        pResult.getEntity().hurt(DamageSource.mobAttack((LivingEntity) this.getOwner()), 4);
        super.onHitEntity(pResult);
    }
}
