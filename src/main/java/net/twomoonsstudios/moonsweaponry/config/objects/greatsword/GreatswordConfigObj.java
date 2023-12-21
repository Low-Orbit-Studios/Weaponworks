package net.twomoonsstudios.moonsweaponry.config.objects.greatsword;

import io.github.hornster.itemfig.api.serialization.config.ConfigObj;
import net.minecraft.util.Tuple;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.material.Material;
import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.WeaponConfigObj;
import org.apache.commons.lang3.tuple.Triple;

import java.lang.reflect.Type;
import java.util.Locale;

import static net.twomoonsstudios.moonsweaponry.constants.WeaponDataConstants.GREATSWORD_DEFAULT_ATK_SPD;

public abstract class GreatswordConfigObj extends WeaponConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public GreatswordConfigObj(Type myType, String myID) {
        super(myType, myID);
    }

    public GreatswordConfigObj(Type myType, String myID, MoonsWeaponsConfig.WeaponInfo configData) {
        super(myType, myID, configData);
    }

    @Override
    public Float getDefaultAttackSpeed(){
        return GREATSWORD_DEFAULT_ATK_SPD;
    }

    @Override
    protected Boolean getDefaultFireResistance() {
        return false;
    }

}
