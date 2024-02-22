package net.crazedaerialcable.weaponworks.mixin;

import net.crazedaerialcable.weaponworks.Weaponworks;
import net.crazedaerialcable.weaponworks.item.ModItems;
import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.data.client.Model;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.registry.Registry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import static net.crazedaerialcable.weaponworks.constants.CommonConstants.HANDHELD_MODEL_SUFFIX;

@Mixin(ItemRenderer.class)
public class ItemRendererMixin {
    @ModifyVariable(method = "renderItem", at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel useCustomWeaponModel(BakedModel value
           , ItemStack stack
           , ModelTransformation.Mode renderMode
           , boolean leftHanded
           , MatrixStack matrices
           , VertexConsumerProvider vertexConsumers
           , int light
           , int overlay
           ){

        var stackIdentifier = Registry.ITEM.getId(stack.getItem());

        var weapon = ModItems.WEAPONS_MAP.get(stackIdentifier);
        if(weapon != null){
            if(isHandheld(renderMode)){
                var weaponId = stackIdentifier.getPath();
                return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(Weaponworks.MOD_ID, weaponId + HANDHELD_MODEL_SUFFIX, "inventory"));
            }
        }

        return value;
    }
    private boolean isHandheld(ModelTransformation.Mode renderMode){
        return renderMode == ModelTransformation.Mode.FIRST_PERSON_LEFT_HAND
                || renderMode == ModelTransformation.Mode.FIRST_PERSON_RIGHT_HAND
                || renderMode == ModelTransformation.Mode.THIRD_PERSON_LEFT_HAND
                || renderMode == ModelTransformation.Mode.THIRD_PERSON_RIGHT_HAND;
    }
}
