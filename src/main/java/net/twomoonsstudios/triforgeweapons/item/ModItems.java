package net.twomoonsstudios.triforgeweapons.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.twomoonsstudios.triforgeweapons.TriforgeWeapons;
import net.twomoonsstudios.triforgeweapons.constants.WeaponDataConstants;
import org.antlr.v4.runtime.BufferedTokenStream;

public class ModItems {
    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TriforgeWeapons.MOD_ID);

    public static final RegistryObject<Item> NETHERITE_HALBERD = ITEMS.register("netherite_halberd",
            () -> new TriforgeTieredWeapon(Tiers.NETHERITE
                    , WeaponDataConstants.NETHERITE_HALBERD_BASE_DMG
                    , WeaponDataConstants.HALBERD_BASE_ATK_SPD,
                    new Item.Properties().tab(ModCreativeModeTab.MOD_TAB)
            )
    );
    public static final RegistryObject<Item> DIAMOND_HALBERD = ITEMS.register("diamond_halberd",
            () -> new TriforgeTieredWeapon(Tiers.DIAMOND
                    , WeaponDataConstants.DIAMOND_HALBERD_BASE_DMG
                    , WeaponDataConstants.HALBERD_BASE_ATK_SPD,
                    new Item.Properties().tab(ModCreativeModeTab.MOD_TAB)
            )
    );
    public static final RegistryObject<Item> GOLD_HALBERD = ITEMS.register("golden_halberd",
            () -> new TriforgeTieredWeapon(Tiers.GOLD
                    , WeaponDataConstants.GOLD_HALBERD_BASE_DMG
                    , WeaponDataConstants.HALBERD_BASE_ATK_SPD,
                    new Item.Properties().tab(ModCreativeModeTab.MOD_TAB)
            )
    );
    public static final RegistryObject<Item> IRON_HALBERD = ITEMS.register("iron_halberd",
            () -> new TriforgeTieredWeapon(Tiers.IRON
                    , WeaponDataConstants.IRON_HALBERD_BASE_DMG
                    , WeaponDataConstants.HALBERD_BASE_ATK_SPD,
                    new Item.Properties().tab(ModCreativeModeTab.MOD_TAB)
            )
    );

    public static final RegistryObject<Item> NETHERITE_GREATSWORD = ITEMS.register("netherite_greatsword",
            () -> new TriforgeTieredWeapon(Tiers.NETHERITE
                    , WeaponDataConstants.NETHERITE_GREATSWORD_BASE_DMG
                    , WeaponDataConstants.GREATSWORD_BASE_ATK_SPD,
                    new Item.Properties().tab(ModCreativeModeTab.MOD_TAB)
            )
    );
    public static final RegistryObject<Item> DIAMOND_GREATSWORD = ITEMS.register("diamond_greatsword",
            () -> new TriforgeTieredWeapon(Tiers.DIAMOND
                    , WeaponDataConstants.DIAMOND_GREATSWORD_BASE_DMG
                    , WeaponDataConstants.GREATSWORD_BASE_ATK_SPD,
                    new Item.Properties().tab(ModCreativeModeTab.MOD_TAB)
            )
    );
    public static final RegistryObject<Item> GOLD_GREATSWORD = ITEMS.register("golden_greatsword",
            () -> new TriforgeTieredWeapon(Tiers.GOLD
                    , WeaponDataConstants.GOLD_GREATSWORD_BASE_DMG
                    , WeaponDataConstants.GREATSWORD_BASE_ATK_SPD,
                    new Item.Properties().tab(ModCreativeModeTab.MOD_TAB)
            )
    );
    public static final RegistryObject<Item> IRON_GREATSWORD = ITEMS.register("iron_greatsword",
            () -> new TriforgeTieredWeapon(Tiers.IRON
                    , WeaponDataConstants.IRON_GREATSWORD_BASE_DMG
                    , WeaponDataConstants.GREATSWORD_BASE_ATK_SPD,
                    new Item.Properties().tab(ModCreativeModeTab.MOD_TAB)
            )
    );

    public static final RegistryObject<Item> NETHERITE_HAMMER = ITEMS.register("netherite_hammer",
            () -> new TriforgeTieredWeapon(Tiers.NETHERITE
                    , WeaponDataConstants.NETHERITE_HAMMER_BASE_DMG
                    , WeaponDataConstants.HAMMER_BASE_ATK_SPD,
                    new Item.Properties().tab(ModCreativeModeTab.MOD_TAB)
            )
    );
    public static final RegistryObject<Item> DIAMOND_HAMMER = ITEMS.register("diamond_hammer",
            () -> new TriforgeTieredWeapon(Tiers.DIAMOND
                    , WeaponDataConstants.DIAMOND_HAMMER_BASE_DMG
                    , WeaponDataConstants.HAMMER_BASE_ATK_SPD,
                    new Item.Properties().tab(ModCreativeModeTab.MOD_TAB)
            )
    );
    public static final RegistryObject<Item> GOLD_HAMMER = ITEMS.register("golden_hammer",
            () -> new TriforgeTieredWeapon(Tiers.GOLD
                    , WeaponDataConstants.GOLD_HAMMER_BASE_DMG
                    , WeaponDataConstants.HAMMER_BASE_ATK_SPD,
                    new Item.Properties().tab(ModCreativeModeTab.MOD_TAB)
            )
    );
    public static final RegistryObject<Item> IRON_HAMMER = ITEMS.register("iron_hammer",
            () -> new TriforgeTieredWeapon(Tiers.IRON
                    , WeaponDataConstants.IRON_HAMMER_BASE_DMG
                    , WeaponDataConstants.HAMMER_BASE_ATK_SPD,
                    new Item.Properties().tab(ModCreativeModeTab.MOD_TAB)
            )
    );
    
    public static final RegistryObject<Item> NETHERITE_SCYTHE = ITEMS.register("netherite_scythe",
            () -> new TriforgeTieredWeapon(Tiers.NETHERITE
                    , WeaponDataConstants.NETHERITE_SCYTHE_BASE_DMG
                    , WeaponDataConstants.SCYTHE_BASE_ATK_SPD,
                    new Item.Properties().tab(ModCreativeModeTab.MOD_TAB)
            )
    );
    public static final RegistryObject<Item> DIAMOND_SCYTHE = ITEMS.register("diamond_scythe",
            () -> new TriforgeTieredWeapon(Tiers.DIAMOND
                    , WeaponDataConstants.DIAMOND_SCYTHE_BASE_DMG
                    , WeaponDataConstants.SCYTHE_BASE_ATK_SPD,
                    new Item.Properties().tab(ModCreativeModeTab.MOD_TAB)
            )
    );
    public static final RegistryObject<Item> GOLD_SCYTHE = ITEMS.register("golden_scythe",
            () -> new TriforgeTieredWeapon(Tiers.GOLD
                    , WeaponDataConstants.GOLD_SCYTHE_BASE_DMG
                    , WeaponDataConstants.SCYTHE_BASE_ATK_SPD,
                    new Item.Properties().tab(ModCreativeModeTab.MOD_TAB)
            )
    );
    public static final RegistryObject<Item> IRON_SCYTHE = ITEMS.register("iron_scythe",
            () -> new TriforgeTieredWeapon(Tiers.IRON
                    , WeaponDataConstants.IRON_SCYTHE_BASE_DMG
                    , WeaponDataConstants.SCYTHE_BASE_ATK_SPD,
                    new Item.Properties().tab(ModCreativeModeTab.MOD_TAB)
            )
    );
    
    public static final RegistryObject<Item> NETHERITE_WARGLAIVE = ITEMS.register("netherite_warglaive",
            () -> new TriforgeTieredWeapon(Tiers.NETHERITE
                    , WeaponDataConstants.NETHERITE_WARGLAIVE_BASE_DMG
                    , WeaponDataConstants.WARGLAIVE_BASE_ATK_SPD,
                    new Item.Properties().tab(ModCreativeModeTab.MOD_TAB)
            )
    );
    public static final RegistryObject<Item> DIAMOND_WARGLAIVE = ITEMS.register("diamond_warglaive",
            () -> new TriforgeTieredWeapon(Tiers.DIAMOND
                    , WeaponDataConstants.DIAMOND_WARGLAIVE_BASE_DMG
                    , WeaponDataConstants.WARGLAIVE_BASE_ATK_SPD,
                    new Item.Properties().tab(ModCreativeModeTab.MOD_TAB)
            )
    );
    public static final RegistryObject<Item> GOLD_WARGLAIVE = ITEMS.register("golden_warglaive",
            () -> new TriforgeTieredWeapon(Tiers.GOLD
                    , WeaponDataConstants.GOLD_WARGLAIVE_BASE_DMG
                    , WeaponDataConstants.WARGLAIVE_BASE_ATK_SPD,
                    new Item.Properties().tab(ModCreativeModeTab.MOD_TAB)
            )
    );
    public static final RegistryObject<Item> IRON_WARGLAIVE = ITEMS.register("iron_warglaive",
            () -> new TriforgeTieredWeapon(Tiers.IRON
                    , WeaponDataConstants.IRON_WARGLAIVE_BASE_DMG
                    , WeaponDataConstants.WARGLAIVE_BASE_ATK_SPD,
                    new Item.Properties().tab(ModCreativeModeTab.MOD_TAB)
            )
    );


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
