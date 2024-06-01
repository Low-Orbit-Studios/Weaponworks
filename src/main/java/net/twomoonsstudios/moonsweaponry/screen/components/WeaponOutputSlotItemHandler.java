package net.twomoonsstudios.moonsweaponry.screen.components;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

public class WeaponOutputSlotItemHandler extends SlotItemHandler {
    public WeaponOutputSlotItemHandler(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
        super(itemHandler, index, xPosition, yPosition);
    }
    @Override
    public boolean mayPlace(@NotNull ItemStack stack) {
        return false;
    }
}
