package net.twomoonsstudios.moonsweaponry.config;

import com.google.common.collect.ImmutableMap;
import com.google.gson.*;
import com.ibm.icu.impl.number.MutablePatternModifier;
import io.github.hornster.itemfig.api.serialization.ItemFigApi;
import io.github.hornster.itemfig.api.serialization.config.ConfigObj;
import io.github.hornster.itemfig.api.serialization.config.ConfigObjAdapterConfig;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.twomoonsstudios.moonsweaponry.MoonsWeaponry;
import net.twomoonsstudios.moonsweaponry.config.deprecated.ConfigEntry;
import net.twomoonsstudios.moonsweaponry.config.helpers.ConfigHelper;
import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.ObjectAdaptersConfigsFactory;
import net.twomoonsstudios.moonsweaponry.config.objects.ConfigObjectFactory;
import net.twomoonsstudios.moonsweaponry.config.objects.WeaponConfigObj;
import net.twomoonsstudios.moonsweaponry.constants.CommonConstants;
import net.twomoonsstudios.moonsweaponry.enums.WeaponTypesEnum;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;


import static net.twomoonsstudios.moonsweaponry.constants.CommonConstants.CONFIG_FILE_NAME_SUFFIX;
import static net.twomoonsstudios.moonsweaponry.constants.WeaponDataConstants.*;

public class MoonsWeaponsConfig {

    public static final ConfigEntry<Double> VERSION = new ConfigEntry<>("TECHNICAL.VERSION_DO_NOT_EDIT", 0d);
    public static final ConfigEntry<Boolean> RELOAD = new ConfigEntry<>("TECHNICAL.FORCE_RESET", false);

    /**Deprecated. Used only for converting old config type.*/
    protected static Map<String, WeaponInfo> WEAPONS = new HashMap<>();
    public static Map<WeaponTypesEnum, Map<Tiers, WeaponConfigObj>> WEAPON_CONFIGS;

