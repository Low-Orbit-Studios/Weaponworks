package net.twomoonsstudios.moonsweaponry.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.registries.RegistryObject;
import net.twomoonsstudios.moonsweaponry.enchanting.CapacityEnchantment;
import net.twomoonsstudios.moonsweaponry.enchanting.ModEnchantments;
import net.twomoonsstudios.moonsweaponry.enchanting.VelocityEnchantment;
import net.twomoonsstudios.moonsweaponry.entity.AbstractThrowable;

import static net.twomoonsstudios.moonsweaponry.constants.ThrownWeaponDataConstants.THROWABLES_FLAME_ENCHANT_SECONDS;


public abstract class ThrowableWeaponItem extends TieredItem {

    /**Set to TRUE after registering the events since the events have to be
     * registered only once.*/
    private static boolean eventsRegistered;
    protected float throwVelocity;
    /**
     * Cooldown, in ticks, between throwing two throwables.*/
    protected int cooldown;
    protected float inaccuracy;

    protected int baseDamage;

    public ThrowableWeaponItem(Tier pTier, ThrowableProperties throwableProperties, Properties pProperties) {
        super(pTier, pProperties);
        this.throwVelocity = throwableProperties.throwVelocity;
        this.cooldown = throwableProperties.cooldown;
        this.inaccuracy = throwableProperties.inaccuracy;
        this.baseDamage = throwableProperties.baseDamage;
        MinecraftForge.EVENT_BUS.addListener(EventPriority.LOW, this::OnAnvilUpdate);
        //MinecraftForge.EVENT_BUS.addListener(EventPriority.LOW, this::OnAnvilRepair);
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
        if(enchantment.equals(Enchantments.UNBREAKING)){
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

    //things that fire more than one projectile should take more than one from the stack
    public int useCost() {
        return 1;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {

        ItemStack itemStack = player.getItemInHand(hand);
        boolean mainHandPriority = true;
        if (hand.equals(InteractionHand.OFF_HAND) && (player.getItemInHand(InteractionHand.MAIN_HAND).getItem() instanceof ThrowableWeaponItem)) {
           mainHandPriority = false;
        }


        if (itemStack.getDamageValue() < itemStack.getMaxDamage() && !level.isClientSide && mainHandPriority) {
            //We throw one item at a time - hence 1
            itemStack.hurt(useCost(), null, null);
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

            shootingAction(level, entityForThrowing, player, playerXRot, playerYRot, 0, entityForThrowing.getInitialVelocity(), inaccuracy, itemStack);
            for (RegistryObject<Item> item: ModItems.ITEMS.getEntries()) {
                if (item.get() instanceof ThrowableWeaponItem throwingItem) {
                    player.getCooldowns().addCooldown(throwingItem, cooldown);
                }
            }
        }
        return super.use(level, player, hand);
    }

    // having this allows for more complex things than just "throw one thing where the player is looking" like shurikens
    public void shootingAction(Level level, AbstractThrowable entity, Player player, float xRot, float yRot, float zRot, float initialVelocity, float inaccuracy, ItemStack itemStack) {
        entity.shootFromRotation(player, xRot, yRot, zRot, initialVelocity, inaccuracy);
        level.addFreshEntity(entity);
    }

    @Override
    public float getXpRepairRatio(ItemStack stack) {
        return 1f;
    }

    protected void OnAnvilUpdate(AnvilUpdateEvent event){
        if(event.getPlayer().getLevel().isClientSide){
            return;
        }
        var outputItemStack = event.getOutput();

        var isLeftItemThrowable = false;
        var isRightItemThrowable = false;

        var rightItemStack = event.getRight();
        var rightItem = rightItemStack.getItem();
        if(rightItem instanceof  ThrowableWeaponItem){
            isRightItemThrowable = true;
            rightItemStack.setRepairCost(0);
        }

        var leftItemStack = event.getLeft();
        var leftItem = leftItemStack.getItem();
        if(leftItem instanceof ThrowableWeaponItem){
            isLeftItemThrowable = true;
            leftItemStack.setRepairCost(0);

            if(leftItem.isValidRepairItem(leftItemStack, rightItemStack) && !isRightItemThrowable){
                outputItemStack = leftItemStack.copy();
                outputItemStack.setDamageValue(0);//We need only one item to fix a throwable fully.
                event.setOutput(outputItemStack);
            }
        }
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

    protected void applyEnchantments(ItemStack itemStack, AbstractThrowable projectile){
        var punchEnchantmentLevel = itemStack.getEnchantmentLevel(Enchantments.PUNCH_ARROWS);
        var flameEnchantmentLevel = itemStack.getEnchantmentLevel(Enchantments.FLAMING_ARROWS);
        var velocityEnchantmentLevel = itemStack.getEnchantmentLevel(ModEnchantments.VELOCITY_ENCHANTMENT.get());

        if(punchEnchantmentLevel > 0){
            projectile.setKnockback(punchEnchantmentLevel);
        }

        if(flameEnchantmentLevel > 0){
            projectile.setSecondsOnFire(THROWABLES_FLAME_ENCHANT_SECONDS);
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
