package net.crazedaerialcable.weaponworks.config;

import com.google.gson.*;
import io.github.hornster.itemfig.api.serialization.ItemFigApi;
import net.crazedaerialcable.weaponworks.Weaponworks;
import net.crazedaerialcable.weaponworks.config.helpers.ConfigHelper;
import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.ObjectAdaptersConfigsFactory;
import net.crazedaerialcable.weaponworks.config.objects.ConfigObjectFactory;
import net.crazedaerialcable.weaponworks.config.objects.WeaponConfigObj;
import net.crazedaerialcable.weaponworks.enums.WeaponTypesEnum;
import net.minecraft.item.ToolMaterials;

import java.util.*;


import static net.crazedaerialcable.weaponworks.constants.CommonConstants.CONFIG_FILE_NAME;
import static net.crazedaerialcable.weaponworks.constants.CommonConstants.CONFIG_FILE_NAME_SUFFIX;

public class WeaponworksConfig {

    public static Map<WeaponTypesEnum, Map<ToolMaterials, WeaponConfigObj>> WEAPON_CONFIGS;

    public static Map CONFIG = new TreeMap<>();

    private static void registerConfigObj(ObjectAdaptersConfigsFactory adapterConfigFactory, ConfigObjectFactory configObjFactory, WeaponTypesEnum weaponType, ToolMaterials tier) throws Exception {
        var adapterConfig = adapterConfigFactory.createObjectAdapterConfig(weaponType, tier);
        var configObj = configObjFactory.createObjectConfig(weaponType, tier);

        ItemFigApi.registerObject(configObj, adapterConfig);
    }
    /**
     * Registers config objects and their adapters for config read and write.
     * */
    private static void registerItemsConfigs(){
        var adapterConfigFactory = new ObjectAdaptersConfigsFactory();
        var configObjFactory = new ConfigObjectFactory();
        var logger = Weaponworks.LOGGER;
        for(var weaponType : WeaponTypesEnum.values()){
            for(var tier : ToolMaterials.values()){
                try{
                    registerConfigObj(adapterConfigFactory, configObjFactory, weaponType, tier);
                }
                catch(Exception ex){
                    logger.warn(ex.getMessage());
                }
            }
        }
    }
    private static Map<WeaponTypesEnum, Map<ToolMaterials, WeaponConfigObj>> getAllElements(){
        var weaponTypes = WeaponTypesEnum.values();
        var toolMaterials = ToolMaterials.values();

        //Linked hash maps preserve order
        var result = new LinkedHashMap<WeaponTypesEnum, Map<ToolMaterials, WeaponConfigObj>>();

        for(var weaponType : weaponTypes){
            var weaponConfigsByTier = new LinkedHashMap<ToolMaterials, WeaponConfigObj>();
            for(var tier : toolMaterials){
                var weaponId = ConfigHelper.getWeaponId(weaponType, tier);
                var config = (WeaponConfigObj)ItemFigApi.getItemConfig(weaponId);

                if(config != null){
                    weaponConfigsByTier.put(tier, config);
                }
            }
            result.put(weaponType, weaponConfigsByTier);
        }

        return result;
    }
    public static void register() {
        ItemFigApi.setConfigFileName(CONFIG_FILE_NAME + CONFIG_FILE_NAME_SUFFIX);

        registerItemsConfigs();

        ItemFigApi.readConfig();

        WEAPON_CONFIGS = getAllElements();
    }
}
