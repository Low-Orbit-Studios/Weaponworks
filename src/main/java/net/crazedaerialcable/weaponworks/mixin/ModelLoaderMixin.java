package net.crazedaerialcable.weaponworks.mixin;

import net.crazedaerialcable.weaponworks.Weaponworks;
import net.crazedaerialcable.weaponworks.item.ModItems;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.render.model.ModelLoader;
import net.minecraft.client.render.model.json.JsonUnbakedModel;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Map;

import static net.crazedaerialcable.weaponworks.constants.CommonConstants.HANDHELD_MODEL_SUFFIX;

@Mixin(ModelLoader.class)
public abstract class ModelLoaderMixin {
    @Shadow
    protected abstract void addModel(ModelIdentifier modelId);

    @Inject(method = "<init>"
            , at = @At(value = "INVOKE"
                , target = "Lnet/minecraft/client/render/model/ModelLoader;addModel(Lnet/minecraft/client/util/ModelIdentifier;)V"
                , ordinal = 3
                , shift = At.Shift.AFTER)
    )
    public void addWeapon(BlockColors blockColors, Profiler profiler, Map<Identifier, JsonUnbakedModel> jsonUnbakedModels, Map<Identifier, List<ModelLoader.SourceTrackedData>> blockStates, CallbackInfo ci){

        var weapons = ModItems.WEAPONS;
        for(var weapon : weapons){
            var weaponId = Registries.ITEM.getId(weapon).getPath();

            this.addModel(new ModelIdentifier(Weaponworks.MOD_ID, weaponId + HANDHELD_MODEL_SUFFIX, "inventory"));
        }
    }
}
