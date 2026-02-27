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
import net.twomoonsstudios.moonsweaponry.item.weapons.*;
import net.twomoonsstudios.moonsweaponry.newConfig.ConfigHelper;

import java.util.*;


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
                int numberOfUses = Math.round(((Double) config.weaponworksConfig.materials.get(materialName + "Material").get("thrownUsesMultiplier")).floatValue() *
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
                String tierName = ((String) config.weaponworksConfig.materials.get(materialName + "Material").get("tierName")).toUpperCase();
                if (typeName.equals("dagger")) {
                    listOfItems.add(ITEMS.register(itemID, () -> new DaggerItem(Tiers.valueOf(tierName), throwableProperties, itemProperties)));
                }
                if (typeName.equals("javelin")) {
                    listOfItems.add(ITEMS.register(itemID, () -> new JavelinItem(Tiers.valueOf(tierName), throwableProperties, itemProperties)));
                }
                if (typeName.equals("hatchet")) {
                    listOfItems.add(ITEMS.register(itemID, () -> new HatchetItem(Tiers.valueOf(tierName), throwableProperties, itemProperties)));
                }
                if (typeName.equals("boomerang")) {
                    listOfItems.add(ITEMS.register(itemID, () -> new BoomerangItem(Tiers.valueOf(tierName), throwableProperties, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).defaultDurability(1))));
                }
                if (typeName.equals("shuriken")) {
                    listOfItems.add(ITEMS.register(itemID, () -> new ShurikenItem(Tiers.valueOf(tierName), throwableProperties, itemProperties)));
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

    public static RegistryObject<Item> THROWN_HANDLE =
            ITEMS.register(
                    "thrown_handle",
                    () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS))
            );

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

     static Map<String,Map<String,Object>> bowConfig = config.weaponworksConfig.bowConstants;
     static Map<String,Object> shortbowConfig = bowConfig.get("shortbow");
     static Map<String,Object> longbowConfig = bowConfig.get("longbow");
     public static RegistryObject<Item> LONGBOW = ITEMS.register("longbow", () -> new ModifiableBowItem(
             new ModifiableBowItem.BowProperties()
                     .setDrawDuration(config.convertToInt(longbowConfig.get("drawDuration")))
                     .setDamageBonus(((Double) longbowConfig.get("damageMultiplier")).floatValue())
                     .setInaccuracy(((Double) longbowConfig.get("inaccuracy")).floatValue())
                     .setMinVelocity(((Double) longbowConfig.get("minArrowVelocity")).floatValue())
                     .setMaxVelocity(((Double) longbowConfig.get("maxArrowVelocity")).floatValue()),
             new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)
                     .defaultDurability(config.convertToInt(longbowConfig.get("defaultDurability")))
     ));

    public static RegistryObject<Item> SHORTBOW = ITEMS.register("shortbow", () -> new ModifiableBowItem(
            new ModifiableBowItem.BowProperties()
                    .setDrawDuration(config.convertToInt(shortbowConfig.get("drawDuration")))
                    .setDamageBonus(((Double) shortbowConfig.get("damageMultiplier")).floatValue())
                    .setInaccuracy(((Double) shortbowConfig.get("inaccuracy")).floatValue())
                    .setMinVelocity(((Double) shortbowConfig.get("minArrowVelocity")).floatValue())
                    .setMaxVelocity(((Double) shortbowConfig.get("maxArrowVelocity")).floatValue()),
            new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)
                    .defaultDurability(config.convertToInt(shortbowConfig.get("defaultDurability")))
            )
    );

//    public static RegistryObject<Item> BOMB_CANNON = ITEMS.register(
//            "bomb_cannon", () -> new BombCannonItem(new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_COMBAT)
//            )
//    );

    public static void register(IEventBus eventBus){
        createThrownWeapons();

        createMeleeWeapons();
        
        ITEMS.register(eventBus);
    }
}
