package net.twomoonsstudios.moonsweaponry.entity.thrownKnife;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.twomoonsstudios.moonsweaponry.constants.TextureConstants;
import net.twomoonsstudios.moonsweaponry.entity.ThrownKnifeEntity;
import net.twomoonsstudios.moonsweaponry.entity.WeaponworksEntities;
import net.twomoonsstudios.moonsweaponry.item.ModItems;
import org.jetbrains.annotations.NotNull;

public class ThrownIronKnifeEntity extends ThrownKnifeEntity {

    public ThrownIronKnifeEntity(EntityType<? extends ThrownKnifeEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        usedItem = new ItemStack(ModItems.THROWING_KNIFE.get());
    }
    public ThrownIronKnifeEntity(Level level, LivingEntity entity, ItemStack stack) {
        super(WeaponworksEntities.THROWN_IRON_KNIFE_ENTITY_TYPE.get(), level, entity, stack);
        throwableTexture = TextureConstants.IRON_KNIFE_TEX;
    }
    @Override
    protected @NotNull ItemStack getPickupItem() {
        return new ItemStack(ModItems.THROWING_KNIFE.get());
    }
}
