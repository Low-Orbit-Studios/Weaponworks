package net.twomoonsstudios.moonsweaponry.constants;

public class ThrownWeaponDataConstants{
    //Notes:
    //For thrown items, USES is equal to DURABILITY
    //CD - cooldown, in ticks, between throws.
    /**How long are the shot projectiles considered of fire for, in seconds.
     * As long as projectile is on fire, it will light entities that it hits on fire.*/
    public static final int THROWABLES_FLAME_ENCHANT_SECONDS = 100;
    /**How long will struck entity be set on fire for, in seconds.*/
    public static final int THROWABLES_FLAME_ENCHANT_ENTITY_SECONDS = 5;
    //Throwing knives

    /**If the speed is greater or equal to this value, the weapon will deal max damage on impact.
     * Below it the damage will be properly scaled down. Range [0, 1]. Treat as % of max velocity.*/
    public static final float THROWABLE_MAX_DMG_VELOCITY_THRESHOLD = 0.8f;
    /**If the speed is lower or equal to this value, the weapon will deal minimum damage on impact.
     * {@link ThrownWeaponDataConstants#THROWABLE_MIN_DMG_COEF}. Treat as % of max velocity.*/
    public static final float THROWABLE_MIN_DMG_VELOCITY_THRESHOLD = 0.4f;
    /**The minimal damage multiplier a throwable can deal due to low movement speed. Range [0, 1]*/
    public static final float THROWABLE_MIN_DMG_COEF = 0.2f;

    public static final int DAGGER_DEFAULT_CD = 10;
    public static final float DAGGER_DEFAULT_INACCURACY = 0.1f;
    public static final float DAGGER_DEFAULT_VELOCITY = 1.6f;

    public static final String WOODEN_DAGGER_DEFAULT_TIER_NAME = "WOOD";
    public static final int WOODEN_DAGGER_DEFAULT_DMG = 7;
    public static final int WOODEN_DAGGER_DEFAULT_USES = 8;

    public static final String STONE_DAGGER_DEFAULT_TIER_NAME = "STONE";
    public static final int STONE_DAGGER_DEFAULT_DMG = 8;
    public static final int STONE_DAGGER_DEFAULT_USES = 12;

    public static final String IRON_DAGGER_DEFAULT_TIER_NAME = "IRON";
    public static final int IRON_DAGGER_DEFAULT_DMG = 9;
    public static final int IRON_DAGGER_DEFAULT_USES = 16;

    public static final String GOLD_DAGGER_DEFAULT_TIER_NAME = "GOLD";
    public static final int GOLD_DAGGER_DEFAULT_DMG = 10;
    public static final int GOLD_DAGGER_DEFAULT_USES = 8;

    public static final int JAVELIN_DEFAULT_CD = 25;
    public static final float JAVELIN_DEFAULT_INACCURACY = 0.05f;
    public static final float JAVELIN_DEFAULT_VELOCITY = 1.8f;

    public static final String IRON_JAVELIN_DEFAULT_TIER_NAME = "IRON";
    public static final int IRON_JAVELIN_DEFAULT_DMG = 11;
    public static final int IRON_JAVELIN_DEFAULT_USES = 16;
    //TODO add rest when the time comes
}
