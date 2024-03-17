package net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.rapier;

import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.rapier.IronRapierConfigObj;

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
