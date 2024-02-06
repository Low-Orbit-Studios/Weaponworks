package net.crazedaerialcable.weaponworks.config.objects;

import io.github.hornster.itemfig.api.serialization.config.ConfigObj;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.crazedaerialcable.weaponworks.config.WeaponworksConfig;
import net.crazedaerialcable.weaponworks.config.helpers.ConfigHelper;
import net.crazedaerialcable.weaponworks.config.objects.greatsword.*;
import net.crazedaerialcable.weaponworks.config.objects.greatsword.WoodenGreatswordConfigObj;
import net.crazedaerialcable.weaponworks.config.objects.halberd.*;
import net.crazedaerialcable.weaponworks.config.objects.hammer.*;
import net.crazedaerialcable.weaponworks.config.objects.katana.*;
import net.crazedaerialcable.weaponworks.config.objects.mace.*;
import net.crazedaerialcable.weaponworks.config.objects.rapier.*;
import net.crazedaerialcable.weaponworks.config.objects.scythe.*;
import net.crazedaerialcable.weaponworks.config.objects.spear.*;
import net.crazedaerialcable.weaponworks.config.objects.warglaive.*;
import net.crazedaerialcable.weaponworks.enums.WeaponTypesEnum;

import static net.minecraft.item.ToolMaterials.*;

