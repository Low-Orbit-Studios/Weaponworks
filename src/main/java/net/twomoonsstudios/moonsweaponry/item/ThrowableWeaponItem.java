package net.twomoonsstudios.moonsweaponry.item;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.registries.RegistryObject;
import net.twomoonsstudios.moonsweaponry.MoonsWeaponry;
import net.twomoonsstudios.moonsweaponry.enchanting.CapacityEnchantment;
import net.twomoonsstudios.moonsweaponry.enchanting.ModEnchantments;
import net.twomoonsstudios.moonsweaponry.enchanting.VelocityEnchantment;
import net.twomoonsstudios.moonsweaponry.entity.AbstractThrowable;
import net.twomoonsstudios.moonsweaponry.entity.ThrownBombEntity;
import net.twomoonsstudios.moonsweaponry.item.weapons.BombItem;
import net.twomoonsstudios.moonsweaponry.newConfig.ConfigHelper;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public abstract class ThrowableWeaponItem extends TieredItem {

    protected float throwVelocity;
    /**
     * Cooldown, in ticks, between throwing two throwables.*/
    protected int cooldown;
    protected float inaccuracy;

    protected int baseDamage;

    private ConfigHelper config = new ConfigHelper(FMLPaths.CONFIGDIR.get());

    public ThrowableWeaponItem(Tier pTier, ThrowableProperties throwableProperties, Properties pProperties) {
        super(pTier, pProperties);
        this.throwVelocity = throwableProperties.throwVelocity;
        this.cooldown = throwableProperties.cooldown;
        this.inaccuracy = throwableProperties.inaccuracy;
        this.baseDamage = throwableProperties.baseDamage;
        //MinecraftForge.EVENT_BUS.addListener(EventPriority.LOW, this::OnAnvilUpdate);
        //MinecraftForge.EVENT_BUS.addListener(EventPriority.LOW, this::OnAnvilRepair);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.literal( (getMaxDamage(pStack) - getDamage(pStack)) +" uses remaining").withStyle(ChatFormatting.DARK_GREEN));
        pTooltipComponents.add(Component.literal( (this.baseDamage) + " damage").withStyle(ChatFormatting.DARK_GREEN));
    }

    @Override
    public int getBarColor(ItemStack pStack) {
        return 0x0e629e;
    }

    @Override
    public boolean isBarVisible(ItemStack pStack) {
        return true;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        if(enchantment.equals(Enchantments.UNBREAKING) || enchantment.equals(Enchantments.MENDING)){
            return false;
        }
        else if(enchantment.equals(Enchantments.FLAMING_ARROWS) || enchantment.equals(Enchantments.PUNCH_ARROWS)){
            return true;
        }
        else{
            return super.canApplyAtEnchantingTable(stack, enchantment);
        }
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        var baseMaxDurability = super.getMaxDamage(stack);
        var capacityLevel = stack.getEnchantmentLevel(ModEnchantments.CAPACITY_ENCHANTMENT.get());
        var modifiedDurability = CapacityEnchantment.modifyDurability(baseMaxDurability, capacityLevel);
        return modifiedDurability;
    }

    public int getBaseDamage() {
        return this.baseDamage;
    }

    public float getBaseVelocity() {return this.throwVelocity;}

    //things that fire more than one projectile should take more than one from the stack
    public int useCost() {
        return 1;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        boolean mainHandPriority = true;
        ItemStack itemStack = player.getItemInHand(hand);
        if (hand.equals(InteractionHand.OFF_HAND) && (player.getItemInHand(InteractionHand.MAIN_HAND).getItem() instanceof ThrowableWeaponItem)) {
            mainHandPriority = false;
        }
        if (itemStack.getDamageValue() + useCost() <= itemStack.getMaxDamage() && !level.isClientSide && mainHandPriority) {
            player.startUsingItem(hand);
            return InteractionResultHolder.consume(itemStack);
        };
        return super.use(level, player, hand);
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 72000;
    }

    @Override
    public @NotNull UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.SPEAR;
    }

    @Override
    public void releaseUsing(ItemStack itemStack, Level level, LivingEntity pLivingEntity, int timeCharged) {
        Player player = (Player) pLivingEntity;
        if (72000 - timeCharged > 10) {
            if (!player.getAbilities().instabuild) {itemStack.hurt(useCost(), null, null);}
            AbstractThrowable entityForThrowing = null;//new ThrownIronDaggerEntity(level, player, itemStack);
            try {
                entityForThrowing = createThrownEntity(level, player, itemStack, throwVelocity);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            this.applyEnchantments(itemStack, entityForThrowing);
            entityForThrowing.setOwner(player);
            //for easier debugging.
            var playerXRot = player.getXRot();
            var playerYRot = player.getYRot();
            shootingAction(level, entityForThrowing, player, playerXRot, playerYRot,  0,  entityForThrowing.getInitialVelocity(), inaccuracy, itemStack);
            for (RegistryObject<Item> item : ModItems.ITEMS.getEntries()) {
                if (item.get() instanceof ThrowableWeaponItem throwingItem) {
                    player.getCooldowns().addCooldown(throwingItem, cooldown);
                }
            }
            if (this instanceof BombItem && !(player.getAbilities().instabuild)) {
                itemStack.shrink(1);
            }
        }

        super.releaseUsing(itemStack, level, pLivingEntity, timeCharged);
    }

    // having this allows for more complex things than just "throw one thing where the player is looking" like shurikens
    public void shootingAction(Level level, AbstractThrowable entity, Player player, float xRot, float yRot, float zRot, float initialVelocity, float inaccuracy, ItemStack itemStack) {
        entity.shootFromRotation(player, xRot, yRot, zRot, entity.getInitialVelocity(), inaccuracy);
        level.addFreshEntity(entity);
    }

    @Override
    public float getXpRepairRatio(ItemStack stack) {
        return 1f;
    }

//    protected void OnAnvilUpdate(AnvilUpdateEvent event){
//        if(event.getPlayer().getLevel().isClientSide){
//            return;
//        }
//        var outputItemStack = event.getOutput();
//
//        var isLeftItemThrowable = false;
//        var isRightItemThrowable = false;
//
//        var rightItemStack = event.getRight();
//        var rightItem = rightItemStack.getItem();
//        if(rightItem instanceof  ThrowableWeaponItem){
//            isRightItemThrowable = true;
//            rightItemStack.setRepairCost(0);
//        }
//
//        var leftItemStack = event.getLeft();
//        var leftItem = leftItemStack.getItem();
//        if(leftItem instanceof ThrowableWeaponItem){
//            isLeftItemThrowable = true;
//            leftItemStack.setRepairCost(0);
//
//            if(leftItem.isValidRepairItem(leftItemStack, rightItemStack) && !isRightItemThrowable){
//                outputItemStack = leftItemStack.copy();
//                outputItemStack.setDamageValue(0);//We need only one item to fix a throwable fully.
//                event.setOutput(outputItemStack);
//            }
//        }
//    }

    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        var unbLevel = book.getEnchantmentLevel(Enchantments.UNBREAKING);
        if (unbLevel != 0) {return false;}
        else {return super.isBookEnchantable(stack, book);}
    }

    @Override
    public int getEnchantmentLevel(ItemStack stack, Enchantment enchantment) {
        if (enchantment == Enchantments.UNBREAKING) {return 0;}
        return super.getEnchantmentLevel(stack, enchantment);
    }

    //    private void OnAnvilRepair(AnvilRepairEvent event) {
