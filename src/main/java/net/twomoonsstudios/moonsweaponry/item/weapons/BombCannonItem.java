package net.twomoonsstudios.moonsweaponry.item.weapons;

import com.google.common.collect.Lists;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.twomoonsstudios.moonsweaponry.MoonsWeaponry;
import net.twomoonsstudios.moonsweaponry.entity.AbstractThrowable;
import net.twomoonsstudios.moonsweaponry.entity.ThrownBombEntity;
import net.twomoonsstudios.moonsweaponry.item.ModItems;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BombCannonItem extends Item {
    public BombCannonItem(Properties pProperties) {
        super(pProperties);
    }

    //public boolean isArmed = false;
    //public boolean isCharging = false;

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, @NotNull InteractionHand pUsedHand) {
        ItemStack usedItemStack = pPlayer.getItemInHand(pUsedHand);
        if (isArmed(usedItemStack)) {
            if (!pLevel.isClientSide) {
                AbstractThrowable bomb = new ThrownBombEntity(pLevel, pPlayer, usedItemStack, 2.0f);
                var xRot = pPlayer.getXRot();
                var yRot = pPlayer.getYRot();
                var zRot = 0;
                bomb.shootFromRotation(pPlayer, xRot, yRot, zRot, bomb.getInitialVelocity(), 0.05f);
                pLevel.addFreshEntity(bomb);
                setArmed(usedItemStack,false);
                pPlayer.getCooldowns().addCooldown(usedItemStack.getItem(), 80);
                return InteractionResultHolder.success(usedItemStack);
            } else return super.use(pLevel,pPlayer,pUsedHand);
        } if (findAmmoSlot(pPlayer) != -1 || pPlayer.getAbilities().instabuild) {
            pPlayer.startUsingItem(pUsedHand);
            setCharging(usedItemStack,true);
            return InteractionResultHolder.consume(usedItemStack);
        } else {
            return InteractionResultHolder.fail(usedItemStack);
        }
    }
    
    @Override
    public void releaseUsing(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity, int pTimeCharged) {
        float chargePercent = (float) (Math.min(30,pStack.getUseDuration() - pTimeCharged)) / 30;
        if (chargePercent >= 1 && !isArmed(pStack) && tryArmBomb(pStack, pLivingEntity)) {
            setArmed(pStack, true);
        }
        setCharging(pStack, false);
    }

    public boolean tryArmBomb(ItemStack pStack, LivingEntity pLivingEntity) {
        var inventory = (((Player) pLivingEntity).getInventory().items);
        Player player = (Player) pLivingEntity;
        boolean needsAmmo = !player.getAbilities().instabuild;
        int ammoSlot = findAmmoSlot((Player) pLivingEntity);
        if (!(ammoSlot == -1) || !needsAmmo) {
            if (ammoSlot != -1 && needsAmmo) {inventory.get(ammoSlot).shrink(1);}
            return true;
        } else {
            return false;
        }
    }

    public int findAmmoSlot(Player player) {
        return player.getInventory().findSlotMatchingItem(ModItems.BOMB.get().getDefaultInstance());
    }

    @Override
    public void onUsingTick(ItemStack stack, LivingEntity player, int count) {
        super.onUsingTick(stack, player, count);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.CROSSBOW;
    }

    @Override
    public boolean useOnRelease(ItemStack pStack) {
        return pStack.is(this);
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 72000;
    }


    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.literal(isArmed(pStack) ? "Armed!" : "Unarmed"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (pIsSelected && isArmed(pStack)) {
            ((LivingEntity) pEntity).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 1, 0, false,false, false));
        }
    }

    public boolean isCharging(ItemStack itemStack) {
        CompoundTag compoundTag = itemStack.getTag();
        return !(compoundTag == null) && compoundTag.getBoolean("charging");
    }

    public boolean isArmed(ItemStack itemstack) {
        CompoundTag compoundTag = itemstack.getTag();
        return !(compoundTag == null) && compoundTag.getBoolean("armed");
    }

    public void setCharging(ItemStack itemStack, boolean isCharging) {
        CompoundTag compoundTag = itemStack.getOrCreateTag();
        compoundTag.putBoolean("charging", isCharging);
    }

    public void setArmed(ItemStack itemStack, boolean isArmed) {
        CompoundTag compoundTag = itemStack.getOrCreateTag();
        compoundTag.putBoolean("armed", isArmed);
    }
}