    public static final Map<String, Float> WEAPON_SPEEDS = Map.of(
            CommonConstants.HALBERD_BASE_ID, HALBERD_DEFAULT_ATK_SPD,
            CommonConstants.WARGLAIVE_BASE_ID, WARGLAIVE_DEFAULT_ATK_SPD,
            CommonConstants.SCYTHE_BASE_ID, SCYTHE_DEFAULT_ATK_SPD,
            CommonConstants.GREATSWORD_BASE_ID, GREATSWORD_DEFAULT_ATK_SPD,
            CommonConstants.HAMMER_BASE_ID, HAMMER_DEFAULT_ATK_SPD
            //No need to add more here. Only these 5 were in legacy version of config.
    );
    public static final String DEFAULT_CONFIG = """
{
  "TECHNICAL": {
    "VERSION_DO_NOT_EDIT": 1,
    "FORCE_RESET": false
  },
  
  "halberd": {
        "wooden": {
          "tier": "WOOD",
          "damage": 6,
          "speed": 1.6,
          "durability": 59
        },
        "stone": {
          "tier": "STONE",
          "damage": 6
        },
        "iron": {
          "tier": "IRON",
          "damage": 7
        },
        "golden": {
            "tier": "GOLD",
            "damage": 8
        },
        "diamond":{
            "tier": "DIAMOND",
            "damage": 8
        },
        "netherite": {
          "tier": "NETHERITE",
          "damage": 9,
          "fire_resistant": true
        }
      },
      "warglaive": {
        "wooden": {
          "tier": "WOOD",
          "damage": 1
        },
        "stone": {
          "tier": "STONE",
          "damage": 1
        },
        "iron": {
          "tier": "IRON",
          "damage": 2
        },
        "golden": {
            "tier": "GOLD",
            "damage": 3
        },
        "diamond":{
            "tier": "DIAMOND",
            "damage": 3
        },
        "netherite": {
          "tier": "NETHERITE",
          "damage": 4,
          "fire_resistant": true
        }
      },
      "scythe": {
        "wooden": {
          "tier": "WOOD",
          "damage": 5
        },
        "stone": {
          "tier": "STONE",
          "damage": 5
        },
        "iron": {
          "tier": "IRON",
          "damage": 6
        },
        "golden": {
            "tier": "GOLD",
            "damage": 7
        },
        "diamond":{
            "tier": "DIAMOND",
            "damage": 7
        },
        "netherite": {
          "tier": "NETHERITE",
          "damage": 8,
          "fire_resistant": true
        }
      },
      "greatsword": {
        "wooden": {
          "tier": "WOOD",
          "damage": 8
        },
        "stone": {
          "tier": "STONE",
          "damage": 8
        },
        "iron": {
          "tier": "IRON",
          "damage": 9
        },
        "golden": {
            "tier": "GOLD",
            "damage": 10
        },
        "diamond":{
            "tier": "DIAMOND",
            "damage": 10
        },
        "netherite": {
          "tier": "NETHERITE",
          "damage": 11,
          "fire_resistant": true
        }
      },
      "hammer": {
        "wooden": {
          "tier": "WOOD",
          "damage": 4
        },
        "stone": {
          "tier": "STONE",
          "damage": 4
        },
        "iron": {
          "tier": "IRON",
          "damage": 5
        },
        "golden": {
            "tier": "GOLD",
            "damage": 6
        },
        "diamond":{
            "tier": "DIAMOND",
            "damage": 6
        },
        "netherite": {
          "tier": "NETHERITE",
          "damage": 7,
          "fire_resistant": true
        }
      },
      "rapier": {
        "wooden": {
          "tier": "WOOD",
          "damage": 4
        },
        "stone": {
          "tier": "STONE",
          "damage": 4
        },
        "iron": {
          "tier": "IRON",
          "damage": 5
        },
        "golden": {
            "tier": "GOLD",
            "damage": 6
        },
        "diamond":{
            "tier": "DIAMOND",
            "damage": 6
        },
        "netherite": {
          "tier": "NETHERITE",
          "damage": 7,
          "fire_resistant": true
        }
      },
      "katana": {
        "wooden": {
          "tier": "WOOD",
          "damage": 4
        },
        "stone": {
          "tier": "STONE",
          "damage": 4
        },
        "iron": {
          "tier": "IRON",
          "damage": 5
        },
        "golden": {
            "tier": "GOLD",
            "damage": 6
        },
        "diamond":{
            "tier": "DIAMOND",
            "damage": 6
        },
        "netherite": {
          "tier": "NETHERITE",
          "damage": 7,
          "fire_resistant": true
        }
      }
  
}""";

    public static Map CONFIG = new TreeMap<>();

    public static double getVersion() {
        String text = DEFAULT_CONFIG;
        int start = 0;

        while (!List.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.').contains(text.charAt(start))) {
            start++;
        }
        int end = start + 1;
        while (List.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.').contains(text.charAt(end))) {
            end++;
        }

        return Double.parseDouble(text.substring(start, end));
    }

    public static class WeaponInfo {
        public WeaponInfo(Map<String, ?> dict, String weapon_type) {
            this(
                    dict.containsKey("tier") ? (String) dict.get("tier") : "WOOD",
                    dict.containsKey("damage") ?  (int) Math.round((double) dict.get("damage")) : 2,
                    dict.containsKey("speed") ? Double.valueOf((double) dict.get("speed")).floatValue(): 0f,
                    dict.containsKey("durability") ? (int) Math.round((double) dict.get("durability")) : -1,
                    dict.containsKey("fire_resistant") && (boolean) dict.get("fire_resistant"),
                    dict.containsKey("dependency") ? String.valueOf(dict.get("dependency")) : "minecraft",
                    weapon_type
            );
        }

