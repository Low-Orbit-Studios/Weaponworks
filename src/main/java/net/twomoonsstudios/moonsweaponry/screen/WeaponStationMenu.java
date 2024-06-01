package net.twomoonsstudios.moonsweaponry.screen;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.items.SlotItemHandler;
import net.twomoonsstudios.moonsweaponry.block.ModBlocks;
import net.twomoonsstudios.moonsweaponry.block.entity.WeaponStationBlockEntity;
import net.twomoonsstudios.moonsweaponry.screen.components.WeaponOutputSlotItemHandler;
import net.twomoonsstudios.moonsweaponry.screen.components.WeaponSelectionSlotItemHandler;
import org.jetbrains.annotations.Nullable;

import static net.twomoonsstudios.moonsweaponry.constants.BlockEntityMenuConstants.*;
import static net.twomoonsstudios.moonsweaponry.screen.ModMenuTypes.WEAPON_STATION_MENU;

public class WeaponStationMenu extends AbstractContainerMenu {
    public final WeaponStationBlockEntity blockEntity;
    private final Level level;
    private final ContainerData containerData;

    private final Container inputSlots = new SimpleContainer(WEAPON_STATION_INPUT_SLOTS_TOTAL);
    private final Container craftingOutputSlot = new ResultContainer();
    private final Container repairOutputSlot = new ResultContainer();
    protected final Player player;


    public WeaponStationMenu(int pContainerId, Inventory pPlayerInventory, FriendlyByteBuf extraData) {
        this(pContainerId,
                pPlayerInventory,
                pPlayerInventory.player.level.getBlockEntity(extraData.readBlockPos()),
                new SimpleContainerData(EXTRA_DATA_SYNCED_PARAMS_COUNT
                ));
    }

    public WeaponStationMenu(int pContainerId, Inventory inv, BlockEntity entity, ContainerData data){
        super(WEAPON_STATION_MENU.get(), pContainerId);
        checkContainerSize(inv, WEAPON_STATION_SLOTS_TOTAL);

        this.player = inv.player;
        this.level = this.player.level;
        this.blockEntity = (WeaponStationBlockEntity) entity;
        this.containerData = data;

        var defaultSelectedTemplate = this.blockEntity.getSelectedTemplate();

        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        this.blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(handler -> {
                var weaponSelectionSlotHandler =new WeaponSelectionSlotItemHandler(handler, WEAPON_STATION_SELECTION_INPUT_ID, WEAPON_STATION_WEAPON_TYPE_SEL_X, WEAPON_STATION_WEAPON_TYPE_SEL_Y);
                weaponSelectionSlotHandler.set(defaultSelectedTemplate);

                this.addSlot(new SlotItemHandler(handler, WEAPON_STATION_MATERIAL_INPUT_ID, WEAPON_STATION_CRAFT_MATERIAL_IN_X, WEAPON_STATION_CRAFT_MATERIAL_IN_Y));
                this.addSlot(new SlotItemHandler(handler, WEAPON_STATION_HANDLE_INPUT_ID, WEAPON_STATION_CRAFT_HANDLE_IN_X, WEAPON_STATION_CRAFT_HANDLE_IN_Y));
                this.addSlot(weaponSelectionSlotHandler);
                this.addSlot(new WeaponOutputSlotItemHandler(handler, WEAPON_STATION_CRAFTING_OUTPUT_ID, WEAPON_STATION_CRAFT_OUTPUT_X, WEAPON_STATION_CRAFT_OUTPUT_Y) {
            });
        });

        addDataSlots(this.containerData);
    }
    private void selectDefaultSelectionSlotItem(){

    }

    protected void addPlayerInventory(Inventory pPlayerInventory){
        var slotHeight = 86 + WEAPON_STATION_HEIGHT_ADDITION;//84 is by default + 2 for offset to align fields.
        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(pPlayerInventory, j + i * 9 + 9, 8 + j * 18, slotHeight + i * 18));
            }
        }
    }
    protected void addPlayerHotbar(Inventory pPlayerInventory){
        var slotHeight = 144 + WEAPON_STATION_HEIGHT_ADDITION;//142 is by default + 2 for offset to align fields..
        for(int k = 0; k < 9; ++k) {
            this.addSlot(new Slot(pPlayerInventory, k, 8 + k * 18, slotHeight));
        }
    }

    protected boolean mayPickup(Player pPlayer, boolean pHasStack) {
        return false;
    }

    protected void onTake(Player player, ItemStack item) {
        //TODO get currently chosen recipe here to shrink the stacks
        item.onCraftedBy(player.level, player, item.getCount());
//        this.resultSlots.awardUsedRecipes(player);
//        this.shrinkStackInSlot()
    }

    protected boolean isValidBlock(BlockState pState) {
        return false;
    }

    public void createResult() {

    }

    @Override
    public ItemStack quickMoveStack(Player playerIn, int index) {
        Slot sourceSlot = slots.get(index);
        if (sourceSlot == null || !sourceSlot.hasItem()) return ItemStack.EMPTY;  //EMPTY_ITEM

        if(sourceSlot.index == WEAPON_STATION_SELECTION_INPUT_ID){
            return ItemStack.EMPTY;//We do not allow modifications to the weapon type selection slot.
        }

        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        // Check if the slot clicked is one of the vanilla container slots
        if (index < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
            // This is a vanilla container slot so merge the stack into the tile inventory
            if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX, TE_INVENTORY_FIRST_SLOT_INDEX
                    + TE_INVENTORY_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;  // EMPTY_ITEM
            }
        } else if (index < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT) {
            // This is a TE slot so merge the stack into the players inventory
            if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            System.out.println("Invalid slotIndex:" + index);
            return ItemStack.EMPTY;
        }
        // If stack size == 0 (the entire stack was moved) set slot contents to null
        if (sourceStack.getCount() == 0) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }
        sourceSlot.onTake(playerIn, sourceStack);
        return copyOfSourceStack;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, ModBlocks.WEAPON_STATION.get());
    }

    public void changeWeaponTemplate(int pDelta) {
        var direction = pDelta > 0 ? 1 : -1;//1 for next, -1 for previous
        var pDeltaAbs = Math.abs(pDelta);
        for(int i = 0; i < pDeltaAbs; i++){
            ItemStack nextItem = null;
            if(direction > 0){
                nextItem = blockEntity.selectNextTemplate();
            }else{
                nextItem = blockEntity.selectPreviousTemplate();
            }
            var itemHandler = this.blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER);
            final ItemStack finalNextItem = nextItem.copy();
            itemHandler.ifPresent(handler -> {
                handler.extractItem(WEAPON_STATION_SELECTION_INPUT_ID, 1, false);
                handler.insertItem(WEAPON_STATION_SELECTION_INPUT_ID, finalNextItem, false);
            });
        }
    }
}
