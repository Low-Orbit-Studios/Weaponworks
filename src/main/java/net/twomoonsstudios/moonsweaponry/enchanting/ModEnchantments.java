package net.twomoonsstudios.moonsweaponry.enchanting;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.twomoonsstudios.moonsweaponry.MoonsWeaponry;

import static net.twomoonsstudios.moonsweaponry.constants.EnchantmentConstants.CAPACITY_ENCHANTMENT_ID;
import static net.twomoonsstudios.moonsweaponry.constants.EnchantmentConstants.VELOCITY_ENCHANTMENT_ID;

public class ModEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, MoonsWeaponry.MOD_ID);

    public static final RegistryObject<WeaponworksEnchantment> VELOCITY_ENCHANTMENT = ENCHANTMENTS.register(VELOCITY_ENCHANTMENT_ID,
            () -> new VelocityEnchantment(Enchantment.Rarity.UNCOMMON, EquipmentSlot.MAINHAND));
    public static final RegistryObject<WeaponworksEnchantment> CAPACITY_ENCHANTMENT = ENCHANTMENTS.register(CAPACITY_ENCHANTMENT_ID,
            () -> new CapacityEnchantment(Enchantment.Rarity.UNCOMMON, EquipmentSlot.MAINHAND));
    public static void register(IEventBus eventBus){
        ENCHANTMENTS.register(eventBus);
    }
}
