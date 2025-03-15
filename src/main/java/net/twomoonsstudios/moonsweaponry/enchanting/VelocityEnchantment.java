package net.twomoonsstudios.moonsweaponry.enchanting;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraftforge.fml.loading.FMLPaths;
import net.twomoonsstudios.moonsweaponry.MoonsWeaponry;
import net.twomoonsstudios.moonsweaponry.newConfig.ConfigHelper;

import java.util.Map;

public class VelocityEnchantment extends WeaponworksThrowableEnchantment {

    private static final Map<String,Object> config = MoonsWeaponry.getConfigHelper().weaponworksConfig.enchantmentConstants;
    private static final int maxLevel = Math.round(((Double) config.get("velocityEnchantMaxLevel")).floatValue());
    private static final float multiplierPerLevel = ((Double) config.get("velocityEnchantLevelIncrease")).floatValue();

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
        return maxLevel;
    }
    /**
     * Modifies the provided velocity by amount dictated by the enchantment level.*/
    public static float modifyVelocity(float baseVelocity, int enchantmentLevel){
        if(enchantmentLevel > maxLevel){
            enchantmentLevel = maxLevel;
        }
        var totalIncrease = 1 + multiplierPerLevel * enchantmentLevel; //1 for easy multiplication
        return baseVelocity * totalIncrease;
    }
}
