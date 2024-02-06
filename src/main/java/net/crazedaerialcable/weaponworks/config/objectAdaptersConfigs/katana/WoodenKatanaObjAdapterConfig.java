package net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.katana;

import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.crazedaerialcable.weaponworks.config.objects.katana.WoodenKatanaConfigObj;

import java.lang.reflect.Constructor;

public class WoodenKatanaObjAdapterConfig extends WeaponConfigObjAdapterConfig<WoodenKatanaConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return WoodenKatanaConfigObj.class;
    }

    @Override
    public Constructor<WoodenKatanaConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return WoodenKatanaConfigObj.class.getConstructor(String.class);
    }
}