        public WeaponInfo(String tier, int dmg, float speed, int dura, boolean fire_res, String dependency,
                          String weapon_type) {
            try {
                this.tier = Tiers.valueOf(tier);
            }
            catch (IllegalArgumentException e) {
                this.tier = Tiers.WOOD;
            }
            this.damage = dmg;//Minus the fist damage itself.
            this.speed = (speed == 0f) ?
                    WEAPON_SPEEDS.get(weapon_type) : calcWeaponSpeed(speed);
            this.durability = (dura == -1) ?
                    this.tier.getUses() : dura;
            this.fireRes = fire_res;
            this.dependency = dependency;

            this.weapon_type = weapon_type;
        }

        public Tier tier;
        public int damage;
        public int durability;
        public float speed;
        public boolean fireRes;
        public String dependency;

        public String weapon_type;

        @Override
        public String toString() {
            return "WeaponInfo<" + weapon_type + ">{" +
                    "tier=" + tier +
                    ", damage=" + damage +
                    ", durability=" + durability +
                    ", speed=" + speed +
                    ", fireRes=" + fireRes +
                    ", dependency='" + dependency + '\'' +
                    '}';
        }
        public float calcWeaponSpeed(float desiredValue){
            return -(DEFAULT_ATTACK_SPEED - desiredValue);
        }
    }


