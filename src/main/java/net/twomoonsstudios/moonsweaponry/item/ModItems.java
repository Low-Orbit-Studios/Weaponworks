package net.twomoonsstudios.moonsweaponry.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.twomoonsstudios.moonsweaponry.MoonsWeaponry;
import net.twomoonsstudios.moonsweaponry.config.objects.WeaponConfigObj;
import net.twomoonsstudios.moonsweaponry.enums.WeaponTypesEnum;
import net.twomoonsstudios.moonsweaponry.item.weapons.*;
import net.twomoonsstudios.moonsweaponry.newConfig.ConfigHelper;

import java.util.*;

import static net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig.WEAPON_CONFIGS;
import static net.twomoonsstudios.moonsweaponry.constants.CommonConstants.TEMPLATE_PREFIX;
import static net.twomoonsstudios.moonsweaponry.constants.RangedWeaponConstants.*;


public class ModItems {

    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MoonsWeaponry.MOD_ID);

    static ConfigHelper config = MoonsWeaponry.getConfigHelper();

    public static List<RegistryObject<Item>> createThrownWeapons() {
        List<RegistryObject<Item>> listOfItems = new ArrayList<>();
        LinkedHashSet<String> enabledMaterials = config.weaponworksConfig.enabledMaterials;
        LinkedHashSet<String> enabledThrownWeapons = config.weaponworksConfig.enabledThrownWeapons;
        for (String materialName : enabledMaterials) {
            for (String typeName : enabledThrownWeapons) {
                ThrowableWeaponItem.ThrowableProperties throwableProperties = getThrowableProperties(typeName, materialName);
                int numberOfUses = Math.round(((Double) config.weaponworksConfig.materials.get(materialName + "Material").get("thrownUsesMultiplier")).intValue() *
                        config.convertToInt(config.weaponworksConfig.thrownTypeConstants.get(typeName + "BaseConstants").get("defaultUses")));
                String itemID;
                if (materialName.equals("gold") || materialName.equals("wood")) {
                    itemID = materialName + "en_" + typeName;
                } else {
                    itemID = materialName + "_" + typeName;
                }
                Item.Properties itemProperties = new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).defaultDurability(numberOfUses);
                if ((Boolean) config.weaponworksConfig.materials.get(materialName + "Material").get("fireResistant")) {
                    itemProperties.fireResistant();
                }
                if (typeName.equals("dagger")) {
                    listOfItems.add(ITEMS.register(itemID, () -> new DaggerItem(Tiers.valueOf(materialName.toUpperCase()), throwableProperties, itemProperties)));
                }
                if (typeName.equals("javelin")) {
                    listOfItems.add(ITEMS.register(itemID, () -> new JavelinItem(Tiers.valueOf(materialName.toUpperCase()), throwableProperties, itemProperties)));
                }
                if (typeName.equals("hatchet")) {
                    listOfItems.add(ITEMS.register(itemID, () -> new HatchetItem(Tiers.valueOf(materialName.toUpperCase()), throwableProperties, itemProperties)));
                }
                if (typeName.equals("boomerang")) {
                    listOfItems.add(ITEMS.register(itemID, () -> new BoomerangItem(Tiers.valueOf(materialName.toUpperCase()), throwableProperties, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).defaultDurability(1))));
                }
                if (typeName.equals("shuriken")) {
                    listOfItems.add(ITEMS.register(itemID, () -> new ShurikenItem(Tiers.valueOf(materialName.toUpperCase()), throwableProperties, itemProperties)));
                }
            }
        }
        return listOfItems;
    }

    public static ThrowableWeaponItem.ThrowableProperties getThrowableProperties(String type, String material) {
        Map<String, Object> thisMaterialData = config.weaponworksConfig.materials.get(material + "Material");
        Map<String, Object> thisTypeData = config.weaponworksConfig.thrownTypeConstants.get(type + "BaseConstants");
        float throwVelocity = ((Double) thisTypeData.get("defaultVelocity")).floatValue();
        float inaccuracy = ((Double) thisTypeData.get("defaultInaccuracy")).floatValue();
        int cooldown = config.convertToInt(thisTypeData.get("defaultCooldown"));
        int baseDamage = config.convertToInt(thisTypeData.get("defaultDamage"));
        int baseDamageModifier = config.convertToInt(thisMaterialData.get("damageModifier"));
        return new ThrowableWeaponItem.ThrowableProperties()
                .setCooldown(cooldown)
                .setBaseDamage(baseDamage + baseDamageModifier)
                .setInaccuracy(inaccuracy)
                .setThrowVelocity(throwVelocity);
    };

    public static List<RegistryObject<Item>> createMeleeWeapons() {
        ArrayList<RegistryObject<Item>> itemsToAdd = new ArrayList<>();
        LinkedHashSet<String> enabledMaterials = config.weaponworksConfig.enabledMaterials;
        LinkedHashSet<String> enabledTypes = config.weaponworksConfig.enabledMeleeWeapons;
        for (String materialName : enabledMaterials) {
            for (String typeName : enabledTypes) {
                String itemID;
                if (materialName.equals("gold") || materialName.equals("wood")) {
                    itemID = materialName + "en_" + typeName;
                } else {
                    itemID = materialName + "_" + typeName;
                }
                Item.Properties itemProperties = new Item.Properties().tab(CreativeModeTab.TAB_COMBAT);
                itemProperties.defaultDurability(config.convertToInt(config.weaponworksConfig.materials.get(materialName+"Material").get("defaultDurability")));
                if ((Boolean) config.weaponworksConfig.materials.get(materialName + "Material").get("fireResistant")) {
                    itemProperties.fireResistant();
                }
                var typeBaseConfigs = config.weaponworksConfig.meleeTypeConstants.get(typeName + "BaseConstants");
                float attackSpeedModifier = ((Double) config.weaponworksConfig.meleeTypeConstants.get(typeName + "BaseConstants").get("defaultAttackSpeed")).floatValue();
                String itemTierName = (String) config.weaponworksConfig.materials.get(materialName + "Material").get("tierName");
                int weaponDamage = config.convertToInt(typeBaseConfigs.get("defaultDamage"))
                        + config.convertToInt(config.weaponworksConfig.materials.get(materialName + "Material").get("damageModifier"))
                        - (int) Tiers.valueOf(itemTierName).getAttackDamageBonus();
                itemsToAdd.add(ITEMS.register(itemID, () -> new SwordItem(Tiers.valueOf(itemTierName), weaponDamage, -(4.0f - attackSpeedModifier), itemProperties)));
            }
        }
        return itemsToAdd;
    }

     public static RegistryObject<Item> BOMB =
            ITEMS.register(
                    "bomb",
                    () -> new BombItem(
                            Tiers.IRON,
                            new ThrowableWeaponItem.ThrowableProperties()
                                    .setThrowVelocity(1.5f)
                                    .setCooldown(40)
                                    .setInaccuracy(0.5f)
                                    .setBaseDamage(0)
                            ,
                            new Item.Properties()
                                    .tab(CreativeModeTab.TAB_COMBAT)
                                    .stacksTo(16)
                    )
            );


    /**Stores references to proper weapon items, excluding templates used in crafting stations.*/
    public static LinkedList<RegistryObject<Item>> WEAPONS_ITEMS = new LinkedList<>();

    public static RegistryObject<Item> LONGBOW = ITEMS.register(
            "longbow", () -> new ModifiableBowItem(
                    new ModifiableBowItem.BowProperties()
                            .setDrawDuration(LONGBOW_DEFAULT_DRAW_DURATION)
                            .setMinVelocity(LONGBOW_DEFAULT_MIN_VELOCITY)
                            .setMaxVelocity(LONGBOW_DEFAULT_MAX_VELOCITY)
                            .setInaccuracy(LONGBOW_DEFAULT_INNACURACY)
                            .setDamageBonus(LONGBOW_DEFAULT_DAMAGE_MULTIPLIER),
                    new Item.Properties()
                            .defaultDurability(LONGBOW_DEFAULT_DURABILITY)
                            .tab(CreativeModeTab.TAB_COMBAT)
            )
    );

    public static RegistryObject<Item> SHORTBOW = ITEMS.register(
            "shortbow", () -> new ModifiableBowItem(
                    new ModifiableBowItem.BowProperties()
                            .setDrawDuration(SHORTBOW_DEFAULT_DRAW_DURATION)
                            .setMinVelocity(SHORTBOW_DEFAULT_MIN_VELOCITY)
                            .setMaxVelocity(SHORTBOW_DEFAULT_MAX_VELOCITY)
                            .setInaccuracy(SHORTBOW_DEFAULT_INNACURACY)
                            .setDamageBonus(SHORTBOW_DEFAULT_DAMAGE_MULTIPLIER),
                    new Item.Properties()
                            .defaultDurability(SHORTBOW_DEFAULT_DURABILITY)
                            .tab(CreativeModeTab.TAB_COMBAT)
            )
    );

    public static RegistryObject<Item> BOMB_CANNON = ITEMS.register(
            "bomb_cannon", () -> new BombCannonItem(new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_COMBAT)
            )
    );

    //Templates are used in weapon station to show the user what are they about to make.
    public static RegistryObject<Item> GREATSWORD_TEMPLATE = ITEMS.register(
            TEMPLATE_PREFIX + WeaponTypesEnum.GREATSWORD.getBaseId(),
            () -> new Item(
                    new Item.Properties()
                            .tab(CreativeModeTab.TAB_COMBAT)
            )
    );
    public static RegistryObject<Item> SPEAR_TEMPLATE = ITEMS.register(
            TEMPLATE_PREFIX + WeaponTypesEnum.SPEAR.getBaseId(),
            () -> new Item(
                    new Item.Properties()
                            .tab(CreativeModeTab.TAB_COMBAT)
            )
    );
    public static RegistryObject<Item> WARGLAIVE_TEMPLATE = ITEMS.register(
            TEMPLATE_PREFIX + WeaponTypesEnum.WARGLAIVE.getBaseId(),
            () -> new Item(
                    new Item.Properties()
                            .tab(CreativeModeTab.TAB_COMBAT)
            )
    );
    public static RegistryObject<Item> RAPIER_TEMPLATE = ITEMS.register(
            TEMPLATE_PREFIX + WeaponTypesEnum.RAPIER.getBaseId(),
            () -> new Item(
                    new Item.Properties()
                            .tab(CreativeModeTab.TAB_COMBAT)
            )
    );
    public static RegistryObject<Item> HALBERD_TEMPLATE = ITEMS.register(
            TEMPLATE_PREFIX + WeaponTypesEnum.HALBERD.getBaseId(),
            () -> new Item(
                    new Item.Properties()
                            .tab(CreativeModeTab.TAB_COMBAT)
            )
    );
    public static RegistryObject<Item> HAMMER_TEMPLATE = ITEMS.register(
            TEMPLATE_PREFIX + WeaponTypesEnum.HAMMER.getBaseId(),
            () -> new Item(
                    new Item.Properties()
                            .tab(CreativeModeTab.TAB_COMBAT)
            )
    );
    public static RegistryObject<Item> MACE_TEMPLATE = ITEMS.register(
            TEMPLATE_PREFIX + WeaponTypesEnum.MACE.getBaseId(),
            () -> new Item(
                    new Item.Properties()
                            .tab(CreativeModeTab.TAB_COMBAT)
            )
    );
     //ITEMS.register(weaponId, () -> new GreatswordItem(weaponConfig));
    public static RegistryObject<Item> SCYTHE_TEMPLATE = ITEMS.register(
            TEMPLATE_PREFIX + WeaponTypesEnum.SCYTHE.getBaseId(),
            () -> new Item(
                    new Item.Properties()
                            .tab(CreativeModeTab.TAB_COMBAT)
            )
    );
    public static RegistryObject<Item> KATANA_TEMPLATE = ITEMS.register(
            TEMPLATE_PREFIX + WeaponTypesEnum.KATANA.getBaseId(),
            () -> new Item(
                    new Item.Properties()
                            .tab(CreativeModeTab.TAB_COMBAT)
            )
    );

    //TODO create the templates. You can make dummy config objects for them that have data hardcoded.
    /**
     * Sorts the items before they are registered in the game, making sure they are always
     * added in correct, default material minecraft order.
     * @return Sorted items, accordingly to tier declarations in minecraft.*/
    public static Map<WeaponTypesEnum, Map<Tiers, WeaponConfigObj>> sortItems(){
        var itemsToRegister = new LinkedHashMap<WeaponTypesEnum, Map<Tiers, WeaponConfigObj>>();
        for(var weaponType : WEAPON_CONFIGS.keySet()){
            var sortedWeaponTypeItems = new LinkedHashMap<Tiers, WeaponConfigObj>();
            var weaponTypeItems = WEAPON_CONFIGS.get(weaponType);
            for(var tier : Tiers.values()){
                if(weaponTypeItems.containsKey(tier)){
                    var itemConfig = weaponTypeItems.get(tier);
                    sortedWeaponTypeItems.put(tier, itemConfig);
                }
            }
            itemsToRegister.put(weaponType, sortedWeaponTypeItems);
        }
        return itemsToRegister;
    }

    public static void register(IEventBus eventBus){
//        try{
//            var weaponConfigs = sortItems();
//            var weaponConfigTypes = weaponConfigs.keySet();
//            for (var weaponType : weaponConfigTypes) {
//                var weaponCategory = weaponConfigs.get(weaponType);
//
//                for (var entry : weaponCategory.entrySet()) {
//                    WeaponConfigObj weaponConfig = entry.getValue();
//                    var weaponId = weaponConfig.getConfigObjId();
//                    switch (weaponType) {
//
//                        case GREATSWORD -> {
//                            WEAPONS_ITEMS.add(ITEMS.register(weaponId, () -> new GreatswordItem(weaponConfig)));
//                        }
//                        case HALBERD -> {
//                            WEAPONS_ITEMS.add(ITEMS.register(weaponId, () -> new HalberdItem(weaponConfig)));
//                        }
//                        case HAMMER -> {
//                            WEAPONS_ITEMS.add(ITEMS.register(weaponId, () -> new HammerItem(weaponConfig)));
//                        }
//                        case KATANA -> {
//                            WEAPONS_ITEMS.add(ITEMS.register(weaponId, () -> new KatanaItem(weaponConfig)));
//                        }
//                        case RAPIER -> {
//                            WEAPONS_ITEMS.add(ITEMS.register(weaponId, () -> new RapierItem(weaponConfig)));
//                        }
//                        case SCYTHE -> {
//                            WEAPONS_ITEMS.add(ITEMS.register(weaponId, () -> new ScytheItem(weaponConfig)));
//                        }
//                        case WARGLAIVE -> {
//                            WEAPONS_ITEMS.add(ITEMS.register(weaponId, () -> new WarglaiveItem(weaponConfig)));
//                        }
//                        case SPEAR -> {
//                            WEAPONS_ITEMS.add(ITEMS.register(weaponId, () -> new SpearItem(weaponConfig)));
//                        }
//                        case MACE -> {
//                            WEAPONS_ITEMS.add(ITEMS.register(weaponId, () -> new MaceItem(weaponConfig)));
//                        }
//                        default -> throw new Exception("Unknown weapon type to load: " + weaponId);
//                    }
//                }
//            }
//        }
//        catch(Exception ex){
//            MoonsWeaponry.getLogger().error("Failed to load weapons: " + ex.getMessage());
//        }

        createThrownWeapons();

        createMeleeWeapons();
        
        ITEMS.register(eventBus);
    }
}
