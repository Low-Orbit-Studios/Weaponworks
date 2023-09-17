package net.twomoonsstudios.moonsweaponry.constants;

public class WeaponDataConstants {
    //Base attack speed in MC is 4. By subtracting the desired speed
    //from it and then assigning the result with sign changed to negative,
    //we receive the desired speed in the game.
    public static final float DEFAULT_ATTACK_SPEED = 4f;
    public static final float GREATSWORD_BASE_ATK_SPD = -(DEFAULT_ATTACK_SPEED - 0.8f);

    public static final float HAMMER_BASE_ATK_SPD = -(DEFAULT_ATTACK_SPEED - 1f);

    public static final float SCYTHE_BASE_ATK_SPD = -(DEFAULT_ATTACK_SPEED - 1.2f);

    public static final float WARGLAIVE_BASE_ATK_SPD = -(DEFAULT_ATTACK_SPEED - 2.1f);

    public static final float HALBERD_BASE_ATK_SPD = -(DEFAULT_ATTACK_SPEED - 1.6f);
}
