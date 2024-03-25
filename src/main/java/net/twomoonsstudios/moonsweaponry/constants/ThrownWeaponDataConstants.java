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
    public static final int THROWING_KNIFE_DEFAULT_CD = 10;
    public static final float THROWING_KNIFE_DEFAULT_INACCURACY = 0.1f;
    public static final float THROWING_KNIFE_DEFAULT_VELOCITY = 1.6f;
    public static final int THROWING_KNIFE_DEFAULT_USES = 16;

    public static final String WOODEN_THROWING_KNIFE_DEFAULT_TIER_NAME = "WOOD";
    public static final int WOODEN_THROWING_KNIFE_DEFAULT_DMG = 5;
    public static final int WOODEN_THROWING_KNIFE_DEFAULT_USES = 16;

    public static final String STONE_THROWING_KNIFE_DEFAULT_TIER_NAME = "STONE";
    public static final int STONE_THROWING_KNIFE_DEFAULT_DMG = 6;

    public static final String IRON_THROWING_KNIFE_DEFAULT_TIER_NAME = "IRON";
    public static final int IRON_THROWING_KNIFE_DEFAULT_DMG = 7;
    //TODO add rest when the time comes
}
