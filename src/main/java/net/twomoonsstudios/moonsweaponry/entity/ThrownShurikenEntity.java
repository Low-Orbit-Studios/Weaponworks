package net.twomoonsstudios.moonsweaponry.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class ThrownShurikenEntity extends AbstractThrowable {
    public ThrownShurikenEntity(EntityType<? extends ThrownShurikenEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public ThrownShurikenEntity(Level level, LivingEntity entity, ItemStack stack, float initialVelocity) {
        super(WeaponworksEntities.THROWN_SHURIKEN_ENTITY_TYPE.get(), level, entity, stack, initialVelocity);
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        this.setDeltaMovement(this.getDeltaMovement().scale(-0.05D));

        this.setYRot(this.getYRot() + 180.0F);
        this.yRotO += 180.0F;
    }
}
