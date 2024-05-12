package net.twomoonsstudios.moonsweaponry.constants;

public class BlockEntityMenuConstants {
    public static final int EXTRA_DATA_SYNCED_PARAMS_COUNT = 1;

    public static final int WEAPON_STATION_MATERIAL_INPUT_ID = 0;
    public static final int WEAPON_STATION_HANDLE_INPUT_ID = 1;
    public static final int WEAPON_STATION_CRAFTING_OUTPUT_ID = 2;

    public static final int WEAPON_STATION_INPUT_SLOTS_TOTAL = 2;
    public static final int WEAPON_STATION_OUTPUT_SLOTS_TOTAL = 1;
    public static final int WEAPON_STATION_SLOTS_TOTAL = WEAPON_STATION_INPUT_SLOTS_TOTAL + WEAPON_STATION_OUTPUT_SLOTS_TOTAL;


    // CREDIT GOES TO: diesieben07 | https://github.com/diesieben07/SevenCommons
    // must assign a slot number to each of the slots used by the GUI.
    // For this container, we can see both the tile inventory's slots as well as the player inventory slots and the hotbar.
    // Each time we add a Slot to the container, it automatically increases the slotIndex, which means
    //  0 - 8 = hotbar slots (which will map to the InventoryPlayer slot numbers 0 - 8)
    //  9 - 35 = player inventory slots (which map to the InventoryPlayer slot numbers 9 - 35)
    //  36 - 44 = TileInventory slots, which map to our TileEntity slot numbers 0 - 8)
    public static final int HOTBAR_SLOT_COUNT = 9;
    public static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    public static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    public static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    public static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    public static final int VANILLA_FIRST_SLOT_INDEX = 0;
    public static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;
    // THIS YOU HAVE TO DEFINE!
    public static final int TE_INVENTORY_SLOT_COUNT = WEAPON_STATION_SLOTS_TOTAL;  // must be the number of slots you have!

    //The weapon station is higher by 16 pixels than regular inventory pane.
    public static final int WEAPON_STATION_HEIGHT_ADDITION = 16;
    //166 is default height. +16 to add more space for labels on top and bottom of the menu (the name of station and "Inventory" label)
    public static final int WEAPON_STATION_INVENTORY_HEIGHT = 166 + WEAPON_STATION_HEIGHT_ADDITION;
    //By default the label sits at WEAPON_STATION_INVENTORY_HEIGHT - 94.
    public static final int WEAPON_STATION_INVENTORY_LABEL_HEIGHT = 94;

    public static final int WEAPON_STATION_CRAFT_MATERIAL_IN_X = 24;
    public static final int WEAPON_STATION_CRAFT_MATERIAL_IN_Y = 25;
    public static final int WEAPON_STATION_CRAFT_HANDLE_IN_X = 24;
    public static final int WEAPON_STATION_CRAFT_HANDLE_IN_Y = 64;
    public static final int WEAPON_STATION_CRAFT_OUTPUT_X = 136;
    public static final int WEAPON_STATION_CRAFT_OUTPUT_Y = 44;
}
