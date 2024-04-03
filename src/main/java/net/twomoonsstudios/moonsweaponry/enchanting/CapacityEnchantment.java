package net.twomoonsstudios.moonsweaponry.enchanting;

import net.minecraft.world.entity.EquipmentSlot;

import static net.twomoonsstudios.moonsweaponry.constants.EnchantmentConstants.CAPACITY_ENCHANTMENT_MAX_LEVEL;
import static net.twomoonsstudios.moonsweaponry.constants.EnchantmentConstants.VELOCITY_ENCHANTMENT_MAX_LEVEL;

public class CapacityEnchantment extends WeaponworksThrowableEnchantment{
    protected CapacityEnchantment(Rarity pRarity, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pApplicableSlots);
    }
    //Taken from SweepingEdge enchantment. Starts showing up since level 5, next grade is from level 18.
    public int getMinCost(int pEnchantmentLevel) {
        return 5 + (pEnchantmentLevel - 1) * 13;
    }
    //Taken from SweepingEdge enchantment.
    //Values are supposed to carry it up to 30th level. Arbitrary chosen.
    public int getMaxCost(int pEnchantmentLevel) {
        return this.getMinCost(pEnchantmentLevel) + 12;
    }

    public int getMaxLevel(){
        return CAPACITY_ENCHANTMENT_MAX_LEVEL;
    }
}
