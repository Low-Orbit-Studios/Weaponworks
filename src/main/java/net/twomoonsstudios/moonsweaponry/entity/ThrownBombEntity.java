package net.twomoonsstudios.moonsweaponry.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DoubleBlockCombiner;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.twomoonsstudios.moonsweaponry.MoonsWeaponry;
import net.twomoonsstudios.moonsweaponry.item.weapons.BombCannonItem;
import net.twomoonsstudios.moonsweaponry.item.weapons.BombItem;

public class ThrownBombEntity extends AbstractThrowable {


    public ThrownBombEntity(EntityType<? extends ThrownBombEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public ThrownBombEntity(Level level, LivingEntity entity, ItemStack stack, float initialVelocity) {
        super(WeaponworksEntities.THROWN_BOMB_ENTITY_TYPE.get(), level, entity, stack, initialVelocity);
    }

    @Override
    protected boolean tryPickup(Player pPlayer) {
        return false;
    }

    @Override
    protected boolean pickupItem(Player pPlayer) {
        return false;
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.isNoGravity()) {
            this.setDeltaMovement(this.getDeltaMovement().add(0.0, -0.04, 0.0));
        }
        for (int i = 0; i < 4; i++) {
            level.addParticle(ParticleTypes.SMOKE, this.getX(), this.getY() + .3, this.getZ(), 0.01 - 0.02 * Math.random(), 0.25, 0.01 - 0.02 * Math.random());
        }
        if ((this.tickCount >= 100) && !level.isClientSide) {
            blowUpBomb();
        }
        if (this.isInWaterOrBubble()) {
            blowUpBomb();
        }
        //this.setDeltaMovement(this.getDeltaMovement().scale(0.5f));
    }

    public void blowUpBomb() {
        level.explode(null, this.getX(), this.getY() +0.5 , this.getZ(), 4f, Explosion.BlockInteraction.BREAK );
        this.discard();
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        Direction direction = pResult.getDirection();
        float bounce = 0.3f;
        if (this.getUsedItem().getItem() instanceof BombItem && level.getBlockState(pResult.getBlockPos()).getMaterial().blocksMotion()) {
            if (direction.equals(Direction.DOWN) && this.getDeltaMovement().length() >= 0) {
                this.setDeltaMovement(new Vec3(0, 0, 0));
                super.onHitBlock(pResult);
            }
            if (this.getDeltaMovement().length() >= 0.35 && !this.isInWaterOrBubble()) {
                if (direction.equals(Direction.DOWN) || direction.equals(Direction.UP)) {
                    this.setDeltaMovement(this.getDeltaMovement().multiply(bounce, -0.3f, bounce));
                }
                if (direction.equals(Direction.EAST) || direction.equals(Direction.WEST)) {
                    this.setDeltaMovement(this.getDeltaMovement().multiply(-0.5f, bounce, bounce));
                }
                if (direction.equals(Direction.NORTH) || direction.equals(Direction.SOUTH)) {
                    this.setDeltaMovement(this.getDeltaMovement().multiply(bounce, bounce, -0.5f));
                }
            }
            if (pResult.isInside() && !level.isClientSide) {
                this.setDeltaMovement(this.getDeltaMovement().add(0,-2,0) );
            }
        } else if (!level.isClientSide) {
            blowUpBomb();
        }
    }

    @Override
    public float getDefaultVelocity() {
        return 0.5f;
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        if (getUsedItem().getItem() instanceof BombCannonItem && !level.isClientSide) {blowUpBomb();}
    }

}
