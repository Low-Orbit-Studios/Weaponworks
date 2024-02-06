package net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.rapier;

import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.crazedaerialcable.weaponworks.config.objects.rapier.NetheriteRapierConfigObj;

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
