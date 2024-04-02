package net.twomoonsstudios.moonsweaponry.constants;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.world.item.Tiers;
import net.twomoonsstudios.moonsweaponry.MoonsWeaponry;

public class TextureConstants {
    public static final ResourceLocation IRON_KNIFE_TEX = new ResourceLocation(MoonsWeaponry.MOD_ID, "textures/item/throwing_knife.png");

    public static ResourceLocation getKnifeTexture(Tiers tier){
        switch (tier) {
            case WOOD -> {
            }
            case STONE -> {
            }
            case IRON -> {
                return IRON_KNIFE_TEX;
            }
            case DIAMOND -> {
            }
            case GOLD -> {
            }
            case NETHERITE -> {
            }
        }
        return null;
    }
}
