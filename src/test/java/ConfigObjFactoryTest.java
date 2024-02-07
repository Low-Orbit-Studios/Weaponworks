import io.github.hornster.itemfig.api.serialization.config.ConfigObjAdapterConfig;
import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.ObjectAdaptersConfigsFactory;
import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.greatsword.*;
import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.halberd.*;
import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.hammer.*;
import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.katana.*;
import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.mace.*;
import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.rapier.*;
import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.scythe.*;
import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.spear.*;
import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.warglaive.*;
import net.crazedaerialcable.weaponworks.config.objects.ConfigObjectFactory;
import net.crazedaerialcable.weaponworks.config.objects.greatsword.*;
import net.crazedaerialcable.weaponworks.config.objects.halberd.*;
import net.crazedaerialcable.weaponworks.config.objects.hammer.*;
import net.crazedaerialcable.weaponworks.config.objects.katana.*;
import net.crazedaerialcable.weaponworks.config.objects.mace.*;
import net.crazedaerialcable.weaponworks.config.objects.rapier.*;
import net.crazedaerialcable.weaponworks.config.objects.scythe.*;
import net.crazedaerialcable.weaponworks.config.objects.spear.*;
import net.crazedaerialcable.weaponworks.config.objects.warglaive.*;
import net.crazedaerialcable.weaponworks.enums.WeaponTypesEnum;
import net.minecraft.item.ToolMaterials;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Type;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConfigObjFactoryTest {
    ConfigObjectFactory factory;
    ObjectAdaptersConfigsFactory adapterFactory;
    @BeforeEach
    void setUp(){
        factory = new ConfigObjectFactory();
        adapterFactory = new ObjectAdaptersConfigsFactory();
    }
    private static Type getAdapterType(ToolMaterials tier, WeaponTypesEnum weaponType) throws Exception {
        switch (weaponType) {
            case GREATSWORD -> {
                switch (tier) {
                    case WOOD -> {
                        return WoodenGreatswordObjAdapterConfig.class;
                    }
                    case STONE -> {
                        return StoneGreatswordObjAdapterConfig.class;
                    }
                    case IRON -> {
                        return IronGreatswordObjAdapterConfig.class;
                    }
                    case DIAMOND -> {
                        return DiamondGreatswordObjAdapterConfig.class;
                    }
                    case GOLD -> {
                        return GoldenGreatswordObjAdapterConfig.class;
                    }
                    case NETHERITE -> {
                        return NetheriteGreatswordObjAdapterConfig.class;
                    }
                }
            }
            case HALBERD -> {
                switch (tier) {
                    case WOOD -> {
                        return WoodenHalberdObjAdapterConfig.class;
                    }
                    case STONE -> {
                        return StoneHalberdObjAdapterConfig.class;
                    }
                    case IRON -> {
                        return IronHalberdObjAdapterConfig.class;
                    }
                    case DIAMOND -> {
                        return DiamondHalberdObjAdapterConfig.class;
                    }
                    case GOLD -> {
                        return GoldenHalberdObjAdapterConfig.class;
                    }
                    case NETHERITE -> {
                        return NetheriteHalberdObjAdapterConfig.class;
                    }
                }
            }
            case HAMMER -> {
                switch (tier) {
                case WOOD -> {
                    return WoodenHammerObjAdapterConfig.class;
                }
                case STONE -> {
                    return StoneHammerObjAdapterConfig.class;
                }
                case IRON -> {
                    return IronHammerObjAdapterConfig.class;
                }
                case DIAMOND -> {
                    return DiamondHammerObjAdapterConfig.class;
                }
                case GOLD -> {
                    return GoldenHammerObjAdapterConfig.class;
                }
                case NETHERITE -> {
                    return NetheriteHammerObjAdapterConfig.class;
                }
            }
            }
            case KATANA -> {
                switch (tier) {
                    case WOOD -> {
                        return WoodenKatanaObjAdapterConfig.class;
                    }
                    case STONE -> {
                        return StoneKatanaObjAdapterConfig.class;
                    }
                    case IRON -> {
                        return IronKatanaObjAdapterConfig.class;
                    }
                    case DIAMOND -> {
                        return DiamondKatanaObjAdapterConfig.class;
                    }
                    case GOLD -> {
                        return GoldenKatanaObjAdapterConfig.class;
                    }
                    case NETHERITE -> {
                        return NetheriteKatanaObjAdapterConfig.class;
                    }
                }
            }
            case RAPIER -> {
                switch (tier) {
                    case WOOD -> {
                        return WoodenRapierObjAdapterConfig.class;
                    }
                    case STONE -> {
                        return StoneRapierObjAdapterConfig.class;
                    }
                    case IRON -> {
                        return IronRapierObjAdapterConfig.class;
                    }
                    case DIAMOND -> {
                        return DiamondRapierObjAdapterConfig.class;
                    }
                    case GOLD -> {
                        return GoldenRapierObjAdapterConfig.class;
                    }
                    case NETHERITE -> {
                        return NetheriteRapierObjAdapterConfig.class;
                    }
                }
            }
            case SCYTHE -> {switch (tier) {
                case WOOD -> {
                    return WoodenScytheObjAdapterConfig.class;
                }
                case STONE -> {
                    return StoneScytheObjAdapterConfig.class;
                }
                case IRON -> {
                    return IronScytheObjAdapterConfig.class;
                }
                case DIAMOND -> {
                    return DiamondScytheObjAdapterConfig.class;
                }
                case GOLD -> {
                    return GoldenScytheObjAdapterConfig.class;
                }
                case NETHERITE -> {
                    return NetheriteScytheObjAdapterConfig.class;
                }
            }
            }
            case WARGLAIVE -> {
                switch (tier) {
                    case WOOD -> {
                        return WoodenWarglaiveObjAdapterConfig.class;
                    }
                    case STONE -> {
                        return StoneWarglaiveObjAdapterConfig.class;
                    }
                    case IRON -> {
                        return IronWarglaiveObjAdapterConfig.class;
                    }
                    case DIAMOND -> {
                        return DiamondWarglaiveObjAdapterConfig.class;
                    }
                    case GOLD -> {
                        return GoldenWarglaiveObjAdapterConfig.class;
                    }
                    case NETHERITE -> {
                        return NetheriteWarglaiveObjAdapterConfig.class;
                    }
                }
            }
            case MACE -> {
                switch (tier) {
                    case WOOD -> {
                        return WoodenMaceObjAdapterConfig.class;
                    }
                    case STONE -> {
                        return StoneMaceObjAdapterConfig.class;
                    }
                    case IRON -> {
                        return IronMaceObjAdapterConfig.class;
                    }
                    case DIAMOND -> {
                        return DiamondMaceObjAdapterConfig.class;
                    }
                    case GOLD -> {
                        return GoldenMaceObjAdapterConfig.class;
                    }
                    case NETHERITE -> {
                        return NetheriteMaceObjAdapterConfig.class;
                    }
                }
            }
            case SPEAR -> {
                switch (tier) {
                    case WOOD -> {
                        return WoodenSpearObjAdapterConfig.class;
                    }
                    case STONE -> {
                        return StoneSpearObjAdapterConfig.class;
                    }
                    case IRON -> {
                        return IronSpearObjAdapterConfig.class;
                    }
                    case DIAMOND -> {
                        return DiamondSpearObjAdapterConfig.class;
                    }
                    case GOLD -> {
                        return GoldenSpearObjAdapterConfig.class;
                    }
                    case NETHERITE -> {
                        return NetheriteSpearObjAdapterConfig.class;
                    }
                }
            }
        }
        throw new Exception("Unknown type " + weaponType + " and " + tier);
    }
    private static Type getConfigObjType(ToolMaterials tier, WeaponTypesEnum weaponType) throws Exception {
        switch (weaponType) {
            case GREATSWORD -> {
                switch (tier) {
                    case WOOD -> {
                        return WoodenGreatswordConfigObj.class;
                    }
                    case STONE -> {
                        return StoneGreatswordConfigObj.class;
                    }
                    case IRON -> {
                        return IronGreatswordConfigObj.class;
                    }
                    case DIAMOND -> {
                        return DiamondGreatswordConfigObj.class;
                    }
                    case GOLD -> {
                        return GoldenGreatswordConfigObj.class;
                    }
                    case NETHERITE -> {
                        return NetheriteGreatswordConfigObj.class;
                    }
                }
            }
            case HALBERD -> {
                switch (tier) {
                    case WOOD -> {
                        return WoodenHalberdConfigObj.class;
                    }
                    case STONE -> {
                        return StoneHalberdConfigObj.class;
                    }
                    case IRON -> {
                        return IronHalberdConfigObj.class;
                    }
                    case DIAMOND -> {
                        return DiamondHalberdConfigObj.class;
                    }
                    case GOLD -> {
                        return GoldenHalberdConfigObj.class;
                    }
                    case NETHERITE -> {
                        return NetheriteHalberdConfigObj.class;
                    }
                }
            }
            case HAMMER -> {
                switch (tier) {
                    case WOOD -> {
                        return WoodenHammerConfigObj.class;
                    }
                    case STONE -> {
                        return StoneHammerConfigObj.class;
                    }
                    case IRON -> {
                        return IronHammerConfigObj.class;
                    }
                    case DIAMOND -> {
                        return DiamondHammerConfigObj.class;
                    }
                    case GOLD -> {
                        return GoldenHammerConfigObj.class;
                    }
                    case NETHERITE -> {
                        return NetheriteHammerConfigObj.class;
                    }
                }
            }
            case KATANA -> {
                switch (tier) {
                    case WOOD -> {
                        return WoodenKatanaConfigObj.class;
                    }
                    case STONE -> {
                        return StoneKatanaConfigObj.class;
                    }
                    case IRON -> {
                        return IronKatanaConfigObj.class;
                    }
                    case DIAMOND -> {
                        return DiamondKatanaConfigObj.class;
                    }
                    case GOLD -> {
                        return GoldenKatanaConfigObj.class;
                    }
                    case NETHERITE -> {
                        return NetheriteKatanaConfigObj.class;
                    }
                }
            }
            case RAPIER -> {
                switch (tier) {
                    case WOOD -> {
                        return WoodenRapierConfigObj.class;
                    }
                    case STONE -> {
                        return StoneRapierConfigObj.class;
                    }
                    case IRON -> {
                        return IronRapierConfigObj.class;
                    }
                    case DIAMOND -> {
                        return DiamondRapierConfigObj.class;
                    }
                    case GOLD -> {
                        return GoldenRapierConfigObj.class;
                    }
                    case NETHERITE -> {
                        return NetheriteRapierConfigObj.class;
                    }
                }
            }
            case SCYTHE -> {switch (tier) {
                case WOOD -> {
                    return WoodenScytheConfigObj.class;
                }
                case STONE -> {
                    return StoneScytheConfigObj.class;
                }
                case IRON -> {
                    return IronScytheConfigObj.class;
                }
                case DIAMOND -> {
                    return DiamondScytheConfigObj.class;
                }
                case GOLD -> {
                    return GoldenScytheConfigObj.class;
                }
                case NETHERITE -> {
                    return NetheriteScytheConfigObj.class;
                }
            }
            }
            case WARGLAIVE -> {
                switch (tier) {
                    case WOOD -> {
                        return WoodenWarglaiveConfigObj.class;
                    }
                    case STONE -> {
                        return StoneWarglaiveConfigObj.class;
                    }
                    case IRON -> {
                        return IronWarglaiveConfigObj.class;
                    }
                    case DIAMOND -> {
                        return DiamondWarglaiveConfigObj.class;
                    }
                    case GOLD -> {
                        return GoldenWarglaiveConfigObj.class;
                    }
                    case NETHERITE -> {
                        return NetheriteWarglaiveConfigObj.class;
                    }
                }
            }
            case MACE -> {
                switch (tier) {
                    case WOOD -> {
                        return WoodenMaceConfigObj.class;
                    }
                    case STONE -> {
                        return StoneMaceConfigObj.class;
                    }
                    case IRON -> {
                        return IronMaceConfigObj.class;
                    }
                    case DIAMOND -> {
                        return DiamondMaceConfigObj.class;
                    }
                    case GOLD -> {
                        return GoldenMaceConfigObj.class;
                    }
                    case NETHERITE -> {
                        return NetheriteMaceConfigObj.class;
                    }
                }
            }
            case SPEAR -> {
                switch (tier) {
                    case WOOD -> {
                        return WoodenSpearConfigObj.class;
                    }
                    case STONE -> {
                        return StoneSpearConfigObj.class;
                    }
                    case IRON -> {
                        return IronSpearConfigObj.class;
                    }
                    case DIAMOND -> {
                        return DiamondSpearConfigObj.class;
                    }
                    case GOLD -> {
                        return GoldenSpearConfigObj.class;
                    }
                    case NETHERITE -> {
                        return NetheriteSpearConfigObj.class;
                    }
                }
            }
        }
        throw new Exception("Unknown type " + weaponType + " and " + tier);
    }
    @Test
    void configObjAdapterConfigTest(){
        var toolMaterials = ToolMaterials.values();
        var weaponTypes = WeaponTypesEnum.values();

        for(var type : weaponTypes){
            for(var tier : toolMaterials){
                try{
                    var configObjAdapter = adapterFactory.createObjectAdapterConfig(type, tier);
                    assertEquals(configObjAdapter.getClass(), getAdapterType(tier, type));
                }
                catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    @Test
    void configObjTest(){
        var toolMaterials = ToolMaterials.values();
        var weaponTypes = WeaponTypesEnum.values();

        for(var type : weaponTypes){
            for(var tier : toolMaterials){
                try{
                    var configObj = factory.createObjectConfig(type, tier);
                    var configObjLegacy = factory.createObjectConfig(type, tier);
                    assertEquals(configObj.getClass(), getConfigObjType(tier, type));
                    assertEquals(configObjLegacy.getClass(), getConfigObjType(tier, type));
                }
                catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
    @Test
    void configObjVsConfigAdapterTest(){
        var toolMaterials = ToolMaterials.values();
        var weaponTypes = WeaponTypesEnum.values();

        for(var type : weaponTypes){
            for(var tier : toolMaterials){
                try{
                    var configObj = factory.createObjectConfig(type, tier);
                    var configObjLegacy = factory.createObjectConfig(type, tier);
                    var configObjAdapter = adapterFactory.createObjectAdapterConfig(type, tier);

                    assertEquals(configObj.getClass(), configObjAdapter.getConfigObjClass());
                    assertEquals(configObjLegacy.getClass(), configObjAdapter.getConfigObjClass());
                }
                catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
}
