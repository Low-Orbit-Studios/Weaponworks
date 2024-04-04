package net.twomoonsstudios.moonsweaponry.entity;

import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.twomoonsstudios.moonsweaponry.enums.WeaponTypesEnum;
import net.twomoonsstudios.moonsweaponry.helpers.ThrowablesHelper;
import net.twomoonsstudios.moonsweaponry.item.ThrowableWeaponItem;

import java.util.HashMap;
import java.util.Map;

import static net.twomoonsstudios.moonsweaponry.constants.ThrownWeaponDataConstants.*;

public abstract class AbstractThrowable extends AbstractArrow {
    protected ItemStack usedItem;
    protected ResourceLocation throwableTexture;

    public AbstractThrowable(EntityType<? extends AbstractThrowable> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
    public AbstractThrowable(EntityType<? extends AbstractThrowable> entityType, Level level, LivingEntity entity, ItemStack stack) {
        super(entityType, entity, level);
        this.usedItem = stack.copy();
    }
    protected ItemStack matchingItem(Player player, ItemStack itemStack) {
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
    // This (if it works) should save the used item that is just a local variable into actual entity data...
    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.put("usedItem", usedItem.save(new CompoundTag()));
    }

    //... and this one should read said data and put it into the actual entity's variable!
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.usedItem = ItemStack.of(tag.getCompound("usedItem"));
    }
    protected boolean pickupItem(Player pPlayer) {
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
    // TODO: The damage points should be referencing the entity velocity and doing min/max damage based on it.
    // Please note: if you do the "super.onHitEntity(pResult)" at the end, the player will have an arrow stuck in them
    // in the event they shoot themselves.
    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        var itemBaseDamage = this.usedItem.getDamageValue();
        var hitEntity = pResult.getEntity();
        var knockback = this.getKnockback();

        var isEnderman = hitEntity.getType() == EntityType.ENDERMAN;

        float velocity = Mth.floor(this.getDeltaMovement().length());
        float dmgToDeal = ThrowablesHelper.getDmgByVelocity(THROWABLE_MAX_DMG_VELOCITY_THRESHOLD
                , THROWABLE_MIN_DMG_VELOCITY_THRESHOLD
                , velocity
                , THROWING_KNIFE_DEFAULT_VELOCITY
                , itemBaseDamage
                , THROWABLE_MIN_DMG_COEF
        );

        if(hitEntity.hurt(DamageSource.mobAttack((LivingEntity) this.getOwner()), dmgToDeal)){
            if(hitEntity instanceof LivingEntity livingHitEntity){
                if(isEnderman){
                    return; //Endermen are known to be unsmackable with ranged physical attacks.
                }
                if(this.isOnFire()){
                    hitEntity.setSecondsOnFire(THROWABLES_FLAME_ENCHANT_ENTITY_SECONDS);
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
    }
}
