package net.crazedaerialcable.weaponworks.mixin;

import net.crazedaerialcable.weaponworks.Weaponworks;
import net.crazedaerialcable.weaponworks.item.ModItems;
import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.data.client.Model;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.DefaultedRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import static net.crazedaerialcable.weaponworks.constants.CommonConstants.HANDHELD_MODEL_SUFFIX;

@Mixin(ItemRenderer.class)
public class ItemRendererMixin {
    @ModifyVariable(method = "renderItem", at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel useCustomWeaponModel(BakedModel value
           , ItemStack stack
           , ModelTransformationMode renderMode
           , boolean leftHanded
           , MatrixStack matrices
           , VertexConsumerProvider vertexConsumers
           , int light
           , int overlay
           ){
        var weapons = ModItems.WEAPONS;

        for(var weapon : weapons){
            if(stack.isOf(weapon)){
                if(isHandheld(renderMode)){
                    var weaponId = Registries.ITEM.getId(weapon).getPath();
                    return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(Weaponworks.MOD_ID, weaponId + HANDHELD_MODEL_SUFFIX, "inventory"));
                }
            }
        }

        return value;
    }
    private boolean isHandheld(ModelTransformationMode renderMode){
        return renderMode == ModelTransformationMode.FIRST_PERSON_LEFT_HAND
                || renderMode == ModelTransformationMode.FIRST_PERSON_RIGHT_HAND
                || renderMode == ModelTransformationMode.THIRD_PERSON_LEFT_HAND
                || renderMode == ModelTransformationMode.THIRD_PERSON_RIGHT_HAND;
    }
}