//        var isLeftItemThrowable = false;
//        var isRightItemThrowable = false;
//        var leftItemStack = event.getLeft();
//        var leftItem = leftItemStack.getItem();
//        if(leftItem instanceof ThrowableWeaponItem){
//            isLeftItemThrowable = true;
//        }
//
//        var rightItemStack = event.getRight();
//        var rightItem = rightItemStack.getItem();
//        if(rightItem instanceof  ThrowableWeaponItem){
//            isRightItemThrowable = true;
//        }
//
//        var outputItemStack = event.getOutput();
//        var outputItem = outputItemStack.getItem();
//
//        var bothIngredientsThrowables = isLeftItemThrowable && isRightItemThrowable;
//
//        if(outputItem instanceof ThrowableWeaponItem && !bothIngredientsThrowables){
//            //If we are fixing with a material, we fix entire stack with just one item.
//            //outputItemStack.setDamageValue(0);
//        }
//    }

    public void applyEnchantments(ItemStack itemStack, AbstractThrowable projectile) {
        var punchEnchantmentLevel = itemStack.getEnchantmentLevel(Enchantments.PUNCH_ARROWS);
        var flameEnchantmentLevel = itemStack.getEnchantmentLevel(Enchantments.FLAMING_ARROWS);
        var velocityEnchantmentLevel = itemStack.getEnchantmentLevel(ModEnchantments.VELOCITY_ENCHANTMENT.get());

        if(punchEnchantmentLevel > 0){
            projectile.setKnockback(punchEnchantmentLevel);
        }

        if(flameEnchantmentLevel > 0){
            projectile.setSecondsOnFire(Math.round(((Double) config.weaponworksConfig.enchantmentConstants.get("flameEnchantProjectileSeconds")).floatValue()));
        }

        if(velocityEnchantmentLevel > 0){
            var newThrownVelocity = VelocityEnchantment.modifyVelocity(throwVelocity, velocityEnchantmentLevel);
            projectile.setInitialVelocity(newThrownVelocity);
            projectile.setVelocityEnchantmentLevel(velocityEnchantmentLevel);
        }
    }

    protected abstract AbstractThrowable createThrownEntity(Level level, Player player, ItemStack itemStack, float initialVelocity) throws ClassNotFoundException;

    public static class ThrowableProperties {
        float throwVelocity;
        float inaccuracy;
        int cooldown;
        int baseDamage;

        public ThrowableWeaponItem.ThrowableProperties setThrowVelocity(float velocity){
            throwVelocity = velocity;
            return this;
        }
        public ThrowableWeaponItem.ThrowableProperties setInaccuracy(float inaccuracy){
            this.inaccuracy = inaccuracy;
            return this;
        }
        public ThrowableWeaponItem.ThrowableProperties setCooldown(int cooldown){
            this.cooldown = cooldown;
            return this;
        }
        public ThrowableWeaponItem.ThrowableProperties setBaseDamage(int baseDamage){
            this.baseDamage = baseDamage;
            return this;
        }
    }
}
