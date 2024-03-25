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

import static net.twomoonsstudios.moonsweaponry.constants.ThrownWeaponDataConstants.THROWABLES_FLAME_ENCHANT_ENTITY_SECONDS;


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
