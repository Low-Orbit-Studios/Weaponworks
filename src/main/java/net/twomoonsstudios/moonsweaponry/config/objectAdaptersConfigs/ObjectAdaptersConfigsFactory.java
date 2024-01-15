package net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs;

import io.github.hornster.itemfig.api.serialization.config.ConfigObjAdapterConfig;
import net.minecraft.world.item.Tiers;
import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.greatsword.*;
import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.halberd.*;
import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.hammer.*;
import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.katana.*;
import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.mace.*;
import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.rapier.*;
import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.scythe.*;
import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.spear.*;
import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.warglaive.*;
import net.twomoonsstudios.moonsweaponry.enums.WeaponTypesEnum;
import org.apache.commons.lang3.NotImplementedException;

public class ObjectAdaptersConfigsFactory {
    public ConfigObjAdapterConfig<?> createObjectAdapterConfig(WeaponTypesEnum weaponType, Tiers tier) throws Exception {
        switch(weaponType){

            case GREATSWORD -> {
                return greatSwordByMaterial(tier);
            }
            case HALBERD -> {
                return halberdByMaterial(tier);
            }
            case HAMMER -> {
                return hammerByMaterial(tier);
            }
            case KATANA -> {
                return katanaByMaterial(tier);
            }
            case RAPIER -> {
                return rapierByMaterial(tier);
            }
            case SCYTHE -> {
                return scytheByMaterial(tier);
            }
            case WARGLAIVE -> {
                return warglaiveByMaterial(tier);
            }
            case MACE -> {
                return maceByMaterial(tier);
            }
            case SPEAR -> {
                return spearByMaterial(tier);
            }
        }

        throw new Exception("Unknown weapon type: " + weaponType.name());
    }



