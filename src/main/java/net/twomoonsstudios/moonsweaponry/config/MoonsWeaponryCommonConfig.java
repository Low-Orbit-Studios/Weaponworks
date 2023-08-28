package net.twomoonsstudios.moonsweaponry.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.twomoonsstudios.moonsweaponry.constants.WeaponDataConstants;

public class MoonsWeaponryCommonConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;


    public static final ForgeConfigSpec.ConfigValue<Integer> IRON_GREATSWORD_BASE_DMG;
    public static final ForgeConfigSpec.ConfigValue<Integer> GOLD_GREATSWORD_BASE_DMG;
    public static final ForgeConfigSpec.ConfigValue<Integer> DIAMOND_GREATSWORD_BASE_DMG;
    public static final ForgeConfigSpec.ConfigValue<Integer> NETHERITE_GREATSWORD_BASE_DMG;

    public static final ForgeConfigSpec.ConfigValue<Double> GREATSWORD_BASE_ATK_SPD;


    public static final ForgeConfigSpec.ConfigValue<Integer> IRON_HAMMER_BASE_DMG;
    public static final ForgeConfigSpec.ConfigValue<Integer> GOLD_HAMMER_BASE_DMG;
    public static final ForgeConfigSpec.ConfigValue<Integer> DIAMOND_HAMMER_BASE_DMG;
    public static final ForgeConfigSpec.ConfigValue<Integer> NETHERITE_HAMMER_BASE_DMG;

    public static final ForgeConfigSpec.ConfigValue<Double> HAMMER_BASE_ATK_SPD;


    public static final ForgeConfigSpec.ConfigValue<Integer> IRON_SCYTHE_BASE_DMG;
    public static final ForgeConfigSpec.ConfigValue<Integer> GOLD_SCYTHE_BASE_DMG;
    public static final ForgeConfigSpec.ConfigValue<Integer> DIAMOND_SCYTHE_BASE_DMG;
    public static final ForgeConfigSpec.ConfigValue<Integer> NETHERITE_SCYTHE_BASE_DMG;

    public static final ForgeConfigSpec.ConfigValue<Double> SCYTHE_BASE_ATK_SPD;


    public static final ForgeConfigSpec.ConfigValue<Integer> IRON_WARGLAIVE_BASE_DMG;
    public static final ForgeConfigSpec.ConfigValue<Integer> GOLD_WARGLAIVE_BASE_DMG;
    public static final ForgeConfigSpec.ConfigValue<Integer> DIAMOND_WARGLAIVE_BASE_DMG;
    public static final ForgeConfigSpec.ConfigValue<Integer> NETHERITE_WARGLAIVE_BASE_DMG;

    public static final ForgeConfigSpec.ConfigValue<Double> WARGLAIVE_BASE_ATK_SPD;


    public static final ForgeConfigSpec.ConfigValue<Integer> IRON_HALBERD_BASE_DMG;
    public static final ForgeConfigSpec.ConfigValue<Integer> GOLD_HALBERD_BASE_DMG;
    public static final ForgeConfigSpec.ConfigValue<Integer> DIAMOND_HALBERD_BASE_DMG;
    public static final ForgeConfigSpec.ConfigValue<Integer> NETHERITE_HALBERD_BASE_DMG;

    public static final ForgeConfigSpec.ConfigValue<Double> HALBERD_BASE_ATK_SPD;

    static{
        BUILDER.push("Configs for Moons Weaponry Mod");
        BUILDER.comment("Damage values should be given as base item values.");

        BUILDER.push("Greatswords");
        IRON_GREATSWORD_BASE_DMG = BUILDER.comment("Base damage for Iron Greatsword")
                .define("iron_greatsword_base_dmg", WeaponDataConstants.IRON_GREATSWORD_BASE_DMG);
        GOLD_GREATSWORD_BASE_DMG = BUILDER.comment("Base damage for Golden Greatsword")
                .define("gold_greatsword_base_dmg", WeaponDataConstants.GOLD_GREATSWORD_BASE_DMG);
        DIAMOND_GREATSWORD_BASE_DMG = BUILDER.comment("Base damage for Diamond Greatsword")
                .define("diamond_greatsword_base_dmg", WeaponDataConstants.DIAMOND_GREATSWORD_BASE_DMG);
        NETHERITE_GREATSWORD_BASE_DMG = BUILDER.comment("Base damage for Netherite Greatsword")
                .define("netherite_greatsword_base_dmg", WeaponDataConstants.NETHERITE_GREATSWORD_BASE_DMG);

        GREATSWORD_BASE_ATK_SPD = BUILDER.comment("Base attack speed for Greatswords")
                .defineInRange("greatsword_base_atk_spd", WeaponDataConstants.GREATSWORD_BASE_ATK_SPD, -4f, 0f);
        BUILDER.pop();

        BUILDER.push("Hammers");
        IRON_HAMMER_BASE_DMG = BUILDER.comment("Base damage for Iron Hammer")
                .define("iron_hammer_base_dmg", WeaponDataConstants.IRON_HAMMER_BASE_DMG);
        GOLD_HAMMER_BASE_DMG = BUILDER.comment("Base damage for Golden Hammer")
                .define("gold_hammer_base_dmg", WeaponDataConstants.GOLD_HAMMER_BASE_DMG);
        DIAMOND_HAMMER_BASE_DMG = BUILDER.comment("Base damage for Diamond Hammer")
                .define("diamond_hammer_base_dmg", WeaponDataConstants.DIAMOND_HAMMER_BASE_DMG);
        NETHERITE_HAMMER_BASE_DMG = BUILDER.comment("Base damage for Netherite Hammer")
                .define("netherite_hammer_base_dmg", WeaponDataConstants.NETHERITE_HAMMER_BASE_DMG);

        HAMMER_BASE_ATK_SPD = BUILDER.comment("Base attack speed for Hammers")
                .defineInRange("hammer_base_atk_spd", WeaponDataConstants.HAMMER_BASE_ATK_SPD, -4f, 0f);
        BUILDER.pop();

        BUILDER.push("Scythes");
        IRON_SCYTHE_BASE_DMG = BUILDER.comment("Base damage for Iron Scythe")
                .define("iron_scythe_base_dmg", WeaponDataConstants.IRON_SCYTHE_BASE_DMG);
        GOLD_SCYTHE_BASE_DMG = BUILDER.comment("Base damage for Golden Scythe")
                .define("gold_scythe_base_dmg", WeaponDataConstants.GOLD_SCYTHE_BASE_DMG);
        DIAMOND_SCYTHE_BASE_DMG = BUILDER.comment("Base damage for Diamond Scythe")
                .define("diamond_scythe_base_dmg", WeaponDataConstants.DIAMOND_SCYTHE_BASE_DMG);
        NETHERITE_SCYTHE_BASE_DMG = BUILDER.comment("Base damage for Netherite Scythe")
                .define("netherite_scythe_base_dmg", WeaponDataConstants.NETHERITE_SCYTHE_BASE_DMG);

        SCYTHE_BASE_ATK_SPD = BUILDER.comment("Base attack speed for Scythes")
                .defineInRange("scythe_base_atk_spd", WeaponDataConstants.SCYTHE_BASE_ATK_SPD, -4f, 0f);
        BUILDER.pop();

        BUILDER.push("Warglaives");
        IRON_WARGLAIVE_BASE_DMG = BUILDER.comment("Base damage for Iron Warglaive")
                .define("iron_warglaive_base_dmg", WeaponDataConstants.IRON_WARGLAIVE_BASE_DMG);
        GOLD_WARGLAIVE_BASE_DMG = BUILDER.comment("Base damage for Golden Warglaive")
                .define("gold_warglaive_base_dmg", WeaponDataConstants.GOLD_WARGLAIVE_BASE_DMG);
        DIAMOND_WARGLAIVE_BASE_DMG = BUILDER.comment("Base damage for Diamond Warglaive")
                .define("diamond_warglaive_base_dmg", WeaponDataConstants.DIAMOND_WARGLAIVE_BASE_DMG);
        NETHERITE_WARGLAIVE_BASE_DMG = BUILDER.comment("Base damage for Netherite Warglaive")
                .define("netherite_warglaive_base_dmg", WeaponDataConstants.NETHERITE_WARGLAIVE_BASE_DMG);

        WARGLAIVE_BASE_ATK_SPD = BUILDER.comment("Base attack speed for Warglaives")
                .defineInRange("warglaive_base_atk_spd", WeaponDataConstants.WARGLAIVE_BASE_ATK_SPD, -4f, 0f);
        BUILDER.pop();

        BUILDER.push("Halberds");
        IRON_HALBERD_BASE_DMG = BUILDER.comment("Base damage for Iron Halberd")
                .define("iron_halberd_base_dmg", WeaponDataConstants.IRON_HALBERD_BASE_DMG);
        GOLD_HALBERD_BASE_DMG = BUILDER.comment("Base damage for Golden Halberd")
                .define("gold_halberd_base_dmg", WeaponDataConstants.GOLD_HALBERD_BASE_DMG);
        DIAMOND_HALBERD_BASE_DMG = BUILDER.comment("Base damage for Diamond Halberd")
                .define("diamond_halberd_base_dmg", WeaponDataConstants.DIAMOND_HALBERD_BASE_DMG);
        NETHERITE_HALBERD_BASE_DMG = BUILDER.comment("Base damage for Netherite Halberd")
                .define("netherite_halberd_base_dmg", WeaponDataConstants.NETHERITE_HALBERD_BASE_DMG);

        HALBERD_BASE_ATK_SPD = BUILDER.comment("Base attack speed for Halberds")
                .defineInRange("halberd_base_atk_spd", WeaponDataConstants.HALBERD_BASE_ATK_SPD, -4f, 0f);
        BUILDER.pop();
        //HERE DEFINE CONFIGS

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
