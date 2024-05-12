package net.twomoonsstudios.moonsweaponry.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.twomoonsstudios.moonsweaponry.MoonsWeaponry;
import net.twomoonsstudios.moonsweaponry.block.custom.WeaponStationBlock;
import net.twomoonsstudios.moonsweaponry.item.ModItems;

import java.util.function.Supplier;

import static net.twomoonsstudios.moonsweaponry.constants.CommonConstants.WEAPON_STATION_ID;

public class ModBlocks {
    public final static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MoonsWeaponry.MOD_ID);

    public final static RegistryObject<Block> WEAPON_STATION = registerBlock(
            WEAPON_STATION_ID,
            () -> new WeaponStationBlock(BlockBehaviour.Properties.of(Material.HEAVY_METAL)
                    .strength(6f).requiresCorrectToolForDrops().noOcclusion()
            ), CreativeModeTab.TAB_DECORATIONS
    );

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