    private ConfigObjAdapterConfig<?> greatSwordByMaterial(Tiers tier) throws Exception {
        switch (tier) {
            case WOOD -> {
                return new WoodenGreatswordObjAdapterConfig();
            }
            case STONE -> {
                return new StoneGreatswordObjAdapterConfig();
            }
            case IRON -> {
                return new IronGreatswordObjAdapterConfig();
            }
            case DIAMOND -> {
                return new DiamondGreatswordObjAdapterConfig();
            }
            case GOLD -> {
                return new GoldenGreatswordObjAdapterConfig();
            }
            case NETHERITE -> {
                return new NetheriteGreatswordObjAdapterConfig();
            }
        }
        throw new Exception("Unknown material for greatsword config object adapter config: " + tier.name());
    }
    private ConfigObjAdapterConfig<?> halberdByMaterial(Tiers tier) throws Exception {
        switch (tier) {
            case WOOD -> {
                return new WoodenHalberdObjAdapterConfig();
            }
            case STONE -> {
                return new StoneHalberdObjAdapterConfig();
            }
            case IRON -> {
                return new IronHalberdObjAdapterConfig();
            }
            case DIAMOND -> {
                return new DiamondHalberdObjAdapterConfig();
            }
            case GOLD -> {
                return new GoldenHalberdObjAdapterConfig();
            }
            case NETHERITE -> {
                return new NetheriteHalberdObjAdapterConfig();
            }
        }
        throw new Exception("Unknown material for halberd config object adapter config: " + tier.name());
    }
    private ConfigObjAdapterConfig<?> hammerByMaterial(Tiers tier) throws Exception {
        switch (tier) {
            case WOOD -> {
                return new WoodenHammerObjAdapterConfig();
            }
            case STONE -> {
                return new StoneHammerObjAdapterConfig();
            }
            case IRON -> {
                return new IronHammerObjAdapterConfig();
            }
            case DIAMOND -> {
                return new DiamondHammerObjAdapterConfig();
            }
            case GOLD -> {
                return new GoldenHammerObjAdapterConfig();
            }
            case NETHERITE -> {
                return new NetheriteHammerObjAdapterConfig();
            }
        }
        throw new Exception("Unknown material for hammer config object adapter config: " + tier.name());

    }
    private ConfigObjAdapterConfig<?> katanaByMaterial(Tiers tier) throws Exception {
        switch (tier) {
            case WOOD -> {
                return new WoodenKatanaObjAdapterConfig();
            }
            case STONE -> {
                return new StoneKatanaObjAdapterConfig();
            }
            case IRON -> {
                return new IronKatanaObjAdapterConfig();
            }
            case DIAMOND -> {
                return new DiamondKatanaObjAdapterConfig();
            }
            case GOLD -> {
                return new GoldenKatanaObjAdapterConfig();
            }
            case NETHERITE -> {
                return new NetheriteKatanaObjAdapterConfig();
            }
        }
        throw new Exception("Unknown material for katana config object adapter config: " + tier.name());
    }
    private ConfigObjAdapterConfig<?> rapierByMaterial(Tiers tier) throws Exception {
        switch (tier) {
            case WOOD -> {
                return new WoodenRapierObjAdapterConfig();
            }
            case STONE -> {
                return new StoneRapierObjAdapterConfig();
            }
            case IRON -> {
                return new IronRapierObjAdapterConfig();
            }
            case DIAMOND -> {
                return new DiamondRapierObjAdapterConfig();
            }
            case GOLD -> {
                return new GoldenRapierObjAdapterConfig();
            }
            case NETHERITE -> {
                return new NetheriteRapierObjAdapterConfig();
            }
        }
        throw new Exception("Unknown material for rapier config object adapter config: " + tier.name());
    }
    private ConfigObjAdapterConfig<?> scytheByMaterial(Tiers tier) throws Exception {
        switch (tier) {
            case WOOD -> {
                return new WoodenScytheObjAdapterConfig();
            }
            case STONE -> {
                return new StoneScytheObjAdapterConfig();
            }
            case IRON -> {
                return new IronScytheObjAdapterConfig();
            }
            case DIAMOND -> {
                return new DiamondScytheObjAdapterConfig();
            }
            case GOLD -> {
                return new GoldenScytheObjAdapterConfig();
            }
            case NETHERITE -> {
                return new NetheriteScytheObjAdapterConfig();
            }
        }
        throw new Exception("Unknown material for scythe config object adapter config: " + tier.name());

    }
    private ConfigObjAdapterConfig<?> warglaiveByMaterial(Tiers tier) throws Exception {
        switch (tier) {
            case WOOD -> {
                return new WoodenWarglaiveObjAdapterConfig();
            }
            case STONE -> {
                return new StoneWarglaiveObjAdapterConfig();
            }
            case IRON -> {
                return new IronWarglaiveObjAdapterConfig();
            }
            case DIAMOND -> {
                return new DiamondWarglaiveObjAdapterConfig();
            }
            case GOLD -> {
                return new GoldenWarglaiveObjAdapterConfig();
            }
            case NETHERITE -> {
                return new NetheriteWarglaiveObjAdapterConfig();
            }
        }
        throw new Exception("Unknown material for warglaive config object adapter config: " + tier.name());
    }
    private ConfigObjAdapterConfig<?> spearByMaterial(Tiers tier) throws Exception {
        switch (tier) {
            case WOOD -> {
                return new WoodenSpearObjAdapterConfig();
            }
            case STONE -> {
                return new StoneSpearObjAdapterConfig();
            }
            case IRON -> {
                return new IronSpearObjAdapterConfig();
            }
            case DIAMOND -> {
                return new DiamondSpearObjAdapterConfig();
            }
            case GOLD -> {
                return new GoldenSpearObjAdapterConfig();
            }
            case NETHERITE -> {
                return new NetheriteSpearObjAdapterConfig();
            }
        }
        throw new Exception("Unknown material for spear config object adapter config: " + tier.name());
    }

    private ConfigObjAdapterConfig<?> maceByMaterial(Tiers tier)  throws Exception {
        switch (tier) {
            case WOOD -> {
                return new WoodenMaceObjAdapterConfig();
            }
            case STONE -> {
                return new StoneMaceObjAdapterConfig();
            }
            case IRON -> {
                return new IronMaceObjAdapterConfig();
            }
            case DIAMOND -> {
                return new DiamondMaceObjAdapterConfig();
            }
            case GOLD -> {
                return new GoldenMaceObjAdapterConfig();
            }
            case NETHERITE -> {
                return new NetheriteMaceObjAdapterConfig();
            }
        }
        throw new Exception("Unknown material for mace config object adapter config: " + tier.name());
    }
}
