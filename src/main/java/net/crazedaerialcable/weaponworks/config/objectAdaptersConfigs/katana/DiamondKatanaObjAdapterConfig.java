package net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.katana;

import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.crazedaerialcable.weaponworks.config.objects.katana.DiamondKatanaConfigObj;

import java.lang.reflect.Constructor;

public class DiamondKatanaObjAdapterConfig extends WeaponConfigObjAdapterConfig<DiamondKatanaConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return DiamondKatanaConfigObj.class;
    }

    @Override
    public Constructor<DiamondKatanaConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return DiamondKatanaConfigObj.class.getConstructor(String.class);
    }
}
