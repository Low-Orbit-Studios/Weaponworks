package net.twomoonsstudios.moonsweaponry.config.objects;

import java.lang.reflect.Type;

import static net.twomoonsstudios.moonsweaponry.constants.MeleeWeaponDataConstants.DEFAULT_ATTACK_SPEED;
import static net.twomoonsstudios.moonsweaponry.constants.MeleeWeaponDataConstants.WOODEN_GREATSWORD_DEFAULT_TIER_NAME;

/**Template items aren't saved and are not supposed to be used.
 * Their purpose is to be allowing player to select what weapon they are about to make.*/
public class TemplateConfigObj extends WeaponConfigObj{
    public TemplateConfigObj(String myID) {
        super(TemplateConfigObj.class, myID);
        chkDefaultValues();
    }

    @Override
    protected String getDefaultTier() {
        return WOODEN_GREATSWORD_DEFAULT_TIER_NAME;
    }

    @Override
    protected Integer getDefaultDamage() {
        return -1;//No damage whatsoever
    }

    @Override
    protected Float getDefaultAttackSpeed() {
        return DEFAULT_ATTACK_SPEED - (DEFAULT_ATTACK_SPEED-0.1f);//Veeery slow
    }

    @Override
    protected Boolean getDefaultFireResistance() {
        return true;
    }

    @Override
    protected Integer getDefaultDurability() {
        return 1;//Not usable.
    }
}
