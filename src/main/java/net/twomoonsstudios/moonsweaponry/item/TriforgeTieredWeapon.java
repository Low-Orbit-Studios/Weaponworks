package net.twomoonsstudios.moonsweaponry.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.Vanishable;
import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;

public class TriforgeTieredWeapon extends TieredItem implements Vanishable {
    private final float attackDamage;
    /** Modifiers applied when the item is in the mainhand of a user. */
    protected final Multimap<Attribute, AttributeModifier> defaultModifiers;

    public TriforgeTieredWeapon(MoonsWeaponsConfig.WeaponInfo stats) {
        this(stats.tier, stats.damage, stats.speed, stats.fireRes
                ? new Item.Properties().tab(ModCreativeModeTab.MOD_TAB)
                        .defaultDurability(stats.durability).fireResistant()
                : new Item.Properties().tab(ModCreativeModeTab.MOD_TAB)
                        .defaultDurability(stats.durability));
    }

    public TriforgeTieredWeapon(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Item.Properties pProperties) {
        super(pTier, pProperties);
        this.attackDamage = (float)pAttackDamageModifier;// + pTier.getAttackDamageBonus();
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", (double)this.attackDamage, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", (double)pAttackSpeedModifier, AttributeModifier.Operation.ADDITION));
        this.defaultModifiers = builder.build();
    }
    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot pEquipmentSlot) {
        return pEquipmentSlot == EquipmentSlot.MAINHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers(pEquipmentSlot);
    }
}