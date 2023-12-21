package net.twomoonsstudios.moonsweaponry.config.helpers;

import net.minecraft.world.item.Tiers;
import net.twomoonsstudios.moonsweaponry.enums.WeaponTypesEnum;

import static net.twomoonsstudios.moonsweaponry.constants.CommonConstants.*;

public class ConfigHelper {
    public static String getVanillaMaterialName(Tiers materialTier){
        switch(materialTier){

            case WOOD -> {
                return WOOD_MATERIAL_NAME;
            }
            case GOLD -> {
                return GOLD_MATERIAL_NAME;
            }
            default -> {
                return materialTier.name().toLowerCase();
            }
        }
    }
    public static String getWeaponId(WeaponTypesEnum weaponType, Tiers materialTier){
        var materialName = getVanillaMaterialName(materialTier);
        var weaponName = weaponType.getBaseId();

        return materialName + "_" + weaponName;
    }
}
