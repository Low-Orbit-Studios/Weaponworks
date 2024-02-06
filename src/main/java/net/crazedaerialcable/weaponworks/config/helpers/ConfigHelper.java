package net.crazedaerialcable.weaponworks.config.helpers;

import net.minecraft.item.ToolMaterials;
import net.crazedaerialcable.weaponworks.enums.WeaponTypesEnum;

import static net.crazedaerialcable.weaponworks.constants.CommonConstants.*;

public class ConfigHelper {
    public static String getVanillaMaterialName(ToolMaterials materialTier){
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
    public static String getWeaponId(WeaponTypesEnum weaponType, ToolMaterials materialTier){
        var materialName = getVanillaMaterialName(materialTier);
        var weaponName = weaponType.getBaseId();

        return materialName + "_" + weaponName;
    }
}
