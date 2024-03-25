package net.twomoonsstudios.moonsweaponry.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public abstract class AbstractThrowable extends AbstractArrow {
    public ItemStack usedItem;
    public AbstractThrowable(EntityType<? extends AbstractThrowable> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
    public AbstractThrowable(EntityType<? extends AbstractThrowable> entityType, Level level, LivingEntity entity, ItemStack stack) {
        super(entityType, entity, level);
        this.usedItem = stack.copy();
    }

}
