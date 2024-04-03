package net.twomoonsstudios.moonsweaponry.enchanting;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.twomoonsstudios.moonsweaponry.item.ThrowableWeaponItem;

import static net.twomoonsstudios.moonsweaponry.constants.EnchantmentConstants.VELOCITY_ENCHANTMENT_MAX_LEVEL;

public class VelocityEnchantment extends WeaponworksThrowableEnchantment {
    protected VelocityEnchantment(Rarity pRarity, EquipmentSlot pApplicableSlots) {
        super(pRarity, pApplicableSlots);
    }

    //Taken from SweepingEdge enchantment
    public int getMinCost(int pEnchantmentLevel) {
        return 5 + (pEnchantmentLevel - 1) * 9;
    }
    //Taken from SweepingEdge enchantment
    public int getMaxCost(int pEnchantmentLevel) {
        return this.getMinCost(pEnchantmentLevel) + 15;
    }

    public int getMaxLevel(){
        return VELOCITY_ENCHANTMENT_MAX_LEVEL;
    }
}
