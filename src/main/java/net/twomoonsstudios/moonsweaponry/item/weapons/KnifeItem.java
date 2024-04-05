package net.twomoonsstudios.moonsweaponry.item.weapons;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.twomoonsstudios.moonsweaponry.entity.AbstractThrowable;
import net.twomoonsstudios.moonsweaponry.entity.ThrownKnifeEntity;
import net.twomoonsstudios.moonsweaponry.entity.thrownKnife.ThrownIronKnifeEntity;
import net.twomoonsstudios.moonsweaponry.item.ThrowableWeaponItem;

public class KnifeItem extends ThrowableWeaponItem {

    public KnifeItem(Tier tier, float velocity, int cooldown, float inaccuracy, Item.Properties properties) {
        super(tier, velocity, cooldown, inaccuracy, properties);
    }
    @Override
    protected AbstractThrowable createThrownEntity(Level level, Player player, ItemStack itemStack, float initialVelocity){
        return new ThrownIronKnifeEntity(level, player, itemStack, initialVelocity);
    }
}
