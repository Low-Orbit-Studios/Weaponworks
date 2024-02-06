package net.crazedaerialcable.weaponworks.config.objects;

import io.github.hornster.itemfig.api.serialization.config.ConfigObj;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.crazedaerialcable.weaponworks.config.WeaponworksConfig;

import java.lang.reflect.Type;

import static net.crazedaerialcable.weaponworks.constants.WeaponDataConstants.DEFAULT_ATTACK_SPEED;

public abstract class WeaponConfigObj extends ConfigObj {
    public String tier;
    public Integer damage;
    /**Attack speed*/
    public Float speed;
    public Boolean fire_resistant;
    public Integer durability;
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public WeaponConfigObj(Type myType, String myID) {
        super(myType, myID);
    }

    @Override
    public void chkDefaultValues() {
        if(tier == null || tier.equals("")){
            tier = getDefaultTier();
        }
        if(damage == null){
            damage = getDefaultDamage();
        }
        if(speed == null){
            speed = getDefaultAttackSpeed();
        }
        if(fire_resistant == null){
            fire_resistant = getDefaultFireResistance();
        }
        if(durability == null){
            durability = getDefaultDurability();
        }
    }

    public ToolMaterial getTier(){
        return ToolMaterials.valueOf(tier);
    }
    /**
     * Returns the attack speed in format understood by Minecraft.*/
    public Float getMcAttackSpeed(){
        return -DEFAULT_ATTACK_SPEED + speed;
    }

    protected abstract String getDefaultTier();
    protected abstract Integer getDefaultDamage();
    protected abstract Float getDefaultAttackSpeed();
    protected abstract Boolean getDefaultFireResistance();
    protected abstract Integer getDefaultDurability();
}
