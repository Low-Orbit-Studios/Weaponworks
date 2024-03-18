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

public class KnifeItem extends ThrowableWeaponItem {

    public KnifeItem(Tier tier, float velocity, int cooldown, Item.Properties properties) {
        super(tier, velocity, cooldown, properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        float velocity = 1.6f; // 1 is pretty low, 3 is really high.
        int cooldownTicks = 10;
        float innacuracy = 0.1F;
        ItemStack itemStack = player.getItemInHand(hand);

        if (itemStack.getDamageValue() < itemStack.getMaxDamage() && !level.isClientSide) {
            //We throw one item at a time - hence 1
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

}
