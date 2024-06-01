package net.twomoonsstudios.moonsweaponry.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeHolder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.twomoonsstudios.moonsweaponry.block.custom.WeaponStationBlock;
import net.twomoonsstudios.moonsweaponry.block.entity.itemtemplates.TemplateCollectionController;
import net.twomoonsstudios.moonsweaponry.recipe.WeaponStationRecipe;
import net.twomoonsstudios.moonsweaponry.screen.WeaponStationMenu;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static net.twomoonsstudios.moonsweaponry.constants.BlockEntityMenuConstants.*;

public class WeaponStationBlockEntity extends BlockEntity implements MenuProvider {
    protected static final String INVENTORY_NBT_NAME = "inventory";
    private Recipe selectedRecipe;
    private int selectedRecipeId = 0;
    private TemplateCollectionController templateCollectionController = TemplateCollectionController.INSTANCE;
    private final ItemStackHandler itemHandler = new ItemStackHandler(WEAPON_STATION_SLOTS_TOTAL){
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };
    protected final ContainerData data;
    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    public WeaponStationBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.WEAPON_STATION.get(), pPos, pBlockState);
        //Used for syncing between server and client.
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch(pIndex){
                    case 0 -> WeaponStationBlockEntity.this.selectedRecipeId;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch(pIndex){
                    case 0 -> WeaponStationBlockEntity.this.selectedRecipeId = pValue;
                };
            }

            @Override
            public int getCount() {
                return EXTRA_DATA_SYNCED_PARAMS_COUNT;//HAS TO MATCH SIMPLECONTAINERDATA DATA IN WeaponStationMenu!!
            }
        };
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Weapons Station");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new WeaponStationMenu(pContainerId, pPlayerInventory, this, this.data);
    }

    public ItemStack getSelectedTemplate(){
        return templateCollectionController.getCurrentTemplate().getDefaultInstance();
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == ForgeCapabilities.ITEM_HANDLER){
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag nbt) {
        nbt.put(INVENTORY_NBT_NAME, itemHandler.serializeNBT());

        super.saveAdditional(nbt);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        itemHandler.deserializeNBT(nbt.getCompound(INVENTORY_NBT_NAME));
    }

    public void drops(){
        var inventory = new SimpleContainer(itemHandler.getSlots());
        for(int i = 0; i < itemHandler.getSlots(); i++){
            if(i == WEAPON_STATION_SELECTION_INPUT_ID){
                continue; //We do NOT want to drop the templates.
            }
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    private void craftItem(WeaponStationBlockEntity entity){
        var level = entity.level;
        var inventory = new SimpleContainer(this.itemHandler.getSlots());
        for(int i = 0; i < this.itemHandler.getSlots(); i++){
            inventory.setItem(i, this.itemHandler.getStackInSlot(i));
        }
        var recipe = level.getRecipeManager().getRecipeFor(WeaponStationRecipe.Type.INSTANCE,
                inventory,
                level
        );

        var recipePresent = recipe.isPresent();
        if(hasRecipe(entity)){
            itemHandler.extractItem(WEAPON_STATION_MATERIAL_INPUT_ID, recipe.get().getIngredientAmount(WEAPON_STATION_MATERIAL_INPUT_ID), false);
            itemHandler.extractItem(WEAPON_STATION_HANDLE_INPUT_ID, recipe.get().getIngredientAmount(WEAPON_STATION_HANDLE_INPUT_ID), false);

            itemHandler.setStackInSlot(WEAPON_STATION_CRAFTING_OUTPUT_ID, new ItemStack(recipe.get().getResultItem().getItem()));
        }
    }
    public static void tick(Level level, BlockPos blockPos, BlockState blockState, WeaponStationBlockEntity entity) {
        if(level.isClientSide()) {
        }
    }

    private boolean hasRecipe(WeaponStationBlockEntity entity){
        var level = entity.level;
        var inventory = new SimpleContainer(this.itemHandler.getSlots());
        for(int i = 0; i < this.itemHandler.getSlots(); i++){
            inventory.setItem(i, this.itemHandler.getStackInSlot(i));
        }

        var materialInputSlotItem = this.itemHandler.getStackInSlot(WEAPON_STATION_MATERIAL_INPUT_ID).getItem();
        var handleInputSlotItem = this.itemHandler.getStackInSlot(WEAPON_STATION_HANDLE_INPUT_ID).getItem();

        if(materialInputSlotItem.equals(Items.AIR) || handleInputSlotItem.equals(Items.AIR)){
            return false;
        }

        var recipe = level.getRecipeManager().getRecipeFor(WeaponStationRecipe.Type.INSTANCE,
                inventory,
                level
        );

        var recipePresent = recipe.isPresent();
        return recipePresent && canInsertIntoCraftingOutputSlot(inventory);
    }

    private boolean canInsertIntoCraftingOutputSlot(SimpleContainer inventory){
        return inventory.getItem(WEAPON_STATION_CRAFTING_OUTPUT_ID).equals(ItemStack.EMPTY);
    }

    public ItemStack getNextTemplatePreview() {
        return templateCollectionController.getNextTemplateNoIncrement().getDefaultInstance();
    }
    public ItemStack getPreviousTemplatePreview() {
        return templateCollectionController.getPreviousTemplateNoDecrement().getDefaultInstance();
    }

    public ItemStack selectNextTemplate() {
        return templateCollectionController.getNextTemplate().getDefaultInstance();
    }

    public ItemStack selectPreviousTemplate() {
        return templateCollectionController.getPreviousTemplate().getDefaultInstance();
    }
}
//TODO: https://www.youtube.com/watch?v=jo0BTisGpJk&list=PLKGarocXCE1HrC60yuTNTGRoZc6hf5Uvl&t=824s
//Slot IDs:
//0: material
//1: handle
//2: weapon type
//3: craft result
