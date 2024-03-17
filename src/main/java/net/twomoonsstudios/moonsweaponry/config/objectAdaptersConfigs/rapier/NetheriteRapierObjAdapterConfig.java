package net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.rapier;

import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.rapier.NetheriteRapierConfigObj;

import java.lang.reflect.Constructor;

public class NetheriteRapierObjAdapterConfig extends WeaponConfigObjAdapterConfig<NetheriteRapierConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return NetheriteRapierConfigObj.class;
    }

    @Override
    public Constructor<NetheriteRapierConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return NetheriteRapierConfigObj.class.getConstructor(String.class);
    }
}
