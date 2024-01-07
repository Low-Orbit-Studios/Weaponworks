package net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.katana;

import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.katana.WoodenKatanaConfigObj;

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
