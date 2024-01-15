package net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.mace;

import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.mace.IronMaceConfigObj;

import java.lang.reflect.Constructor;

public class IronMaceObjAdapterConfig extends WeaponConfigObjAdapterConfig<IronMaceConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return IronMaceConfigObj.class;
    }

    @Override
    public Constructor<IronMaceConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return IronMaceConfigObj.class.getConstructor(String.class);
    }
}
