package net.twomoonsstudios.moonsweaponry.item;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.ForgeEventFactory;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class ModifiableBowItem extends BowItem {

    // Time to get max draw in ticks
    protected int DRAW_DURATION; //Vanilla bow: 20

    // note: will never fire at minimum velocity, must always be 0.1 higher otherwise it won't fire.
    protected float MIN_VELOCITY; //Vanilla bow: 0.3F
    protected float MAX_VELOCITY; //Vanilla bow: 3.0F. Anything higher than this can be buggy, fair warning.
    protected float INACCURACY; //Vanilla bow: 1.0F

    protected double DAMAGE_BONUS; //Vanilla bow: 1D (this is a multiplier)

    public ModifiableBowItem(BowProperties bowProperties, Properties pProperties) {
        super(pProperties);
        this.DRAW_DURATION = bowProperties.DRAW_DURATION;
        this.MIN_VELOCITY = bowProperties.MIN_VELOCITY;
        this.MAX_VELOCITY = bowProperties.MAX_VELOCITY;
        this.INACCURACY = bowProperties.INACCURACY;
        this.DAMAGE_BONUS = bowProperties.DAMAGE_BONUS;
    }

    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity entity, int timeLeft) {
        if (entity instanceof Player player) {
            boolean freeArrows = player.getAbilities().instabuild || stack.getEnchantmentLevel(Enchantments.INFINITY_ARROWS) > 0;
            ItemStack projectileStack = player.getProjectile(stack);

            int timeCheck = getUseDuration(stack) - timeLeft;
            boolean hasAmmo = !projectileStack.isEmpty() || freeArrows;
            timeCheck = ForgeEventFactory.onArrowLoose(stack,level,player,timeCheck, hasAmmo);
            if (timeCheck < 0) return;

            if (hasAmmo) {
                if (projectileStack.isEmpty()) {
                    projectileStack = new ItemStack(Items.ARROW);
                }

                float velocity = getVelocity(timeCheck);
                if (!((double)velocity < MIN_VELOCITY + 0.1F)) {
                    Item projectileItem = projectileStack.getItem();
                    boolean noConsumeArrow = player.getAbilities().instabuild ||
                            (projectileItem) instanceof ArrowItem &&
                            ((ArrowItem)projectileItem).isInfinite(projectileStack, stack, player);
                    if (!level.isClientSide) {
                        ArrowItem arrowitem = (ArrowItem)(projectileItem instanceof ArrowItem ? projectileItem : Items.ARROW);
                        AbstractArrow abstractArrow = arrowitem.createArrow(level,projectileStack,player);
                        abstractArrow = customArrow(abstractArrow);
                        defineArrowMotion(abstractArrow, player, velocity);
                        if (velocity >= MAX_VELOCITY - 0.1F) {
                            abstractArrow.setCritArrow(true);
                        }

                        abstractArrow.setBaseDamage(abstractArrow.getBaseDamage() * DAMAGE_BONUS);

                        flameEnchantment(abstractArrow,stack);
                        powerEnchantment(abstractArrow,stack);
                        punchEnchantment(abstractArrow,stack);

                        stack.hurtAndBreak(1, player, (event) ->
                                event.broadcastBreakEvent(player.getUsedItemHand()));
                        if (noConsumeArrow ||
                                player.getAbilities().instabuild && (projectileStack.is(Items.SPECTRAL_ARROW) ||
                                projectileStack.is(Items.TIPPED_ARROW))) {
                            abstractArrow.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                        }
                        level.addFreshEntity(abstractArrow);


                    }

                    level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (level.getRandom().nextFloat() * 0.4F + 1.2F) + (velocity/MAX_VELOCITY) * 0.5F);
                    if (!noConsumeArrow && !player.getAbilities().instabuild) {
                        projectileStack.shrink(1);
                        if (projectileStack.isEmpty()) {
                            player.getInventory().removeItem(projectileStack);
                        }
                    }

                    player.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }

    public float getDrawnPercent(int time) {
        return (float) time / DRAW_DURATION;
    }

    public int getDrawDuration() {
        return DRAW_DURATION;
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return super.getUseDuration(pStack);
    }

    public float getVelocity(int time) {
        return Mth.lerp(getDrawnPercent(time), MIN_VELOCITY, MAX_VELOCITY);
    }

    public void defineArrowMotion(AbstractArrow arrow, Player player, float velocity) {
        float xRot = player.getXRot();
        float yRot = player.getYRot();
        arrow.shootFromRotation(player, xRot, yRot, 0.0F, velocity, INACCURACY);
    }

    public void flameEnchantment(AbstractArrow arrow, ItemStack stack) {
        int flameLevel = stack.getEnchantmentLevel(Enchantments.FLAMING_ARROWS);
        if (flameLevel > 0) {
            arrow.setSecondsOnFire(100);
        }
    }

    public void powerEnchantment(AbstractArrow arrow, ItemStack stack) {
        int powerLevel = stack.getEnchantmentLevel(Enchantments.POWER_ARROWS);
        if (powerLevel > 0) {
            arrow.setBaseDamage(arrow.getBaseDamage() + (double) powerLevel * 0.5D + 0.5D);
        }
    }
    public void punchEnchantment(AbstractArrow arrow, ItemStack stack) {
        int punchLevel = stack.getEnchantmentLevel(Enchantments.PUNCH_ARROWS);
        if (punchLevel > 0) {
            arrow.setKnockback(punchLevel);
        }
    }

    public static class BowProperties {
        int DRAW_DURATION;
        float MIN_VELOCITY;
        float MAX_VELOCITY;
        float INACCURACY;
        double DAMAGE_BONUS;

        public ModifiableBowItem.BowProperties setDrawDuration(int drawDuration) {
            this.DRAW_DURATION = drawDuration;
            return this;
        }

        public ModifiableBowItem.BowProperties setMinVelocity(float minVelocity) {
            this.MIN_VELOCITY = minVelocity;
            return this;
        }

        public ModifiableBowItem.BowProperties setMaxVelocity(float maxVelocity) {
            this.MAX_VELOCITY = maxVelocity;
            return this;
        }

        public ModifiableBowItem.BowProperties setInaccuracy(float inaccuracy) {
            this.INACCURACY = inaccuracy;
            return this;
        }

        public ModifiableBowItem.BowProperties setDamageBonus(double damageBonus) {
            this.DAMAGE_BONUS = damageBonus;
            return this;
        }
    }

}
