package net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.scythe;

import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.scythe.WoodenScytheConfigObj;

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
