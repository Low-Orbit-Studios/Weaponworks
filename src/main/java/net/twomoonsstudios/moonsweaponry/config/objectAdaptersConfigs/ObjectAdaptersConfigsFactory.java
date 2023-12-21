package net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs;

import io.github.hornster.itemfig.api.serialization.config.ConfigObjAdapterConfig;
import net.minecraft.world.item.Tiers;
import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.greatsword.*;
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
    private ConfigObjAdapterConfig<?> halberdByMaterial(Tiers tier){
        throw new NotImplementedException();
    }
    private ConfigObjAdapterConfig<?> hammerByMaterial(Tiers tier){
        throw new NotImplementedException();

    }
    private ConfigObjAdapterConfig<?> katanaByMaterial(Tiers tier){
        throw new NotImplementedException();

    }
    private ConfigObjAdapterConfig<?> rapierByMaterial(Tiers tier){
        throw new NotImplementedException();

    }
    private ConfigObjAdapterConfig<?> scytheByMaterial(Tiers tier){
        throw new NotImplementedException();

    }
    private ConfigObjAdapterConfig<?> warglaiveByMaterial(Tiers tier){
        throw new NotImplementedException();

    }
}
