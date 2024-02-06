package net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.warglaive;

import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.crazedaerialcable.weaponworks.config.objects.warglaive.NetheriteWarglaiveConfigObj;

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
