package net.twomoonsstudios.moonsweaponry.config;

import com.google.gson.Gson;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.twomoonsstudios.moonsweaponry.MoonsWeaponry;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

import static net.twomoonsstudios.moonsweaponry.constants.WeaponDataConstants.*;

public class MoonsWeaponsConfig {
    /**Base ID for the halberd. For editor support and typo reduction.*/
    public static final String HALBERD_BASE_ID = "halberd";
    /**Base ID for the warglaive. For editor support and typo reduction.*/
    public static final String WARGLAIVE_BASE_ID = "warglaive";
    /**Base ID for the scythe. For editor support and typo reduction.*/
    public static final String SCYTHE_BASE_ID = "scythe";
    /**Base ID for the greatsword. For editor support and typo reduction.*/
    public static final String GREATSWORD_BASE_ID = "greatsword";
    /**Base ID for the hammer. For editor support and typo reduction.*/
    public static final String HAMMER_BASE_ID = "hammer";

    public static final ConfigEntry<Double> VERSION = new ConfigEntry<>("TECHNICAL.VERSION_DO_NOT_EDIT", 0d);
    public static final ConfigEntry<Boolean> RELOAD = new ConfigEntry<>("TECHNICAL.FORCE_RESET", false);

    public static Map<String, WeaponInfo> WEAPONS = new HashMap<>();

    public static final Map<String, Float> WEAPON_SPEEDS = Map.of(
            HALBERD_BASE_ID, HALBERD_BASE_ATK_SPD,
            WARGLAIVE_BASE_ID, WARGLAIVE_BASE_ATK_SPD,
            SCYTHE_BASE_ID, SCYTHE_BASE_ATK_SPD,
            GREATSWORD_BASE_ID, GREATSWORD_BASE_ATK_SPD,
            HAMMER_BASE_ID, HAMMER_BASE_ATK_SPD
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

    public static void register(boolean force) {
        String path = System.getProperty("user.dir") + File.separator +
                "config" + File.separator + MoonsWeaponry.MOD_ID + "-common.json";

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
        for (String target : new String[]{HALBERD_BASE_ID, WARGLAIVE_BASE_ID, SCYTHE_BASE_ID, GREATSWORD_BASE_ID, HAMMER_BASE_ID}) {
            for (String id : ((Map<String, Map>) CONFIG.get(target)).keySet()) {
                WEAPONS.put(id + "_" + target, new WeaponInfo(((Map<String, Map>) CONFIG.get(target)).get(id), target));
            }
        }
    }
}
