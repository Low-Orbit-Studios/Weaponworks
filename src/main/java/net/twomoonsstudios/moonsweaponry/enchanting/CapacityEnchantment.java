package net.twomoonsstudios.moonsweaponry.enchanting;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.twomoonsstudios.moonsweaponry.entity.AbstractThrowable;
import net.twomoonsstudios.moonsweaponry.item.ThrowableWeaponItem;

import static net.twomoonsstudios.moonsweaponry.constants.EnchantmentConstants.*;

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

    public static int modifyDurability(int baseDurability, int enchantmentLevel){
        if(enchantmentLevel > CAPACITY_ENCHANTMENT_MAX_LEVEL){
            enchantmentLevel = CAPACITY_ENCHANTMENT_MAX_LEVEL;
        }
        var totalIncrease = 1 + CAPACITY_MUL_PER_LEVEL * enchantmentLevel;//1 for easy multiplication
        var newDurability = baseDurability * totalIncrease;
        return Math.round(newDurability);
    }

    @Override
    public boolean canEnchant(ItemStack pStack) {
        return pStack.getItem() instanceof ThrowableWeaponItem;
    }
}
