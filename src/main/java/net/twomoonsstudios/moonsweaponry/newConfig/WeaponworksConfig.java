package net.twomoonsstudios.moonsweaponry.newConfig;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import net.twomoonsstudios.moonsweaponry.MoonsWeaponry;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

public class WeaponworksConfig {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();

    @Expose
    public LinkedHashSet<String> enabledMaterials = new LinkedHashSet<>(List.of("wood", "stone", "iron", "gold", "diamond", "netherite"));

    @Expose
    public LinkedHashSet<String> enabledMeleeWeapons = new LinkedHashSet<>(List.of("greatsword","halberd", "hammer", "katana","mace","rapier","scythe","spear","warglaive"));

    @Expose
    public LinkedHashSet<String> enabledThrownWeapons = new LinkedHashSet<>(List.of("dagger","hatchet","javelin","shuriken","boomerang"));

    //Default value entry per material.
    @Expose
    public Map<String, Map<String,Object>> materials = Map.ofEntries(
            Map.entry("woodMaterial", Map.ofEntries(
                    Map.entry("tierName","WOOD"),
                    Map.entry("damageModifier",-1.0),
                    Map.entry("defaultDurability",59),
                    Map.entry("thrownUsesMultiplier",0.5),
                    Map.entry("fireResistant",false)
            )),
            Map.entry("stoneMaterial", Map.ofEntries(
                    Map.entry("tierName","STONE"),
                    Map.entry("damageModifier",-1.0),
                    Map.entry("defaultDurability",131),
                    Map.entry("thrownUsesMultiplier",0.75),
                    Map.entry("fireResistant",false)
            )),
            Map.entry("ironMaterial", Map.ofEntries(
                    Map.entry("tierName","IRON"),
                    Map.entry("damageModifier",0.0),
                    Map.entry("defaultDurability",250),
                    Map.entry("thrownUsesMultiplier",1.0),
                    Map.entry("fireResistant",false)
            )),
            Map.entry("goldMaterial",Map.ofEntries(
                    Map.entry("tierName","GOLD"),
                    Map.entry("damageModifier",1.0),
                    Map.entry("defaultDurability",128),
                    Map.entry("thrownUsesMultiplier",0.5),
                    Map.entry("fireResistant",false)
            )),
            Map.entry("diamondMaterial", Map.ofEntries(
                    Map.entry("tierName","DIAMOND"),
                    Map.entry("damageModifier",1.0),
                    Map.entry("defaultDurability",1561),
                    Map.entry("thrownUsesMultiplier",1.5),
                    Map.entry("fireResistant",false)
            )),
            Map.entry("netheriteMaterial", Map.ofEntries(
                    Map.entry("tierName","NETHERITE"),
                    Map.entry("damageModifier",2.0),
                    Map.entry("defaultDurability",2031),
                    Map.entry("thrownUsesMultiplier",1.5),
                    Map.entry("fireResistant",true)
            ))
    );

    @Expose
    public Map<String, Map<String,Object>> meleeTypeConstants = Map.ofEntries(
            Map.entry("greatswordBaseConstants", Map.ofEntries(
                    Map.entry("defaultAttackSpeed", 0.8),
                    Map.entry("defaultDamage", 10)
            )),
            Map.entry("halberdBaseConstants", Map.ofEntries(
                    Map.entry("defaultAttackSpeed", 1.3),
                    Map.entry("defaultDamage", 6)
            )),
            Map.entry("hammerBaseConstants", Map.ofEntries(
                    Map.entry("defaultAttackSpeed", 1.1),
                    Map.entry("defaultDamage", 8)
            )),
            Map.entry("maceBaseConstants", Map.ofEntries(
                    Map.entry("defaultAttackSpeed", 1.2),
                    Map.entry("defaultDamage", 7)
            )),
            Map.entry("rapierBaseConstants", Map.ofEntries(
                    Map.entry("defaultAttackSpeed", 2.0),
                    Map.entry("defaultDamage", 3)
            )),
            Map.entry("scytheBaseConstants", Map.ofEntries(
                    Map.entry("defaultAttackSpeed", 1.2),
                    Map.entry("defaultDamage", 7)
            )),
            Map.entry("katanaBaseConstants", Map.ofEntries(
                    Map.entry("defaultAttackSpeed", 1.8),
                    Map.entry("defaultDamage", 4)
            )),
            Map.entry("spearBaseConstants", Map.ofEntries(
                    Map.entry("defaultAttackSpeed", 1.7),
                    Map.entry("defaultDamage", 4)
            )),
            Map.entry("warglaiveBaseConstants", Map.ofEntries(
                    Map.entry("defaultAttackSpeed", 2.1),
                    Map.entry("defaultDamage", 3)
            ))
    );

