package net.twomoonsstudios.moonsweaponry.constants;

public class WeaponDataConstants {
    //Base attack speed in MC is 4. By subtracting the desired speed
    //from it and then assigning the result with sign changed to negative,
    //we receive the desired speed in the game.
    public static final float DEFAULT_ATTACK_SPEED = 4f;
    //The base attack strength of the player. All melee weapon dmg is added to it.
    public static final int FIST_ATTACK_POWER = 1;
    //Boosts against gold-class weapon.
    public static final int IRON_TIER_DMG_BOOST = 2;
    public static final int DIAMOND_TIER_DMG_BOOST = 3;
    public static final int NETHERITE_TIER_DMG_BOOST = 4;

    public static final int IRON_GREATSWORD_BASE_DMG = 9 - IRON_TIER_DMG_BOOST - FIST_ATTACK_POWER;
    public static final int GOLD_GREATSWORD_BASE_DMG = 10 - FIST_ATTACK_POWER;
    public static final int DIAMOND_GREATSWORD_BASE_DMG = 11 - DIAMOND_TIER_DMG_BOOST - FIST_ATTACK_POWER;
    public static final int NETHERITE_GREATSWORD_BASE_DMG = 12 - NETHERITE_TIER_DMG_BOOST - FIST_ATTACK_POWER;

    public static final float GREATSWORD_BASE_ATK_SPD = -(DEFAULT_ATTACK_SPEED - 0.8f);


    public static final int IRON_HAMMER_BASE_DMG = 7 - IRON_TIER_DMG_BOOST - FIST_ATTACK_POWER;
    public static final int GOLD_HAMMER_BASE_DMG = 8 - FIST_ATTACK_POWER;
    public static final int DIAMOND_HAMMER_BASE_DMG = 9 - DIAMOND_TIER_DMG_BOOST - FIST_ATTACK_POWER;
    public static final int NETHERITE_HAMMER_BASE_DMG = 10- NETHERITE_TIER_DMG_BOOST - FIST_ATTACK_POWER;

    public static final float HAMMER_BASE_ATK_SPD = -(DEFAULT_ATTACK_SPEED - 1f);


    public static final int IRON_SCYTHE_BASE_DMG = 5 - IRON_TIER_DMG_BOOST - FIST_ATTACK_POWER;
    public static final int GOLD_SCYTHE_BASE_DMG = 6 - FIST_ATTACK_POWER;
    public static final int DIAMOND_SCYTHE_BASE_DMG = 7 - DIAMOND_TIER_DMG_BOOST - FIST_ATTACK_POWER;
    public static final int NETHERITE_SCYTHE_BASE_DMG = 8 - NETHERITE_TIER_DMG_BOOST - FIST_ATTACK_POWER;

    public static final float SCYTHE_BASE_ATK_SPD = -(DEFAULT_ATTACK_SPEED - 1.2f);


    public static final int IRON_WARGLAIVE_BASE_DMG = 1 - IRON_TIER_DMG_BOOST - FIST_ATTACK_POWER;
    public static final int GOLD_WARGLAIVE_BASE_DMG = 2 - FIST_ATTACK_POWER;
    public static final int DIAMOND_WARGLAIVE_BASE_DMG = 3 - DIAMOND_TIER_DMG_BOOST - FIST_ATTACK_POWER;
    public static final int NETHERITE_WARGLAIVE_BASE_DMG = 4 - NETHERITE_TIER_DMG_BOOST - FIST_ATTACK_POWER;

    public static final float WARGLAIVE_BASE_ATK_SPD = -(DEFAULT_ATTACK_SPEED - 2.1f);


    public static final int IRON_HALBERD_BASE_DMG = 5 - IRON_TIER_DMG_BOOST - FIST_ATTACK_POWER;
    public static final int GOLD_HALBERD_BASE_DMG = 6 - FIST_ATTACK_POWER;
    public static final int DIAMOND_HALBERD_BASE_DMG = 7 - DIAMOND_TIER_DMG_BOOST - FIST_ATTACK_POWER;
    public static final int NETHERITE_HALBERD_BASE_DMG = 8 - NETHERITE_TIER_DMG_BOOST - FIST_ATTACK_POWER;

    public static final float HALBERD_BASE_ATK_SPD = -(DEFAULT_ATTACK_SPEED - 1.6f);
}
