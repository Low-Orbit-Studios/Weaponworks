package net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.warglaive;

import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.crazedaerialcable.weaponworks.config.objects.warglaive.WoodenWarglaiveConfigObj;

import java.lang.reflect.Constructor;

public class WoodenWarglaiveObjAdapterConfig extends WeaponConfigObjAdapterConfig<WoodenWarglaiveConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return WoodenWarglaiveConfigObj.class;
    }

    @Override
    public Constructor<WoodenWarglaiveConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return WoodenWarglaiveConfigObj.class.getConstructor(String.class);
    }
}
