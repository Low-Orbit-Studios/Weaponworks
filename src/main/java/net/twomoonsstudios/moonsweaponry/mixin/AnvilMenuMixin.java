package net.twomoonsstudios.moonsweaponry.mixin;

import net.minecraft.nbt.ListTag;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.twomoonsstudios.moonsweaponry.MoonsWeaponry;
import net.twomoonsstudios.moonsweaponry.item.ThrowableWeaponItem;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(AnvilMenu.class)
public abstract class AnvilMenuMixin extends ItemCombinerMenu {

    @Shadow @Final private DataSlot cost;

    public AnvilMenuMixin(@Nullable MenuType<?> pType, int pContainerId, Inventory pPlayerInventory, ContainerLevelAccess pAccess) {
        super(pType, pContainerId, pPlayerInventory, pAccess);
    }

    @Inject(method = "createResult", at = @At("TAIL"), cancellable = true)
    public void createResult(CallbackInfo ci) {

        //it says you dont have to cast to object in IntelliJ but you totally do, mixin wiki said to and it crashes otherwise
        ItemStack leftInput = (this.inputSlots).getItem(0);
        ItemStack rightInput = (this.inputSlots).getItem(1);
        boolean rightInputUnbreaking = false;
        Map<Enchantment, Integer> enchMap = EnchantmentHelper.getEnchantments(rightInput);

        if (rightInput.getItem() instanceof EnchantedBookItem) {
            if (enchMap.containsKey(Enchantments.UNBREAKING)) {
                rightInputUnbreaking = (enchMap.get(Enchantments.UNBREAKING) != 0);
                if (rightInputUnbreaking && leftInput.getItem() instanceof ThrowableWeaponItem) {
                    this.resultSlots.setItem(0, ItemStack.EMPTY);
                    this.cost.set(0);
                    ci.cancel();
                }
            }
        }

        if (leftInput.getItem().isValidRepairItem(leftInput, rightInput)) {
            ItemStack output = leftInput.copy();
            output.setDamageValue(0);
            this.resultSlots.setItem(0, output);
        }
    }
}