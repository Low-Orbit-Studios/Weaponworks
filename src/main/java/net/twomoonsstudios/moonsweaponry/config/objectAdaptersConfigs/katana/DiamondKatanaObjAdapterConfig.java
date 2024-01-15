package net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.katana;

import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.katana.DiamondKatanaConfigObj;

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
