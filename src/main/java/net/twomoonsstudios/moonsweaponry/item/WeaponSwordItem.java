package net.twomoonsstudios.moonsweaponry.item;

import net.minecraft.world.item.*;
import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.WeaponConfigObj;


public class WeaponSwordItem extends SwordItem {

    private WeaponSwordItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Item.Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }
    @Deprecated
    /**@Deprecated Use TriforgeSwordItem(WeaponConfigObj stats) version.*/
    public WeaponSwordItem(MoonsWeaponsConfig.WeaponInfo stats) {
        //Damage needs to be corrected in our case to make editing config more
        //straightforward. No other way of doing this since SwordItem is adding tier damage
        //in its constructor.
        this(stats.tier, CorrectDamage(stats.tier, stats.damage), stats.speed, stats.fireRes
                ? new Properties().tab(CreativeModeTab.TAB_COMBAT)
                        .defaultDurability(stats.durability).fireResistant()
                : new Properties().tab(CreativeModeTab.TAB_COMBAT)
                        .defaultDurability(stats.durability));
    }

    public WeaponSwordItem(WeaponConfigObj stats) {
        this(stats.getTier(), CorrectDamage(stats.getTier(), stats.damage), stats.getMcAttackSpeed(), stats.fire_resistant
                ? new Properties().tab(CreativeModeTab.TAB_COMBAT)
                .defaultDurability(stats.durability).fireResistant()
                : new Properties().tab(CreativeModeTab.TAB_COMBAT)
                .defaultDurability(stats.durability));
    }

    /**
     * Applies a correction to damage value, making it easier for people who modify
     * the config files to set the damage they want for the weapon.*/
    private static int CorrectDamage(Tier pTier, int pAttackDamageModifier){
        return (int)(pAttackDamageModifier - pTier.getAttackDamageBonus());
    }
}
