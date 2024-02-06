package net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.mace;

import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.crazedaerialcable.weaponworks.config.objects.mace.NetheriteMaceConfigObj;

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
