package net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.katana;

import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.katana.GoldenKatanaConfigObj;

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
