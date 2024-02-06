package net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.scythe;

import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.crazedaerialcable.weaponworks.config.objects.scythe.IronScytheConfigObj;

import java.lang.reflect.Constructor;

public class IronScytheObjAdapterConfig extends WeaponConfigObjAdapterConfig<IronScytheConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return IronScytheConfigObj.class;
    }

    @Override
    public Constructor<IronScytheConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return IronScytheConfigObj.class.getConstructor(String.class);
    }
}
