package net.twomoonsstudios.moonsweaponry.config.objects;

import io.github.hornster.itemfig.api.serialization.config.ConfigObj;
import net.minecraft.world.item.Tiers;
import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;
import net.twomoonsstudios.moonsweaponry.config.helpers.ConfigHelper;
import net.twomoonsstudios.moonsweaponry.config.objects.greatsword.*;
import net.twomoonsstudios.moonsweaponry.enums.WeaponTypesEnum;
import org.apache.commons.lang3.NotImplementedException;

public class ConfigObjectFactory {
    /**Method used to create object with predefined data. Mainly for converting pre-itemfig config version
     * to itemfig version.*/
    public ConfigObj createObjectConfig(WeaponTypesEnum weaponType, Tiers tier, MoonsWeaponsConfig.WeaponInfo objData) throws Exception {
        var weaponId = ConfigHelper.getWeaponId(weaponType, tier);
        switch(weaponType){

            case GREATSWORD -> {
                return greatSwordByMaterial(tier, weaponId, objData);
            }
            case HALBERD -> {
                return halberdByMaterial(tier, weaponId);
            }
            case HAMMER -> {
                return hammerByMaterial(tier, weaponId);
            }
            case KATANA -> {
                return katanaByMaterial(tier, weaponId);
            }
            case RAPIER -> {
                return rapierByMaterial(tier, weaponId);
            }
            case SCYTHE -> {
                return scytheByMaterial(tier, weaponId);
            }
            case WARGLAIVE -> {
                return warglaiveByMaterial(tier, weaponId);
            }
        }

        throw new Exception("Unknown weapon type: " + weaponType.name());
    }
    public ConfigObj createObjectConfig(WeaponTypesEnum weaponType, Tiers tier) throws Exception {
        return createObjectConfig(weaponType, tier, null);
    }

    private ConfigObj greatSwordByMaterial(Tiers tier, String weaponId, MoonsWeaponsConfig.WeaponInfo objData) throws Exception {
        switch (tier) {
            case WOOD -> {
                return objData == null ? new WoodenGreatswordConfigObj(weaponId) : new WoodenGreatswordConfigObj(weaponId, objData);
            }
            case STONE -> {
                return objData == null ? new StoneGreatswordConfigObj(weaponId) : new StoneGreatswordConfigObj(weaponId, objData);
            }
            case IRON -> {
                return objData == null ? new IronGreatswordConfigObj(weaponId) : new IronGreatswordConfigObj(weaponId, objData);
            }
            case DIAMOND -> {
                return objData == null ? new DiamondGreatswordConfigObj(weaponId) : new DiamondGreatswordConfigObj(weaponId, objData);
            }
            case GOLD -> {
                return objData == null ? new GoldenGreatswordConfigObj(weaponId) : new GoldenGreatswordConfigObj(weaponId, objData);
            }
            case NETHERITE -> {
                return objData == null ? new NetheriteGreatswordConfigObj(weaponId) : new NetheriteGreatswordConfigObj(weaponId, objData);
            }
        }
        throw new Exception("Unknown material for greatsword config object adapter config: " + tier.name());
    }
    private ConfigObj halberdByMaterial(Tiers tier, String weaponId){
        throw new NotImplementedException();
    }
    private ConfigObj hammerByMaterial(Tiers tier, String weaponId){
        throw new NotImplementedException();

    }
    private ConfigObj katanaByMaterial(Tiers tier, String weaponId){
        throw new NotImplementedException();

    }
    private ConfigObj rapierByMaterial(Tiers tier, String weaponId){
        throw new NotImplementedException();

    }
    private ConfigObj scytheByMaterial(Tiers tier, String weaponId){
        throw new NotImplementedException();

    }
    private ConfigObj warglaiveByMaterial(Tiers tier, String weaponId){
        throw new NotImplementedException();

    }
}
