package net.twomoonsstudios.moonsweaponry.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ModCreativeModeTab {
    public static final CreativeModeTab MOD_TAB = new CreativeModeTab("moonsweaponrytab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.DIAMOND_SWORD);
        }
    };
}
