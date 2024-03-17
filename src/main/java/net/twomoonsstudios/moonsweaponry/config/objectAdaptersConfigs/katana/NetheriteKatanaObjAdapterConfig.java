package net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.katana;

import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.katana.NetheriteKatanaConfigObj;

import java.lang.reflect.Constructor;

public class NetheriteKatanaObjAdapterConfig extends WeaponConfigObjAdapterConfig<NetheriteKatanaConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return NetheriteKatanaConfigObj.class;
    }

    @Override
    public Constructor<NetheriteKatanaConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return NetheriteKatanaConfigObj.class.getConstructor(String.class);
    }
}
