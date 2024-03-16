package net.twomoonsstudios.moonsweaponry.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.level.Level;
import net.twomoonsstudios.moonsweaponry.entity.ThrownKnife;

public class KnifeItem extends TieredItem {

    // TODO: Make this into a basic ThrownWeaponItem class
    public KnifeItem(Tier tier, Item.Properties properties) {
        super(tier, properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        float velocity = 1;
        ItemStack itemStack = player.getItemInHand(hand);
        if (itemStack.getDamageValue() < itemStack.getMaxDamage()) {
            if (!level.isClientSide) {
                ThrownKnife thrownKnife = new ThrownKnife(level, player, itemStack);
                thrownKnife.setOwner(player);
                thrownKnife.shootFromRotation(player, player.getXRot(), player.getYRot(), 0, velocity, 0);
                level.addFreshEntity(thrownKnife);
                player.getCooldowns().addCooldown(this, 20);
                if (!itemStack.hurt(1, null, null)) {
                    itemStack.hurt(1, null, null);
                };

            }
        }
        return super.use(level, player, hand);
    }

    @Override
    public int getBarColor(ItemStack pStack) {
        return 0x0e629e;
    }

    @Override
    public boolean isBarVisible(ItemStack pStack) {
        return true;
    }
}
