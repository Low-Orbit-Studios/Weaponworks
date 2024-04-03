package net.twomoonsstudios.moonsweaponry.enchanting;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class WeaponworksThrowableEnchantment extends WeaponworksEnchantment {
    protected WeaponworksThrowableEnchantment(Rarity pRarity, EquipmentSlot... pApplicableSlots) {
        super(pRarity, THROWABLE_ENCHANTMENT_CATEGORY, pApplicableSlots);
    }
}
