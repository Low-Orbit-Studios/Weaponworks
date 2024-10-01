package net.twomoonsstudios.moonsweaponry.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

public class ThrownBoomerangEntity extends AbstractThrowable {
    public ThrownBoomerangEntity(EntityType<? extends ThrownBoomerangEntity> entityType, Level level) {
        super(entityType, level);
    }

    public ThrownBoomerangEntity(Level level, LivingEntity entity, ItemStack stack, float initialVelocity) {
        super(WeaponworksEntities.THROWN_BOOMERANG_ENTITY_TYPE.get(), level, entity, stack, initialVelocity);
    }

    public boolean noGrav = true;
    boolean returnAnyways = false;

    @Override
    public void tick() {
        super.tick();
        if (this.inGround) {noGrav = false;}
        if (((this.tickCount >= 15 )|| returnAnyways) && this.getOwner() != null && noGrav) {
            Vec3 baseTowardsOwner = this.getOwner().getEyePosition().subtract(this.position()).normalize();
            double inverseLength = 0.75/(baseTowardsOwner.length());
            Vec3 finalTowardsOwner = baseTowardsOwner.scale(inverseLength);
            this.setDeltaMovement(finalTowardsOwner);
            if (this.getOwner() instanceof Player player) {
                if (player.getEyePosition().distanceToSqr(this.position()) <= 2) {
                    tryPickup(player);
                    this.discard();
                }
            }
        }
    }

    @Override
    public boolean isNoGravity() {
        return noGrav;
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        if (pResult.getEntity().equals(getOwner())) {return;}
        super.onHitEntity(pResult);
        if (piercingLevel == 0) {returnAnyways = true;}
        if (piercingLevel > 0) {piercingLevel--;}
    }

    public int piercingLevel = 0;

    public void setPiercingLevel(int level) {
        this.piercingLevel = level;
    }
}