package net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.mace;

import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.mace.NetheriteMaceConfigObj;

import java.lang.reflect.Constructor;

public class NetheriteMaceObjAdapterConfig extends WeaponConfigObjAdapterConfig<NetheriteMaceConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return NetheriteMaceConfigObj.class;
    }

    @Override
    public Constructor<NetheriteMaceConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return NetheriteMaceConfigObj.class.getConstructor(String.class);
    }
}
