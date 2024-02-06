package net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.mace;

import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.crazedaerialcable.weaponworks.config.objects.mace.IronMaceConfigObj;

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
