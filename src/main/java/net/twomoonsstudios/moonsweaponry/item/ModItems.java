package net.twomoonsstudios.moonsweaponry.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.twomoonsstudios.moonsweaponry.MoonsWeaponry;
import net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig;
import net.twomoonsstudios.moonsweaponry.item.weapons.*;

import static net.twomoonsstudios.moonsweaponry.config.MoonsWeaponsConfig.*;

public class ModItems {
    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MoonsWeaponry.MOD_ID);

    public static RegistryObject<Item> THROWING_KNIFE = ITEMS.register("throwing_knife", () -> new KnifeItem(Tiers.IRON, new Item.Properties().defaultDurability(16).tab(CreativeModeTab.TAB_COMBAT)));

    public static void register(IEventBus eventBus){
        try{
            for (String id : MoonsWeaponsConfig.WEAPONS.keySet()) {
                var subId = id.substring(id.indexOf("_") + 1);
                switch (subId) {
                    case GREATSWORD_BASE_ID -> ITEMS.register(id, () -> new GreatswordItem(MoonsWeaponsConfig.WEAPONS.get(id)));
                    case HALBERD_BASE_ID -> ITEMS.register(id, () -> new HalberdItem(MoonsWeaponsConfig.WEAPONS.get(id)));
                    case HAMMER_BASE_ID -> ITEMS.register(id, () -> new HammerItem(MoonsWeaponsConfig.WEAPONS.get(id)));
                    case SCYTHE_BASE_ID -> ITEMS.register(id, () -> new ScytheItem(MoonsWeaponsConfig.WEAPONS.get(id)));
                    case WARGLAIVE_BASE_ID -> ITEMS.register(id, () -> new WarglaiveItem(MoonsWeaponsConfig.WEAPONS.get(id)));
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
