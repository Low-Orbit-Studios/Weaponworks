package net.twomoonsstudios.moonsweaponry.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.world.entity.player.Inventory;
import net.twomoonsstudios.moonsweaponry.MoonsWeaponry;

import static net.twomoonsstudios.moonsweaponry.constants.BlockEntityMenuConstants.WEAPON_STATION_INVENTORY_HEIGHT;
import static net.twomoonsstudios.moonsweaponry.constants.BlockEntityMenuConstants.WEAPON_STATION_INVENTORY_LABEL_HEIGHT;

public class WeaponStationScreen extends AbstractContainerScreen<WeaponStationMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(MoonsWeaponry.MOD_ID, "textures/gui/weapon_station_craft_gui.png");
    private WeaponStationMenu weaponStationMenu;
    public WeaponStationScreen(WeaponStationMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
        weaponStationMenu = pMenu;
        imageHeight = WEAPON_STATION_INVENTORY_HEIGHT;
        this.inventoryLabelY = imageHeight - WEAPON_STATION_INVENTORY_LABEL_HEIGHT;
    }

    @Override
    protected void renderBg(PoseStack pPoseStack, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        this.blit(pPoseStack, x, y, 0, 0, imageWidth, imageHeight);
    }

    @Override
    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        renderBackground(pPoseStack);
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        renderTooltip(pPoseStack, pMouseX, pMouseY);
    }
    @Override
    public boolean mouseScrolled(double pMouseX, double pMouseY, double pDelta){
        pDelta = Math.floor(pDelta);
        weaponStationMenu.changeWeaponTemplate((int) pDelta);
        return true;
    }
}
