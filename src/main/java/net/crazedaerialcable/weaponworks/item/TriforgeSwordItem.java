package net.crazedaerialcable.weaponworks.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.crazedaerialcable.weaponworks.config.objects.WeaponConfigObj;


public class TriforgeSwordItem extends SwordItem {
    private TriforgeSwordItem(ToolMaterial pTier, int pAttackDamageModifier, float pAttackSpeedModifier, FabricItemSettings fabricSettings) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, fabricSettings);
    }

    public TriforgeSwordItem(WeaponConfigObj stats) {
        this(stats.getTier(), CorrectDamage(stats.getTier(), stats.damage), stats.getMcAttackSpeed(), stats.fire_resistant
                ? new FabricItemSettings().maxDamage(stats.durability).group(ItemGroup.COMBAT).fireproof()
                : new FabricItemSettings().maxDamage(stats.durability).group(ItemGroup.COMBAT));
    }

    /**
     * Applies a correction to damage value, making it easier for people who modify
     * the config files to set the damage they want for the weapon.*/
    private static int CorrectDamage(ToolMaterial pTier, int pAttackDamageModifier){
        return (int)(pAttackDamageModifier - pTier.getAttackDamage());
    }
}
