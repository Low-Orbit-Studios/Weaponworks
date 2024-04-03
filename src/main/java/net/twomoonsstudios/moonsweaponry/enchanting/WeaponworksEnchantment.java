package net.twomoonsstudios.moonsweaponry.enchanting;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.twomoonsstudios.moonsweaponry.item.ThrowableWeaponItem;

import static net.twomoonsstudios.moonsweaponry.constants.EnchantmentConstants.THROWABLE_ENCHANT_CATEGORY_NAME;

public class WeaponworksEnchantment extends Enchantment {
    public static EnchantmentCategory THROWABLE_ENCHANTMENT_CATEGORY =
            EnchantmentCategory.create(THROWABLE_ENCHANT_CATEGORY_NAME, (Item item) -> item instanceof ThrowableWeaponItem || item.equals(Items.ENCHANTED_BOOK));
    protected WeaponworksEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

}