    public static void register() {
        register(false);
    }
    private static void oldConfigRead(String path, boolean force){
        // Create config file if it doesn't exist already
        File config = new File(path);
        boolean create = !config.isFile();

        if (create || force) {
            try {
                config.delete();
                config.createNewFile();

                FileWriter writer = new FileWriter(path);
                writer.write(DEFAULT_CONFIG);
                writer.close();

                MoonsWeaponry.getLogger().info("Moons' Weaponry Config file created");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }


        String configContent = DEFAULT_CONFIG;
        try {
            configContent = FileUtils.readFileToString(config, StandardCharsets.UTF_8);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        CONFIG = new Gson().fromJson(configContent, Map.class);

        if (!force && (RELOAD.get() || VERSION.get() < getVersion())) {
            register(true);
            return;
        }

        WEAPONS = new HashMap<>();
        for (String target : new String[]{CommonConstants.HALBERD_BASE_ID, CommonConstants.WARGLAIVE_BASE_ID, CommonConstants.SCYTHE_BASE_ID, CommonConstants.GREATSWORD_BASE_ID, CommonConstants.HAMMER_BASE_ID}){//, RAPIER_BASE_ID, KATANA_BASE_ID}) {
            for (String id : ((Map<String, Map>) CONFIG.get(target)).keySet()) {
                WEAPONS.put(id + "_" + target, new WeaponInfo(((Map<String, Map>) CONFIG.get(target)).get(id), target));
            }
        }
    }

    private static void registerConfigObjFromDeprecatedConfig(ObjectAdaptersConfigsFactory adapterConfigFactory, ConfigObjectFactory configObjFactory, WeaponTypesEnum weaponType, Tiers tier) throws Exception {
        var weaponKey = ConfigHelper.getWeaponId(weaponType, tier);
        var objData = WEAPONS.get(weaponKey);

        var adapterConfig = adapterConfigFactory.createObjectAdapterConfig(weaponType, tier);
        var configObj = configObjFactory.createObjectConfig(weaponType, tier, objData);

        ItemFigApi.registerObject(configObj, adapterConfig);
    }
    private static void registerConfigObj(ObjectAdaptersConfigsFactory adapterConfigFactory, ConfigObjectFactory configObjFactory, WeaponTypesEnum weaponType, Tiers tier) throws Exception {
        var adapterConfig = adapterConfigFactory.createObjectAdapterConfig(weaponType, tier);
        var configObj = configObjFactory.createObjectConfig(weaponType, tier);

        ItemFigApi.registerObject(configObj, adapterConfig);
    }
    /**
     * Registers config objects and their adapters for config read and write.
     * @param readValuesFromOldConfig Set to TRUE if a deprecated config values that have been
     *                                read shall be used during initialization. This will effectively
     *                                convert pre-itemfig config to itemfig compatible one. Set to FALSE just
     *                                to register config objects, without any config upgrading.
     * */
    private static void registerItemsConfigs(boolean readValuesFromOldConfig){
        var adapterConfigFactory = new ObjectAdaptersConfigsFactory();
        var configObjFactory = new ConfigObjectFactory();
        var logger = MoonsWeaponry.getLogger();
        for(var weaponType : WeaponTypesEnum.values()){
            for(var tier : Tiers.values()){
                try{
                    if(readValuesFromOldConfig){
                        registerConfigObjFromDeprecatedConfig(adapterConfigFactory, configObjFactory, weaponType, tier);
                    }
                    else{
                        registerConfigObj(adapterConfigFactory, configObjFactory, weaponType, tier);
                    }
                }
                catch(Exception ex){
                    logger.warn(ex.getMessage());
                }
            }
        }
    }
    private static Map<WeaponTypesEnum, Map<Tiers, WeaponConfigObj>> getAllElements(){
        var weaponTypes = WeaponTypesEnum.values();
        var tiers = Tiers.values();

        //Linked hash maps preserve order
        var result = new LinkedHashMap<WeaponTypesEnum, Map<Tiers, WeaponConfigObj>>();

        for(var weaponType : weaponTypes){
            var weaponConfigsByTier = new LinkedHashMap<Tiers, WeaponConfigObj>();
            for(var tier : tiers){
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
    public static void register(boolean force) {
        ItemFigApi.setConfigFileName(MoonsWeaponry.MOD_ID + CONFIG_FILE_NAME_SUFFIX);
        String oldConfigPath = System.getProperty("user.dir") + File.separator +
                "config" + File.separator + MoonsWeaponry.MOD_ID + "-common.json";

        var newConfigPath = ItemFigApi.getConfigPath() + ItemFigApi.getConfigFileName();

        var oldConfigFileExists = new File(oldConfigPath).exists();
        var newConfigFileExists = new File(newConfigPath).exists();


        if(oldConfigFileExists && !newConfigFileExists){
            //We got some old config present but new one is not.
            //Make sure to read the old config and recreate it as new version.
            oldConfigRead(oldConfigPath, force);
            registerItemsConfigs(true);

        }else{
            registerItemsConfigs(false);
        }

        ItemFigApi.readConfig();

        WEAPON_CONFIGS = getAllElements();

        //TODO: call readConfig on itemfig
        //TODO: add read values to dict of dicts. First level weapontype, second tier
        //TODO: upon creating items, go first by weapon type and then iterate through Tiers.getValues()
        //TODO: to retrieve proper tiers in proper order.

        //TODO: write down task about moving the factory for qadapter configs and config objects
        //TODO: to itemfig. Check if it would be possible to register types themselves
        //TODO: and then just construct from them. What with itemId in such case tho?

//        // Create config file if it doesn't exist already
//        File config = new File(path);
//        boolean create = !config.isFile();
//
//        if (create || force) {
//            try {
//                config.delete();
//                config.createNewFile();
//
//                FileWriter writer = new FileWriter(path);
//                writer.write(DEFAULT_CONFIG);
//                writer.close();
//
//                MoonsWeaponry.getLogger().info("Moons' Weaponry Config file created");
//            }
//            catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//
//        String configContent = DEFAULT_CONFIG;
//        try {
//            configContent = FileUtils.readFileToString(config, StandardCharsets.UTF_8);
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
//        CONFIG = new Gson().fromJson(configContent, Map.class);
//
//        if (!force && (RELOAD.get() || VERSION.get() < getVersion())) {
//            register(true);
//            return;
//        }
//
//        WEAPONS = new HashMap<>();
//        for (String target : new String[]{HALBERD_BASE_ID, WARGLAIVE_BASE_ID, SCYTHE_BASE_ID, GREATSWORD_BASE_ID, HAMMER_BASE_ID}){//, RAPIER_BASE_ID, KATANA_BASE_ID}) {
//            for (String id : ((Map<String, Map>) CONFIG.get(target)).keySet()) {
//                WEAPONS.put(id + "_" + target, new WeaponInfo(((Map<String, Map>) CONFIG.get(target)).get(id), target));
//            }
//        }
    }
}
