package net.twomoonsstudios.moonsweaponry.recipe;

import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.twomoonsstudios.moonsweaponry.MoonsWeaponry;
import net.twomoonsstudios.moonsweaponry.constants.BlockEntityMenuConstants;
import net.twomoonsstudios.moonsweaponry.enums.WeaponTypesEnum;
import org.jetbrains.annotations.Nullable;

import java.nio.charset.StandardCharsets;

import static net.twomoonsstudios.moonsweaponry.constants.BlockEntityMenuConstants.*;
import static net.twomoonsstudios.moonsweaponry.constants.RecipeConstants.*;

public class WeaponStationRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    private final ItemStack output;
    private final NonNullList<Ingredient> recipeItems;

    public WeaponStationRecipe(ResourceLocation id, ItemStack output, NonNullList<Ingredient> recipeItems){
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
    }

    @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
        if(pLevel.isClientSide()){
            return false;
        }
        var materialFromRecipe = recipeItems.get(WEAPON_STATION_MATERIAL_INPUT_ID);
        var handleFromRecipe = recipeItems.get(WEAPON_STATION_HANDLE_INPUT_ID);
        var weaponTemplateFromRecipe = recipeItems.get(WEAPON_STATION_SELECTION_INPUT_ID);

        //Compare the item at <index> of the recipe with the item at <index> slot.
        return materialFromRecipe.test(pContainer.getItem(WEAPON_STATION_MATERIAL_INPUT_ID))
                && handleFromRecipe.test(pContainer.getItem(WEAPON_STATION_HANDLE_INPUT_ID))
                && weaponTemplateFromRecipe.test(pContainer.getItem(WEAPON_STATION_SELECTION_INPUT_ID));
    }

    @Override
    public ItemStack assemble(SimpleContainer pContainer) {
        return output;
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem() {
        return output.copy();
    }
    public ItemStack getIngredient(int index){
        return getIngredient(index);
    }
    public int getIngredientAmount(int index){
        return getIngredient(index).getCount();
    }
    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<WeaponStationRecipe>{
        public static final Type INSTANCE = new Type();
        public static final String ID = WEAPON_STATION_RECIPE_TYPE_ID;
        private Type() {}

    }
    //Recipe synchronization and reading
    public static class Serializer implements RecipeSerializer<WeaponStationRecipe>{
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID = new ResourceLocation(MoonsWeaponry.MOD_ID, WEAPON_STATION_RECIPE_TYPE_ID);

        @Override
        public WeaponStationRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
            var ingredients = GsonHelper.getAsJsonArray(pSerializedRecipe, RECIPE_INGREDIENTS_KEYWORD);
            //TODO this is crashing because too many inputs. WeaponType is not an input. It is a string, not an ingredient.
            var inputs = NonNullList.withSize(BlockEntityMenuConstants.WEAPON_STATION_INPUT_SLOTS_TOTAL, Ingredient.EMPTY);
            var output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, RECIPE_OUTPUT_KEYWORD));

            for(int i = 0; i < inputs.size(); i++){
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new WeaponStationRecipe(pRecipeId, output, inputs);
        }
        //Data order:
        //Ingredients size
        //Ingredients
        //Output
        @Override
        public @Nullable WeaponStationRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
           var inputs = NonNullList.withSize(pBuffer.readInt(), Ingredient.EMPTY);

            for(int i = 0; i < inputs.size(); i++){
                inputs.set(i, Ingredient.fromNetwork(pBuffer));
            }

            var output = pBuffer.readItem();

            return new WeaponStationRecipe(pRecipeId, output, inputs);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, WeaponStationRecipe pRecipe) {
            var ingredients = pRecipe.getIngredients();
            pBuffer.writeInt(ingredients.size());

            for(var ingredient : ingredients){
                ingredient.toNetwork(pBuffer);
            }

            pBuffer.writeItemStack(pRecipe.getResultItem(), false);
        }
    }
}
//TODO https://youtu.be/uP3jfKrWgro?list=PLKGarocXCE1HrC60yuTNTGRoZc6hf5Uvl&t=610
