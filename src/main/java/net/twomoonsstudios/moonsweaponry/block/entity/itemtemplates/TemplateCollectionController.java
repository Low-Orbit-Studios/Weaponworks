package net.twomoonsstudios.moonsweaponry.block.entity.itemtemplates;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;

import static net.twomoonsstudios.moonsweaponry.item.ModItems.*;

public class TemplateCollectionController {
    public static final TemplateCollectionController INSTANCE = new TemplateCollectionController();
    private ArrayList<RegistryObject<Item>> weaponTemplates = new ArrayList<>();
    private int currentTemplateIndex = 0;
    private TemplateCollectionController() {
    }
    /**
     * Returns the next template in the list of weapon templates.
     * If the current template is the last in the list, the first template is returned.
     * Increases internal counter, this should be used to get next template to be selected.
     * @return The next template in the list of weapon templates.
     */
    public Item getNextTemplate(){
        currentTemplateIndex++;
        if(currentTemplateIndex >= weaponTemplates.size()){
            currentTemplateIndex = 0;
        }
        return weaponTemplates.get(currentTemplateIndex).get();
    }
    /**
     * Returns the previous template in the list of weapon templates.
     * If the current template is the first in the list, the last template is returned.
     * Decreases internal counter, this should be used to get previous template to be selected.
     * @return The previous template in the list of weapon templates.
     */
    public Item getPreviousTemplate(){
        currentTemplateIndex--;
        if(currentTemplateIndex < 0){
            currentTemplateIndex = weaponTemplates.size() - 1;
        }
        return weaponTemplates.get(currentTemplateIndex).get();
    }
    /**
     * Returns the previous template in the list of weapon templates.
     * If the current template is the first in the list, the last template is returned.
     * Internal counter is not changed, this should be used to get preview of previous item.
     * @return The previous template in the list of weapon templates.
     */

    public Item getPreviousTemplateNoDecrement(){
        int prevIndex = currentTemplateIndex - 1;
        if(prevIndex < 0){
            prevIndex = weaponTemplates.size() - 1;
        }
        return weaponTemplates.get(prevIndex).get();
    }

    /**
     * Returns the next template in the list of weapon templates.
     * If the current template is the last in the list, the first template is returned.
     * Internal counter is not changed, this should be used to get preview of next item.
     * @return The next template in the list of weapon templates.
     */
    public Item getNextTemplateNoIncrement(){
        int nextIndex = currentTemplateIndex + 1;
        if(nextIndex >= weaponTemplates.size()){
            nextIndex = 0;
        }
        return weaponTemplates.get(nextIndex).get();
    }
    public Item getCurrentTemplate(){
        return weaponTemplates.get(currentTemplateIndex).get();
    }

    public void loadTemplates() {
        weaponTemplates.clear();
        weaponTemplates.add(GREATSWORD_TEMPLATE);
        weaponTemplates.add(SPEAR_TEMPLATE);
        weaponTemplates.add(WARGLAIVE_TEMPLATE);
        weaponTemplates.add(RAPIER_TEMPLATE);
        weaponTemplates.add(HALBERD_TEMPLATE);
        weaponTemplates.add(HAMMER_TEMPLATE);
        weaponTemplates.add(MACE_TEMPLATE);
        weaponTemplates.add(SCYTHE_TEMPLATE);
        weaponTemplates.add(KATANA_TEMPLATE);
    }
}
