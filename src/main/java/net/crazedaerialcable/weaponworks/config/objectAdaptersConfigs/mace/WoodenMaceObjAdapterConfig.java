package net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.mace;

import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.crazedaerialcable.weaponworks.config.objects.mace.WoodenMaceConfigObj;

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
