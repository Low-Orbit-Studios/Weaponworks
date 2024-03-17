package net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.scythe;

import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.scythe.NetheriteScytheConfigObj;

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
