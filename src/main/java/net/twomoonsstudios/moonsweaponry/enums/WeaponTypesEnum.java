package net.twomoonsstudios.moonsweaponry.enums;

import static net.twomoonsstudios.moonsweaponry.constants.CommonConstants.*;

public enum WeaponTypesEnum {
    GREATSWORD(GREATSWORD_BASE_ID),
    HALBERD(HALBERD_BASE_ID),
    HAMMER(HAMMER_BASE_ID),
    KATANA(KATANA_BASE_ID),
    RAPIER(RAPIER_BASE_ID),
    SCYTHE(SCYTHE_BASE_ID),
    WARGLAIVE(WARGLAIVE_BASE_ID),
    MACE(MACE_BASE_ID), SPEAR(SPEAR_BASE_ID);

    private String baseId;
    private WeaponTypesEnum(String baseId){
        this.baseId = baseId;
    }

    public String getBaseId(){
        return this.baseId;
    }
}