public class ConfigObjectFactory {
    /**Method used to create object with predefined data. Mainly for converting pre-itemfig config version
     * to itemfig version.*/
    public ConfigObj createObjectConfig(WeaponTypesEnum weaponType, ToolMaterials tier) throws Exception {
        var weaponId = ConfigHelper.getWeaponId(weaponType, tier);
        switch(weaponType){

            case GREATSWORD -> {
                return greatSwordByMaterial(tier, weaponId);
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
            case MACE -> {
                return maceByMaterial(tier, weaponId);
            }
            case SPEAR -> {
                return spearByMaterial(tier, weaponId);
            }
        }

        throw new Exception("Unknown weapon type: " + weaponType.name());
    }

    private ConfigObj greatSwordByMaterial(ToolMaterials tier, String weaponId) throws Exception {
        switch (tier) {
            case WOOD -> {
                return new WoodenGreatswordConfigObj(weaponId);
            }
            case STONE -> {
                return new StoneGreatswordConfigObj(weaponId);
            }
            case IRON -> {
                return new IronGreatswordConfigObj(weaponId);
            }
            case DIAMOND -> {
                return new DiamondGreatswordConfigObj(weaponId);
            }
            case GOLD -> {
                return new GoldenGreatswordConfigObj(weaponId);
            }
            case NETHERITE -> {
                return new NetheriteGreatswordConfigObj(weaponId);
            }
        }
        throw new Exception("Unknown material for greatsword config object adapter config: " + tier.name());
    }
    private ConfigObj halberdByMaterial(ToolMaterials tier, String weaponId) throws Exception {
        switch (tier) {
            case WOOD -> {
                return new WoodenHalberdConfigObj(weaponId);
            }
            case STONE -> {
                return new StoneHalberdConfigObj(weaponId);
            }
            case IRON -> {
                return new IronHalberdConfigObj(weaponId);
            }
            case DIAMOND -> {
                return new DiamondHalberdConfigObj(weaponId);
            }
            case GOLD -> {
                return new GoldenHalberdConfigObj(weaponId);
            }
            case NETHERITE -> {
                return new NetheriteHalberdConfigObj(weaponId);
            }
        }
        throw new Exception("Unknown material for halberd config object adapter config: " + tier.name());
    }
    private ConfigObj hammerByMaterial(ToolMaterials tier, String weaponId) throws Exception {
        switch (tier) {
            case WOOD -> {
                return new WoodenHammerConfigObj(weaponId);
            }
            case STONE -> {
                return new StoneHammerConfigObj(weaponId);
            }
            case IRON -> {
                return new IronHammerConfigObj(weaponId);
            }
            case DIAMOND -> {
                return new DiamondHammerConfigObj(weaponId);
            }
            case GOLD -> {
                return new GoldenHammerConfigObj(weaponId);
            }
            case NETHERITE -> {
                return new NetheriteHammerConfigObj(weaponId);
            }
        }
        throw new Exception("Unknown material for hammer config object adapter config: " + tier.name());

    }
    private ConfigObj katanaByMaterial(ToolMaterials tier, String weaponId) throws Exception {
        switch (tier) {
            case WOOD -> {
                return new WoodenKatanaConfigObj(weaponId);
            }
            case STONE -> {
                return new StoneKatanaConfigObj(weaponId);
            }
            case IRON -> {
                return new IronKatanaConfigObj(weaponId);
            }
            case DIAMOND -> {
                return new DiamondKatanaConfigObj(weaponId);
            }
            case GOLD -> {
                return new GoldenKatanaConfigObj(weaponId);
            }
            case NETHERITE -> {
                return new NetheriteKatanaConfigObj(weaponId);
            }
        }
        throw new Exception("Unknown material for katana config object adapter config: " + tier.name());

    }
    private ConfigObj rapierByMaterial(ToolMaterials tier, String weaponId) throws Exception {
        switch (tier) {
            case WOOD -> {
                return new WoodenRapierConfigObj(weaponId);
            }
            case STONE -> {
                return new StoneRapierConfigObj(weaponId);
            }
            case IRON -> {
                return new IronRapierConfigObj(weaponId);
            }
            case DIAMOND -> {
                return new DiamondRapierConfigObj(weaponId);
            }
            case GOLD -> {
                return new GoldenRapierConfigObj(weaponId);
            }
            case NETHERITE -> {
                return new NetheriteRapierConfigObj(weaponId);
            }
        }
        throw new Exception("Unknown material for rapier config object adapter config: " + tier.name());

    }
    private ConfigObj scytheByMaterial(ToolMaterials tier, String weaponId) throws Exception {
        switch (tier) {
            case WOOD -> {
                return new WoodenScytheConfigObj(weaponId);
            }
            case STONE -> {
                return new StoneScytheConfigObj(weaponId);
            }
            case IRON -> {
                return new IronScytheConfigObj(weaponId);
            }
            case DIAMOND -> {
                return new DiamondScytheConfigObj(weaponId);
            }
            case GOLD -> {
                return new GoldenScytheConfigObj(weaponId);
            }
            case NETHERITE -> {
                return new NetheriteScytheConfigObj(weaponId);
            }
        }
        throw new Exception("Unknown material for scythe config object adapter config: " + tier.name());

    }
    private ConfigObj warglaiveByMaterial(ToolMaterials tier, String weaponId) throws Exception {
        switch (tier) {
            case WOOD -> {
                return new WoodenWarglaiveConfigObj(weaponId);
            }
            case STONE -> {
                return new StoneWarglaiveConfigObj(weaponId);
            }
            case IRON -> {
                return new IronWarglaiveConfigObj(weaponId);
            }
            case DIAMOND -> {
                return new DiamondWarglaiveConfigObj(weaponId);
            }
            case GOLD -> {
                return new GoldenWarglaiveConfigObj(weaponId);
            }
            case NETHERITE -> {
                return new NetheriteWarglaiveConfigObj(weaponId);
            }
        }
        throw new Exception("Unknown material for warglaive config object adapter config: " + tier.name());

    }
    private ConfigObj maceByMaterial(ToolMaterials tier, String weaponId) throws Exception {
        switch (tier) {
            case WOOD -> {
                return new WoodenMaceConfigObj(weaponId);
            }
            case STONE -> {
                return new StoneMaceConfigObj(weaponId);
            }
            case IRON -> {
                return new IronMaceConfigObj(weaponId);
            }
            case DIAMOND -> {
                return new DiamondMaceConfigObj(weaponId);
            }
            case GOLD -> {
                return new GoldenMaceConfigObj(weaponId);
            }
            case NETHERITE -> {
                return new NetheriteMaceConfigObj(weaponId);
            }
        }
        throw new Exception("Unknown material for mace config object adapter config: " + tier.name());
    }
    private ConfigObj spearByMaterial(ToolMaterials tier, String weaponId) throws Exception {
        switch (tier) {
            case WOOD -> {
                return new WoodenSpearConfigObj(weaponId);
            }
            case STONE -> {
                return new StoneSpearConfigObj(weaponId);
            }
            case IRON -> {
                return new IronSpearConfigObj(weaponId);
            }
            case DIAMOND -> {
                return new DiamondSpearConfigObj(weaponId);
            }
            case GOLD -> {
                return new GoldenSpearConfigObj(weaponId);
            }
            case NETHERITE -> {
                return new NetheriteSpearConfigObj(weaponId);
            }
        }
        throw new Exception("Unknown material for spear config object adapter config: " + tier.name());
    }
}
