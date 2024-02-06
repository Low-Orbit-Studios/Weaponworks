package net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.rapier;

import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.crazedaerialcable.weaponworks.config.objects.rapier.IronRapierConfigObj;

import java.lang.reflect.Constructor;

public class IronRapierObjAdapterConfig extends WeaponConfigObjAdapterConfig<IronRapierConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return IronRapierConfigObj.class;
    }

    @Override
    public Constructor<IronRapierConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return IronRapierConfigObj.class.getConstructor(String.class);
    }
}
