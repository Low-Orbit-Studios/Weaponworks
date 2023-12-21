package net.twomoonsstudios.moonsweaponry.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.twomoonsstudios.moonsweaponry.MoonsWeaponry;
import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;
import net.twomoonsstudios.moonsweaponry.constants.CommonConstants;
import net.twomoonsstudios.moonsweaponry.item.weapons.*;

import static net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig.*;

public class ModItems {
    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MoonsWeaponry.MOD_ID);

    public static void register(IEventBus eventBus){
        try{
            for (String id : MoonsWeaponsConfig.WEAPONS.keySet()) {
                var subId = id.substring(id.indexOf("_") + 1);
                switch (subId) {
                    case CommonConstants.GREATSWORD_BASE_ID -> ITEMS.register(id, () -> new GreatswordItem(WEAPONS.get(id)));
                    case CommonConstants.HALBERD_BASE_ID -> ITEMS.register(id, () -> new HalberdItem(WEAPONS.get(id)));
                    case CommonConstants.HAMMER_BASE_ID -> ITEMS.register(id, () -> new HammerItem(WEAPONS.get(id)));
                    case CommonConstants.SCYTHE_BASE_ID -> ITEMS.register(id, () -> new ScytheItem(WEAPONS.get(id)));
                    case CommonConstants.WARGLAIVE_BASE_ID -> ITEMS.register(id, () -> new WarglaiveItem(WEAPONS.get(id)));
                    case CommonConstants.RAPIER_BASE_ID -> ITEMS.register(id, () ->new RapierItem(WEAPONS.get(id)));
                    case CommonConstants.KATANA_BASE_ID -> ITEMS.register(id, ()->new KatanaItem(WEAPONS.get(id)));
                    default -> throw new Exception("Unknown weapon type to load: " + subId);
                }
            }
        }
        catch(Exception ex){
            MoonsWeaponry.getLogger().error("Failed to load weapons: " + ex.getMessage());
        }


        ITEMS.register(eventBus);
    }
}
