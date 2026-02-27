package net.twomoonsstudios.moonsweaponry.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DoubleBlockCombiner;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.twomoonsstudios.moonsweaponry.MoonsWeaponry;
import net.twomoonsstudios.moonsweaponry.item.ModItems;
//import net.twomoonsstudios.moonsweaponry.item.weapons.BombCannonItem;
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
        if (this.isInWaterOrBubble()) {
            dropBombItem();
        }
        if (!this.isNoGravity()) {
            this.setDeltaMovement(this.getDeltaMovement().add(0.0, -0.04, 0.0));
        }
        for (int i = 0; i < 4; i++) {
            level.addParticle(ParticleTypes.SMOKE, this.getX(), this.getY() + .3, this.getZ(), 0.01 - 0.02 * Math.random(), 0.25, 0.01 - 0.02 * Math.random());
        }
        if ((this.tickCount >= 100) && !level.isClientSide) {
            blowUpBomb();
        }
        //this.setDeltaMovement(this.getDeltaMovement().scale(0.5f));
    }

    public void blowUpBomb() {
        for (int i = 0; i < 40; i++) {
            level.addParticle(new ItemParticleOption(ParticleTypes.ITEM, ModItems.BOMB.get().getDefaultInstance()), this.getX(), this.getY() + .3f, this.getZ(), .0125 - 0.025 * Math.random(), .0125 - 0.025 * Math.random(), .0125 - 0.025 * Math.random());
        }
        level.explode(null, this.getX(), this.getY() +0.5 , this.getZ(), 4f, Explosion.BlockInteraction.BREAK );
        this.discard();
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        Direction direction = pResult.getDirection();
        float bounce = 0.3f;
        boolean speed2bounce = this.getDeltaMovement().length() > 0.35f;
        boolean solid =  level.getBlockState(pResult.getBlockPos()).getMaterial().blocksMotion();
        if (speed2bounce && this.getUsedItem().getItem() instanceof BombItem && solid) {
            //if (direction.equals(Direction.UP) && this.getDeltaMovement().length() >= 0) {
            //    this.setDeltaMovement(new Vec3(0, 0, 0));
            //}
            if (!this.isInWaterOrBubble()) {
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
            if (this.isInWaterOrBubble()) {
                dropBombItem();
            }
            if (pResult.isInside() && !level.isClientSide) {
                this.setDeltaMovement(this.getDeltaMovement().add(0,-2,0) );
            }
        }
//        if (getUsedItem().getItem() instanceof BombCannonItem && solid) {
//            blowUpBomb();
//        }
    }

    @Override
    public float getDefaultVelocity() {
        return 0.5f;
    }

    public void dropBombItem() {
        level.addFreshEntity(new ItemEntity(level, this.getX(),this.getY(),this.getZ(), ModItems.BOMB.get().getDefaultInstance()));
        this.discard();
    }

//    @Override
//    protected void onHitEntity(EntityHitResult pResult) {
//        if (getUsedItem().getItem() instanceof BombCannonItem && !level.isClientSide) {blowUpBomb();}
//    }
}
