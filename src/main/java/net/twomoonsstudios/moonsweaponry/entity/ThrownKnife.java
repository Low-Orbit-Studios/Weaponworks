package net.twomoonsstudios.moonsweaponry.entity;

import net.minecraft.core.NonNullList;
import net.minecraft.util.Mth;
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
        var matchingItem = matchingItem(pPlayer, usedItem);
        if(matchingItem != null){
            //-1 since we picked up a single thrown item, which we put back in the item stack.
            matchingItem.hurt(-1, null, null);
            // We can pick up the item (we have proper itemstack). Return true to pick
            // the entity up.
            return true;
        }
        //We do not seem to have proper itemstack to be able to pick up the item. Do not pick it up.
        return false;
    }

    // We want to not lose thrown projectiles, without this they'd disappear within about a minute.
    @Override
    protected void tickDespawn() {}

    @Override
    protected boolean tryPickup(Player pPlayer) {
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
        var enchantments = itemStack.getAllEnchantments();//.toString();
        NonNullList<ItemStack> inventory = player.getInventory().items;
        for (var stack : inventory) {
            var testEnchantments = stack.getAllEnchantments();//.toString(); // for future use
            if (stack.sameItem(itemStack) && stack.isDamaged() && testEnchantments.equals(enchantments))
            {
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

    // TODO: The damage points should be referencing the entity velocity and doing min/max damage based on it.
    // Please note: if you do the "super.onHitEntity(pResult)" at the end, the player will have an arrow stuck in them
    // in the event they shoot themselves.
    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        double velocity = Mth.floor(this.getDeltaMovement().length());
        double minDamageVelocity = 0.5;
        double maxDamageVelocity = 1;
        int damagePoints = 4;
        pResult.getEntity().hurt(DamageSource.mobAttack((LivingEntity) this.getOwner()), damagePoints);

        // this is the part of the vanilla code that defines normal behavior after hitting the entity.
        this.setDeltaMovement(this.getDeltaMovement().scale(-0.05D));
        this.setYRot(this.getYRot() + 180.0F);
        this.yRotO += 180.0F;
    }
}
