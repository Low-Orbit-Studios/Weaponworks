package net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.katana;

import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.crazedaerialcable.weaponworks.config.objects.katana.GoldenKatanaConfigObj;

import java.lang.reflect.Constructor;

public class GoldenKatanaObjAdapterConfig extends WeaponConfigObjAdapterConfig<GoldenKatanaConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return GoldenKatanaConfigObj.class;
    }

    @Override
    public Constructor<GoldenKatanaConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return GoldenKatanaConfigObj.class.getConstructor(String.class);
    }
}
