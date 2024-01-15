package net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.warglaive;

import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.warglaive.NetheriteWarglaiveConfigObj;

import java.lang.reflect.Constructor;

public class NetheriteWarglaiveObjAdapterConfig extends WeaponConfigObjAdapterConfig<NetheriteWarglaiveConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return NetheriteWarglaiveConfigObj.class;
    }

    @Override
    public Constructor<NetheriteWarglaiveConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return NetheriteWarglaiveConfigObj.class.getConstructor(String.class);
    }
}
