//package net.crazedaerialcable.weaponworks.item;
//
//import com.google.common.collect.ImmutableMultimap;
//import net.crazedaerialcable.weaponworks.config.WeaponworksConfig;
//import net.minecraft.item.Vanishable;
//
//public class TriforgeTieredItem extends Material implements Vanishable {
//    private final float attackDamage;
//    /** Modifiers applied when the item is in the mainhand of a user. */
//    protected final Multimap<Attribute, AttributeModifier> defaultModifiers;
//
//    public TriforgeTieredItem(WeaponworksConfig.WeaponInfo stats) {
//        this(stats.tier, stats.damage, stats.speed, stats.fireRes
//                ? new Item.Properties()//.tab(CreativeModeTab.TAB_COMBAT)
//                        .defaultDurability(stats.durability).fireResistant()
//                : new Item.Properties()//.tab(CreativeModeTab.TAB_COMBAT)
//                        .defaultDurability(stats.durability));
//    }
//
//    public TriforgeTieredItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Item.Properties pProperties) {
//        super(pTier, pProperties);
//        this.attackDamage = (float)pAttackDamageModifier;
//        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
//        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", (double)this.attackDamage, AttributeModifier.Operation.ADDITION));
//        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", (double)pAttackSpeedModifier, AttributeModifier.Operation.ADDITION));
//        this.defaultModifiers = builder.build();
//    }
//    @Override
//    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot pEquipmentSlot) {
//        return pEquipmentSlot == EquipmentSlot.MAINHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers(pEquipmentSlot);
//    }
//
//    /**
//     * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
//     * the damage on the stack.
//     */
//    @Override
//    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
//        pStack.hurtAndBreak(1, pAttacker, (event) -> {
//            event.broadcastBreakEvent(EquipmentSlot.MAINHAND);
//        });
//        return true;
//    }
//
//    /**
//     * Called when a {@link net.minecraft.world.level.block.Block} is destroyed using this Item. Return {@code true} to
//     * trigger the "Use Item" statistic.
//     */
//    @Override
//    public boolean mineBlock(ItemStack pStack, Level pLevel, BlockState pState, BlockPos pPos, LivingEntity pEntityLiving) {
//        if (pState.getDestroySpeed(pLevel, pPos) != 0.0F) {
//            pStack.hurtAndBreak(2, pEntityLiving, (broken) -> {
//                broken.broadcastBreakEvent(EquipmentSlot.MAINHAND);
//            });
//        }
//
//        return true;
//    }
//    @Override
//
//    public boolean canAttackBlock(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer) {
//        return !pPlayer.isCreative();
//    }
//}
