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
import java.util.HashMap;
import java.util.Map;

public class MoonsWeaponsConfig {
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


    public static void read() {
        String path = Minecraft.getInstance().gameDirectory.getAbsolutePath();
        while (path.length() > 0 && !path.endsWith("\\"))
            path = path.substring(0, path.length() - 1);
        path += "config\\" + MoonsWeaponry.MOD_ID + "-weapons.json";

        // Create config file if it doesn't exist already
        File config = new File(path);
        boolean create = !config.isFile();

        if (create) {
            try {
                config.createNewFile();

                FileWriter writer = new FileWriter(path);
                writer.write(DEFAULT_CONFIG);
                writer.close();

                MoonsWeaponry.getLogger().info("Moons' Weapons Config file created");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }


        Gson gson = new Gson();
        String configContent = DEFAULT_CONFIG;
        try {
            configContent = FileUtils.readFileToString(config, StandardCharsets.UTF_8);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, Map<String, Map<String, ?>>> json = gson.fromJson(configContent, Map.class);


        WEAPONS = new HashMap<>();
        for (String target : new String[]{"halberd", "warglaive", "scythe", "greatsword", "hammer"}) {
            for (String id : json.get(target).keySet()) {
                WEAPONS.put(id + "_" + target, new WeaponInfo(json.get(target).get(id), target));
            }
        }

        /*String target = "halberd";
        HALBERDS = new HashMap<>();
        for (String id : json.get(target).keySet()) {
            HALBERDS.put(id + "_" + target, new WeaponInfo(json.get(target).get(id)));
        }
        target = "warglaive";
        WARGLAIVES = new HashMap<>();
        for (String id : json.get(target).keySet()) {
            WARGLAIVES.put(id + "_" + target, new WeaponInfo(json.get(target).get(id)));
        }
        target = "scythe";
        SCYTHES = new HashMap<>();
        for (String id : json.get(target).keySet()) {
            SCYTHES.put(id + "_" + target, new WeaponInfo(json.get(target).get(id)));
        }
        target = "greatsword";
        GREATSWORDS = new HashMap<>();
        for (String id : json.get(target).keySet()) {
            GREATSWORDS.put(id + "_" + target, new WeaponInfo(json.get(target).get(id)));
        }
        target = "hammer";
        HAMMERS = new HashMap<>();
        for (String id : json.get(target).keySet()) {
            HAMMERS.put(id + "_" + target, new WeaponInfo(json.get(target).get(id)));
        }*/
    }
}
