package net.twomoonsstudios.moonsweaponry.item;

import net.minecraft.server.level.ServerPlayer;
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
        float velocity = 1.6f; // 1 is pretty low, 3 is really high.
        int cooldownTicks = 10;
        float innacuracy = 0.1F;
        ItemStack itemStack = player.getItemInHand(hand);

        if (itemStack.getDamageValue() < itemStack.getMaxDamage() && !level.isClientSide) {
            itemStack.hurt(1, null, null);
            ThrownKnife thrownKnife = new ThrownKnife(level, player, itemStack);
            thrownKnife.setOwner(player);
            //for easier debugging.
            var playerXRot = player.getXRot();
            var playerYRot = player.getYRot();
            thrownKnife.shootFromRotation(player, playerXRot, playerYRot, 0, velocity, innacuracy);
            level.addFreshEntity(thrownKnife);
            player.getCooldowns().addCooldown(this, cooldownTicks);
        }
        return super.use(level, player, hand);
    }

    // makes the bar blue
    @Override
    public int getBarColor(ItemStack pStack) {
        return 0x0e629e;
    }

    @Override
    public boolean isBarVisible(ItemStack pStack) {
        return true;
    }
}
