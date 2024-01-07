package net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.mace;

import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.mace.WoodenMaceConfigObj;

import java.lang.reflect.Constructor;

public class WoodenMaceObjAdapterConfig extends WeaponConfigObjAdapterConfig<WoodenMaceConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return WoodenMaceConfigObj.class;
    }

    @Override
    public Constructor<WoodenMaceConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return WoodenMaceConfigObj.class.getConstructor(String.class);
    }
}
