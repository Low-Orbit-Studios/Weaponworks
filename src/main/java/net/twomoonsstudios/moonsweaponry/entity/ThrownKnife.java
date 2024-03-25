package net.twomoonsstudios.moonsweaponry.entity;

import net.minecraft.core.NonNullList;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.twomoonsstudios.moonsweaponry.item.ModItems;
import org.jetbrains.annotations.NotNull;


public class ThrownKnife extends AbstractThrowable {

    public ThrownKnife(EntityType<? extends ThrownKnife> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.usedItem = new ItemStack(ModItems.THROWING_KNIFE.get());//TODO temporary solution
    }

    public ThrownKnife(EntityType<? extends ThrownKnife> entityType, Level level, LivingEntity entity, ItemStack stack) {
        super(entityType, level, entity, stack);
        this.usedItem = stack.copy();
        //TODO this.usedItem won't work. We need to create a collection of alternatives for thrown knives
        //TODO: Inside the registered entitytype.entityfactory and upon creating a new entity point to
        //TODO: the right alternative. I think so at least. Check how cats are made as they have
        //TODO: alternative textures too.
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
        var hitEntity = pResult.getEntity();
        var knockback = this.getKnockback();

        var isEnderman = hitEntity.getType() == EntityType.ENDERMAN;

        double velocity = Mth.floor(this.getDeltaMovement().length());
        double minDamageVelocity = 0.5;
        double maxDamageVelocity = 1;
        int damagePoints = 4;

        if(hitEntity.hurt(DamageSource.mobAttack((LivingEntity) this.getOwner()), damagePoints)){
            if(hitEntity instanceof LivingEntity livingHitEntity){
                if(isEnderman){
                    return; //Endermen are known to be unsmackable with ranged physical attacks.
                }
                //From AbstractArrow. We don't need everything found in there.
                if (knockback > 0) {
                    double d0 = Math.max(0.0D, 1.0D - livingHitEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
                    Vec3 vec3 = this.getDeltaMovement().multiply(1.0D, 0.0D, 1.0D).normalize().scale((double)knockback * 0.6D * d0);
                    if (vec3.lengthSqr() > 0.0D) {
                        livingHitEntity.push(vec3.x, 0.1D, vec3.z);
                    }
                }
            }
        }

        // this is the part of the vanilla code that defines normal behavior after hitting the entity.
        this.setDeltaMovement(this.getDeltaMovement().scale(-0.05D));
        this.setYRot(this.getYRot() + 180.0F);
        this.yRotO += 180.0F;

    }
}
