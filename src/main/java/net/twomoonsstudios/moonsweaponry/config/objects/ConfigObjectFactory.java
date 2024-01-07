package net.twomoonsstudios.moonsweaponry.config.objects;

import io.github.hornster.itemfig.api.serialization.config.ConfigObj;
import net.minecraft.world.item.Tiers;
import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;
import net.twomoonsstudios.moonsweaponry.config.helpers.ConfigHelper;
import net.twomoonsstudios.moonsweaponry.config.objects.greatsword.*;
import net.twomoonsstudios.moonsweaponry.config.objects.greatsword.WoodenGreatswordConfigObj;
import net.twomoonsstudios.moonsweaponry.config.objects.halberd.*;
import net.twomoonsstudios.moonsweaponry.config.objects.hammer.*;
import net.twomoonsstudios.moonsweaponry.config.objects.katana.*;
import net.twomoonsstudios.moonsweaponry.config.objects.mace.*;
import net.twomoonsstudios.moonsweaponry.config.objects.rapier.*;
import net.twomoonsstudios.moonsweaponry.config.objects.scythe.*;
import net.twomoonsstudios.moonsweaponry.config.objects.spear.*;
import net.twomoonsstudios.moonsweaponry.config.objects.warglaive.*;
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
                return halberdByMaterial(tier, weaponId, objData);
            }
            case HAMMER -> {
                return hammerByMaterial(tier, weaponId, objData);
            }
            case KATANA -> {
                return katanaByMaterial(tier, weaponId, objData);
            }
            case RAPIER -> {
                return rapierByMaterial(tier, weaponId, objData);
            }
            case SCYTHE -> {
                return scytheByMaterial(tier, weaponId, objData);
            }
            case WARGLAIVE -> {
                return warglaiveByMaterial(tier, weaponId, objData);
            }
            case MACE -> {
                return maceByMaterial(tier, weaponId, objData);
            }
            case SPEAR -> {
                return spearByMaterial(tier, weaponId, objData);
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
    private ConfigObj halberdByMaterial(Tiers tier, String weaponId, MoonsWeaponsConfig.WeaponInfo objData) throws Exception {
        switch (tier) {
            case WOOD -> {
                return objData == null ? new WoodenHalberdConfigObj(weaponId) : new WoodenHalberdConfigObj(weaponId, objData);
            }
            case STONE -> {
                return objData == null ? new StoneHalberdConfigObj(weaponId) : new StoneHalberdConfigObj(weaponId, objData);
            }
            case IRON -> {
                return objData == null ? new IronHalberdConfigObj(weaponId) : new IronHalberdConfigObj(weaponId, objData);
            }
            case DIAMOND -> {
                return objData == null ? new DiamondHalberdConfigObj(weaponId) : new DiamondHalberdConfigObj(weaponId, objData);
            }
            case GOLD -> {
                return objData == null ? new GoldenHalberdConfigObj(weaponId) : new GoldenHalberdConfigObj(weaponId, objData);
            }
            case NETHERITE -> {
                return objData == null ? new NetheriteHalberdConfigObj(weaponId) : new NetheriteHalberdConfigObj(weaponId, objData);
            }
        }
        throw new Exception("Unknown material for halberd config object adapter config: " + tier.name());
    }
    private ConfigObj hammerByMaterial(Tiers tier, String weaponId, MoonsWeaponsConfig.WeaponInfo objData) throws Exception {
        switch (tier) {
            case WOOD -> {
                return objData == null ? new WoodenHammerConfigObj(weaponId) : new WoodenHammerConfigObj(weaponId, objData);
            }
            case STONE -> {
                return objData == null ? new StoneHammerConfigObj(weaponId) : new StoneHammerConfigObj(weaponId, objData);
            }
            case IRON -> {
                return objData == null ? new IronHammerConfigObj(weaponId) : new IronHammerConfigObj(weaponId, objData);
            }
            case DIAMOND -> {
                return objData == null ? new DiamondHammerConfigObj(weaponId) : new DiamondHammerConfigObj(weaponId, objData);
            }
            case GOLD -> {
                return objData == null ? new GoldenHammerConfigObj(weaponId) : new GoldenHammerConfigObj(weaponId, objData);
            }
            case NETHERITE -> {
                return objData == null ? new NetheriteHammerConfigObj(weaponId) : new NetheriteHammerConfigObj(weaponId, objData);
            }
        }
        throw new Exception("Unknown material for hammer config object adapter config: " + tier.name());

    }
    private ConfigObj katanaByMaterial(Tiers tier, String weaponId, MoonsWeaponsConfig.WeaponInfo objData) throws Exception {
        switch (tier) {
            case WOOD -> {
                return objData == null ? new WoodenKatanaConfigObj(weaponId) : new WoodenKatanaConfigObj(weaponId, objData);
            }
            case STONE -> {
                return objData == null ? new StoneKatanaConfigObj(weaponId) : new StoneKatanaConfigObj(weaponId, objData);
            }
            case IRON -> {
                return objData == null ? new IronKatanaConfigObj(weaponId) : new IronKatanaConfigObj(weaponId, objData);
            }
            case DIAMOND -> {
                return objData == null ? new DiamondKatanaConfigObj(weaponId) : new DiamondKatanaConfigObj(weaponId, objData);
            }
            case GOLD -> {
                return objData == null ? new GoldenKatanaConfigObj(weaponId) : new GoldenKatanaConfigObj(weaponId, objData);
            }
            case NETHERITE -> {
                return objData == null ? new NetheriteKatanaConfigObj(weaponId) : new NetheriteKatanaConfigObj(weaponId, objData);
            }
        }
        throw new Exception("Unknown material for katana config object adapter config: " + tier.name());

    }
    private ConfigObj rapierByMaterial(Tiers tier, String weaponId, MoonsWeaponsConfig.WeaponInfo objData) throws Exception {
        switch (tier) {
            case WOOD -> {
                return objData == null ? new WoodenRapierConfigObj(weaponId) : new WoodenRapierConfigObj(weaponId, objData);
            }
            case STONE -> {
                return objData == null ? new StoneRapierConfigObj(weaponId) : new StoneRapierConfigObj(weaponId, objData);
            }
            case IRON -> {
                return objData == null ? new IronRapierConfigObj(weaponId) : new IronRapierConfigObj(weaponId, objData);
            }
            case DIAMOND -> {
                return objData == null ? new DiamondRapierConfigObj(weaponId) : new DiamondRapierConfigObj(weaponId, objData);
            }
            case GOLD -> {
                return objData == null ? new GoldenRapierConfigObj(weaponId) : new GoldenRapierConfigObj(weaponId, objData);
            }
            case NETHERITE -> {
                return objData == null ? new NetheriteRapierConfigObj(weaponId) : new NetheriteRapierConfigObj(weaponId, objData);
            }
        }
        throw new Exception("Unknown material for rapier config object adapter config: " + tier.name());

    }
    private ConfigObj scytheByMaterial(Tiers tier, String weaponId, MoonsWeaponsConfig.WeaponInfo objData) throws Exception {
        switch (tier) {
            case WOOD -> {
                return objData == null ? new WoodenScytheConfigObj(weaponId) : new WoodenScytheConfigObj(weaponId, objData);
            }
            case STONE -> {
                return objData == null ? new StoneScytheConfigObj(weaponId) : new StoneScytheConfigObj(weaponId, objData);
            }
            case IRON -> {
                return objData == null ? new IronScytheConfigObj(weaponId) : new IronScytheConfigObj(weaponId, objData);
            }
            case DIAMOND -> {
                return objData == null ? new DiamondScytheConfigObj(weaponId) : new DiamondScytheConfigObj(weaponId, objData);
            }
            case GOLD -> {
                return objData == null ? new GoldenScytheConfigObj(weaponId) : new GoldenScytheConfigObj(weaponId, objData);
            }
            case NETHERITE -> {
                return objData == null ? new NetheriteScytheConfigObj(weaponId) : new NetheriteScytheConfigObj(weaponId, objData);
            }
        }
        throw new Exception("Unknown material for scythe config object adapter config: " + tier.name());

    }
    private ConfigObj warglaiveByMaterial(Tiers tier, String weaponId, MoonsWeaponsConfig.WeaponInfo objData) throws Exception {
        switch (tier) {
            case WOOD -> {
                return objData == null ? new WoodenWarglaiveConfigObj(weaponId) : new WoodenWarglaiveConfigObj(weaponId, objData);
            }
            case STONE -> {
                return objData == null ? new StoneWarglaiveConfigObj(weaponId) : new StoneWarglaiveConfigObj(weaponId, objData);
            }
            case IRON -> {
                return objData == null ? new IronWarglaiveConfigObj(weaponId) : new IronWarglaiveConfigObj(weaponId, objData);
            }
            case DIAMOND -> {
                return objData == null ? new DiamondWarglaiveConfigObj(weaponId) : new DiamondWarglaiveConfigObj(weaponId, objData);
            }
            case GOLD -> {
                return objData == null ? new GoldenWarglaiveConfigObj(weaponId) : new GoldenWarglaiveConfigObj(weaponId, objData);
            }
            case NETHERITE -> {
                return objData == null ? new NetheriteWarglaiveConfigObj(weaponId) : new NetheriteWarglaiveConfigObj(weaponId, objData);
            }
        }
        throw new Exception("Unknown material for warglaive config object adapter config: " + tier.name());

    }
    private ConfigObj maceByMaterial(Tiers tier, String weaponId, MoonsWeaponsConfig.WeaponInfo objData) throws Exception {
        switch (tier) {
            case WOOD -> {
                return objData == null ? new WoodenMaceConfigObj(weaponId) : new WoodenMaceConfigObj(weaponId, objData);
            }
            case STONE -> {
                return objData == null ? new StoneMaceConfigObj(weaponId) : new StoneMaceConfigObj(weaponId, objData);
            }
            case IRON -> {
                return objData == null ? new IronMaceConfigObj(weaponId) : new IronMaceConfigObj(weaponId, objData);
            }
            case DIAMOND -> {
                return objData == null ? new DiamondMaceConfigObj(weaponId) : new DiamondMaceConfigObj(weaponId, objData);
            }
            case GOLD -> {
                return objData == null ? new GoldenMaceConfigObj(weaponId) : new GoldenMaceConfigObj(weaponId, objData);
            }
            case NETHERITE -> {
                return objData == null ? new NetheriteMaceConfigObj(weaponId) : new NetheriteMaceConfigObj(weaponId, objData);
            }
        }
        throw new Exception("Unknown material for mace config object adapter config: " + tier.name());
    }
    private ConfigObj spearByMaterial(Tiers tier, String weaponId, MoonsWeaponsConfig.WeaponInfo objData) throws Exception {
        switch (tier) {
            case WOOD -> {
                return objData == null ? new WoodenSpearConfigObj(weaponId) : new WoodenSpearConfigObj(weaponId, objData);
            }
            case STONE -> {
                return objData == null ? new StoneSpearConfigObj(weaponId) : new StoneSpearConfigObj(weaponId, objData);
            }
            case IRON -> {
                return objData == null ? new IronSpearConfigObj(weaponId) : new IronSpearConfigObj(weaponId, objData);
            }
            case DIAMOND -> {
                return objData == null ? new DiamondSpearConfigObj(weaponId) : new DiamondSpearConfigObj(weaponId, objData);
            }
            case GOLD -> {
                return objData == null ? new GoldenSpearConfigObj(weaponId) : new GoldenSpearConfigObj(weaponId, objData);
            }
            case NETHERITE -> {
                return objData == null ? new NetheriteSpearConfigObj(weaponId) : new NetheriteSpearConfigObj(weaponId, objData);
            }
        }
        throw new Exception("Unknown material for spear config object adapter config: " + tier.name());
    }
}
