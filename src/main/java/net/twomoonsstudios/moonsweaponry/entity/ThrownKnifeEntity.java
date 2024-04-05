package net.twomoonsstudios.moonsweaponry.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.twomoonsstudios.moonsweaponry.constants.TextureConstants;
import net.twomoonsstudios.moonsweaponry.item.ModItems;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;


public class ThrownKnifeEntity extends AbstractThrowable {
    public ThrownKnifeEntity(EntityType<? extends ThrownKnifeEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public ThrownKnifeEntity(EntityType<? extends ThrownKnifeEntity> entityType, Level level, LivingEntity entity, ItemStack stack, float initialVelocity) {
        super(entityType, level, entity, stack, initialVelocity);
    }

    // We want to not lose thrown projectiles, without this they'd disappear within about a minute.
    @Override
    protected void tickDespawn() {}

    // Use a separate variable for saving and rendering the item
    @Override
    protected @NotNull ItemStack getPickupItem() {
        return ItemStack.EMPTY;
    }
    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        // this is the part of the vanilla code that defines normal behavior after hitting the entity.
        this.setDeltaMovement(this.getDeltaMovement().scale(-0.05D));
        this.setYRot(this.getYRot() + 180.0F);
        this.yRotO += 180.0F;
    }
}
