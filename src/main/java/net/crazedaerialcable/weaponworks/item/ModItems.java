package net.crazedaerialcable.weaponworks.item;

import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.Identifier;
import net.crazedaerialcable.weaponworks.Weaponworks;
import net.crazedaerialcable.weaponworks.config.objects.WeaponConfigObj;
import net.crazedaerialcable.weaponworks.enums.WeaponTypesEnum;
import net.crazedaerialcable.weaponworks.item.weapons.*;

import java.util.*;

import static net.crazedaerialcable.weaponworks.config.WeaponworksConfig.*;

public class ModItems {
    public static final List<Item> WEAPONS = new ArrayList<>();
    /**An additional implementation allowing for retrieval of a weapon basing on its ID
     * with constant time.*/
    public static final HashMap<Identifier, Item> WEAPONS_MAP = new HashMap<>();
    /**
     * Sorts the items before they are registered in the game, making sure they are always
     * added in correct, default material minecraft order.
     * @return Sorted items, accordingly to tier declarations in minecraft.*/
    public static Map<WeaponTypesEnum, Map<ToolMaterials, WeaponConfigObj>> sortItems(){
        var itemsToRegister = new LinkedHashMap<WeaponTypesEnum, Map<ToolMaterials, WeaponConfigObj>>();
        for(var weaponType : WEAPON_CONFIGS.keySet()){
            var sortedWeaponTypeItems = new LinkedHashMap<ToolMaterials, WeaponConfigObj>();
            var weaponTypeItems = WEAPON_CONFIGS.get(weaponType);
            for(var tier : ToolMaterials.values()){
                if(weaponTypeItems.containsKey(tier)){
                    var itemConfig = weaponTypeItems.get(tier);
                    sortedWeaponTypeItems.put(tier, itemConfig);
                }
            }
            itemsToRegister.put(weaponType, sortedWeaponTypeItems);
        }

        return itemsToRegister;
    }
    private static Item registerItem(String name, Item item){
        var itemIdentifier = new Identifier(Weaponworks.MOD_ID, name);

        WEAPONS.add(item);
        WEAPONS_MAP.put(itemIdentifier, item);
        return Registry.register(Registry.ITEM, itemIdentifier, item);
    }

    public static void registerModItems(){
        Weaponworks.LOGGER.info("Registering Mod Items for " + Weaponworks.MOD_ID);
        try{
            var weaponConfigs = sortItems();
            var weaponConfigTypes = weaponConfigs.keySet();
            for (var weaponType : weaponConfigTypes) {
                var weaponCategory = weaponConfigs.get(weaponType);

                for (var entry : weaponCategory.entrySet()) {
                    WeaponConfigObj weaponConfig = entry.getValue();
                    var weaponId = weaponConfig.getConfigObjId();
                    switch (weaponType) {

                        case GREATSWORD -> {
                            registerItem(weaponId, new GreatswordItem(weaponConfig));
                        }
                        case HALBERD -> {
                            registerItem(weaponId, new HalberdItem(weaponConfig));
                        }
                        case HAMMER -> {
                            registerItem(weaponId, new HammerItem(weaponConfig));
                        }
                        case KATANA -> {
                            registerItem(weaponId, new KatanaItem(weaponConfig));
                        }
                        case RAPIER -> {
                            registerItem(weaponId, new RapierItem(weaponConfig));
                        }
                        case SCYTHE -> {
                            registerItem(weaponId, new ScytheItem(weaponConfig));
                        }
                        case WARGLAIVE -> {
                            registerItem(weaponId, new WarglaiveItem(weaponConfig));
                        }
                        case SPEAR -> {
                            registerItem(weaponId, new SpearItem(weaponConfig));
                        }
                        case MACE -> {
                            registerItem(weaponId, new MaceItem(weaponConfig));
                        }
                        default -> throw new Exception("Unknown weapon type to load: " + weaponId);
                    }
                }
            }
        }
        catch(Exception ex){
            Weaponworks.LOGGER.error("Failed to load weapons: " + ex.getMessage());
        }

    }
}
