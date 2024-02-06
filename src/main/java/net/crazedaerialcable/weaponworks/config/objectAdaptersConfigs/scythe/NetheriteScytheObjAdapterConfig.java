package net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.scythe;

import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.crazedaerialcable.weaponworks.config.objects.scythe.NetheriteScytheConfigObj;

import java.lang.reflect.Constructor;

public class NetheriteScytheObjAdapterConfig extends WeaponConfigObjAdapterConfig<NetheriteScytheConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return NetheriteScytheConfigObj.class;
    }

    @Override
    public Constructor<NetheriteScytheConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return NetheriteScytheConfigObj.class.getConstructor(String.class);
    }
}
