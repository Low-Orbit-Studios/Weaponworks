package net.twomoonsstudios.moonsweaponry.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.twomoonsstudios.moonsweaponry.MoonsWeaponry;
import net.twomoonsstudios.moonsweaponry.config.objects.WeaponConfigObj;
import net.twomoonsstudios.moonsweaponry.enums.WeaponTypesEnum;
import net.twomoonsstudios.moonsweaponry.item.weapons.*;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

import static net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig.WEAPON_CONFIGS;
import static net.twomoonsstudios.moonsweaponry.constants.CommonConstants.TEMPLATE_PREFIX;
import static net.twomoonsstudios.moonsweaponry.constants.ThrownWeaponDataConstants.*;
import static net.twomoonsstudios.moonsweaponry.constants.RangedWeaponConstants.*;


public class ModItems {

    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MoonsWeaponry.MOD_ID);
    public static RegistryObject<Item> IRON_DAGGER = ITEMS.register(
            "iron_dagger",
            () -> new DaggerItem(
                    Tiers.IRON,
                    new ThrowableWeaponItem.ThrowableProperties()
                            .setThrowVelocity(DAGGER_DEFAULT_VELOCITY)
                            .setCooldown(DAGGER_DEFAULT_CD)
                            .setInaccuracy(DAGGER_DEFAULT_INACCURACY)
                            .setBaseDamage(IRON_DAGGER_DEFAULT_DMG)
                    ,
                    new Item.Properties()
                            .defaultDurability(IRON_DAGGER_DEFAULT_USES)
                            .tab(CreativeModeTab.TAB_COMBAT)
            )
    );
    public static RegistryObject<Item> GOLD_DAGGER = ITEMS.register(
            "gold_dagger",
            () -> new DaggerItem(
                    Tiers.GOLD,
                    new ThrowableWeaponItem.ThrowableProperties()
                            .setThrowVelocity(DAGGER_DEFAULT_VELOCITY)
                            .setCooldown(DAGGER_DEFAULT_CD)
                            .setInaccuracy(DAGGER_DEFAULT_INACCURACY)
                            .setBaseDamage(GOLD_DAGGER_DEFAULT_DMG)
                    ,
                    new Item.Properties()
                            .defaultDurability(GOLD_DAGGER_DEFAULT_USES)
                            .tab(CreativeModeTab.TAB_COMBAT)
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
                            WEAPONS_ITEMS.add(ITEMS.register(weaponId, () -> new GreatswordItem(weaponConfig)));
                        }
                        case HALBERD -> {
                            WEAPONS_ITEMS.add(ITEMS.register(weaponId, () -> new HalberdItem(weaponConfig)));
                        }
                        case HAMMER -> {
                            WEAPONS_ITEMS.add(ITEMS.register(weaponId, () -> new HammerItem(weaponConfig)));
                        }
                        case KATANA -> {
                            WEAPONS_ITEMS.add(ITEMS.register(weaponId, () -> new KatanaItem(weaponConfig)));
                        }
                        case RAPIER -> {
                            WEAPONS_ITEMS.add(ITEMS.register(weaponId, () -> new RapierItem(weaponConfig)));
                        }
                        case SCYTHE -> {
                            WEAPONS_ITEMS.add(ITEMS.register(weaponId, () -> new ScytheItem(weaponConfig)));
                        }
                        case WARGLAIVE -> {
                            WEAPONS_ITEMS.add(ITEMS.register(weaponId, () -> new WarglaiveItem(weaponConfig)));
                        }
                        case SPEAR -> {
                            WEAPONS_ITEMS.add(ITEMS.register(weaponId, () -> new SpearItem(weaponConfig)));
                        }
                        case MACE -> {
                            WEAPONS_ITEMS.add(ITEMS.register(weaponId, () -> new MaceItem(weaponConfig)));
                        }
                        default -> throw new Exception("Unknown weapon type to load: " + weaponId);
                    }
                }
            }
        }
        catch(Exception ex){
            MoonsWeaponry.getLogger().error("Failed to load weapons: " + ex.getMessage());
        }


        ITEMS.register(eventBus);
    }
}
