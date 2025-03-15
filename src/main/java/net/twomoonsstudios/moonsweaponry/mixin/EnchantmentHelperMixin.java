package net.twomoonsstudios.moonsweaponry.mixin;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.twomoonsstudios.moonsweaponry.item.ThrowableWeaponItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import java.util.Map;

@Mixin(EnchantmentHelper.class)
public abstract class EnchantmentHelperMixin {

    @Inject(method = "setEnchantments", at = @At("HEAD"), cancellable = true)
    private static void setEnchantments(Map<Enchantment, Integer> pEnchantmentsMap, ItemStack pStack, CallbackInfo ci) {
        if (pEnchantmentsMap.containsKey(Enchantments.UNBREAKING) && pStack.getItem() instanceof ThrowableWeaponItem) {
            pEnchantmentsMap.remove(Enchantments.UNBREAKING);
            if (pEnchantmentsMap.isEmpty()) {
                ci.cancel();
            }
        }
    }
}