    @Expose
    public Map<String, Object> throwingWeaponConstants = Map.ofEntries(
            Map.entry("throwableMaxDmgVelocityPercent", 0.8f),
            Map.entry("throwableMinDmgVelocityPercent", 0.4f),
            Map.entry("throwableMinDmgCoefficient", 0.2f),
            Map.entry("boomerangReturnTicks",10.0)
    );

    @Expose
    public Map<String, Map<String, Object>> thrownTypeConstants = Map.ofEntries(
            Map.entry("daggerBaseConstants", Map.ofEntries(
                    Map.entry("defaultCooldown", 25.0),
                    Map.entry("defaultInaccuracy", 0.05),
                    Map.entry("defaultVelocity", 1.8),
                    Map.entry("defaultDamage", 7.0),
                    Map.entry("defaultUses",20.0)
            )),
            Map.entry("javelinBaseConstants", Map.ofEntries(
                    Map.entry("defaultCooldown",10.0),
                    Map.entry("defaultInaccuracy", 0.1),
                    Map.entry("defaultVelocity", 1.6),
                    Map.entry("defaultDamage", 4.0),
                    Map.entry("defaultUses",24.0)
            )),
            Map.entry("hatchetBaseConstants", Map.ofEntries(
                    Map.entry("defaultCooldown",30.0),
                    Map.entry("defaultInaccuracy", 0.02),
                    Map.entry("defaultVelocity", 1.0),
                    Map.entry("defaultDamage", 8.0),
                    Map.entry("defaultUses",16.0)
            )),
            Map.entry("boomerangBaseConstants", Map.ofEntries(
                    Map.entry("defaultCooldown",10.0),
                    Map.entry("defaultInaccuracy", 0.03),
                    Map.entry("defaultVelocity", 1.5),
                    Map.entry("defaultDamage", 6.0),
                    Map.entry("defaultUses",1.0)
            )),
            Map.entry("shurikenBaseConstants", Map.ofEntries(
                    Map.entry("defaultCooldown",15),
                    Map.entry("defaultInaccuracy", 0.15),
                    Map.entry("defaultVelocity", 1.5),
                    Map.entry("defaultDamage", 4),
                    Map.entry("defaultUses",36)
            ))
    );

    @Expose
    public Map<String, Object> enchantmentConstants = Map.ofEntries(
            Map.entry("flameEnchantProjectileSeconds",100f),
            Map.entry("flameEnchantEntitySeconds",5f),
            Map.entry("velocityEnchantMaxLevel", 3.0),
            Map.entry("velocityEnchantLevelIncrease", 0.1),
            Map.entry("capacityEnchantMaxLevel",2.0),
            Map.entry("capacityEnchantLevelIncrease",  0.25)
    );

    public static WeaponworksConfig load(File configFile) {
        WeaponworksConfig weaponworksConfig = new WeaponworksConfig();
        if (configFile.exists()) {
            try (FileReader reader = new FileReader(configFile)) {
                weaponworksConfig = gson.fromJson(reader, WeaponworksConfig.class);
                MoonsWeaponry.getLogger().debug("Weaponworks config {} loaded successfully.", configFile.getAbsolutePath());
            } catch (Exception e) {
                MoonsWeaponry.getLogger().error("Config finding error at {}", configFile.getAbsolutePath());
                MoonsWeaponry.getLogger().error("{}", e.getMessage());
            }
        }
        else {
            configFile.getParentFile().mkdirs();
            MoonsWeaponry.getLogger().debug("Created new config at {}", configFile.getAbsolutePath());
        }
        try (FileWriter writer = new FileWriter(configFile)) {
            gson.toJson(weaponworksConfig, writer);
            MoonsWeaponry.getLogger().debug("Saved config file.");
        } catch (Exception e) {
            MoonsWeaponry.getLogger().error("Failed to make config at {}", configFile.getAbsolutePath());
            MoonsWeaponry.getLogger().error("{}",e.getMessage());
        }
        return weaponworksConfig;
    }
}
