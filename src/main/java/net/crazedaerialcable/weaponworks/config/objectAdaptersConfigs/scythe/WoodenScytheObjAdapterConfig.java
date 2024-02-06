package net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.scythe;

import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.crazedaerialcable.weaponworks.config.objects.scythe.WoodenScytheConfigObj;

import java.lang.reflect.Constructor;

public class WoodenScytheObjAdapterConfig extends WeaponConfigObjAdapterConfig<WoodenScytheConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return WoodenScytheConfigObj.class;
    }

    @Override
    public Constructor<WoodenScytheConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return WoodenScytheConfigObj.class.getConstructor(String.class);
    }
}
