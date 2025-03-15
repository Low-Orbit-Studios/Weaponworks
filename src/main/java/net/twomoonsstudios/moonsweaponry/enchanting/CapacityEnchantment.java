package net.twomoonsstudios.moonsweaponry.enchanting;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.loading.FMLPaths;
import net.twomoonsstudios.moonsweaponry.MoonsWeaponry;
import net.twomoonsstudios.moonsweaponry.item.ThrowableWeaponItem;
import net.twomoonsstudios.moonsweaponry.newConfig.ConfigHelper;

import java.util.Map;

public class CapacityEnchantment extends WeaponworksThrowableEnchantment{

    private static final Map<String,Object> config = MoonsWeaponry.getConfigHelper().weaponworksConfig.enchantmentConstants;
    private static final int maxLevel = Math.round(((Double) config.get("capacityEnchantMaxLevel")).floatValue());
    private static final float multiplierPerLevel = ((Double) config.get("capacityEnchantLevelIncrease")).floatValue();

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
        return maxLevel;
    }

    public static int modifyDurability(int baseDurability, int enchantmentLevel){
        if(enchantmentLevel > maxLevel){
            enchantmentLevel = maxLevel;
        }
        var totalIncrease = 1 + multiplierPerLevel * enchantmentLevel;//1 for easy multiplication
        var newDurability = baseDurability * totalIncrease;
        return Math.round(newDurability);
    }

    @Override
    public boolean canEnchant(ItemStack pStack) {
        return pStack.getItem() instanceof ThrowableWeaponItem;
    }
}
