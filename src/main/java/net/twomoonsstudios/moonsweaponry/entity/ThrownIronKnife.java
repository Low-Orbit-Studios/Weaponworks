package net.twomoonsstudios.moonsweaponry.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.twomoonsstudios.moonsweaponry.item.ModItems;

public class ThrownIronKnife extends ThrownKnife{

    public ThrownIronKnife(EntityType<? extends ThrownKnife> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        usedItem = new ItemStack(ModItems.THROWING_KNIFE.get());
    }
    public ThrownIronKnife(Level level, LivingEntity entity, ItemStack stack) {
        super(WeaponworksEntities.THROWN_KNIFE_ENTITY_TYPE.get(), level, entity, stack);
    }

}
