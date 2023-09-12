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

public class MoonsWeaponsConfig {
    public static final ConfigEntry<Double> VERSION = new ConfigEntry<>("TECHNICAL.VERSION_DO_NOT_EDIT", 0d);
    public static final ConfigEntry<Boolean> RELOAD = new ConfigEntry<>("TECHNICAL.FORCE_RESET", false);

    public static Map<String, WeaponInfo> WEAPONS = new HashMap<>();

    public static final Map<String, Float> WEAPON_SPEEDS = Map.of(
            "halberd", -3.9f,
            "warglaive", -2f,
            "scythe", -3.8f,
            "greatsword", -3.4f,
            "hammer", -3f
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
      "damage": 3
    }
  },
  "warglaive": {
    "stone": {
      "tier": "STONE",
      "damage": 3
    }
  },
  "scythe": {
    "golden": {
      "tier": "GOLD",
      "damage": 3
    },
    "iron": {
      "tier": "IRON",
      "damage": 3
    }
  },
  "greatsword": {
    "diamond": {
      "tier": "DIAMOND",
      "damage": 3
    }
  },
  "hammer": {
    "netherite": {
      "tier": "NETHERITE",
      "damage": 3,
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
            this.damage = dmg;
            this.speed = (speed == 0f) ?
                    WEAPON_SPEEDS.get(weapon_type) : speed;
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
        for (String target : new String[]{"halberd", "warglaive", "scythe", "greatsword", "hammer"}) {
            for (String id : ((Map<String, Map>) CONFIG.get(target)).keySet()) {
                WEAPONS.put(id + "_" + target, new WeaponInfo(((Map<String, Map>) CONFIG.get(target)).get(id), target));
            }
        }
    }
}
