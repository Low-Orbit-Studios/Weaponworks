package net.twomoonsstudios.moonsweaponry.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class ThrownJavelinEntity extends AbstractThrowable {
    public ThrownJavelinEntity(EntityType<? extends ThrownJavelinEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public ThrownJavelinEntity(Level level, LivingEntity entity, ItemStack stack, float initialVelocity) {
        super(WeaponworksEntities.THROWN_JAVELIN_ENTITY_TYPE.get(), level, entity, stack, initialVelocity);
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        //slow down after hit but pierce
        this.setDeltaMovement(this.getDeltaMovement().scale(0.8D));
    }
}
