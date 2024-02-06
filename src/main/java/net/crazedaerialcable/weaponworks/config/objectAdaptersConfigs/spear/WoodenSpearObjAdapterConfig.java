package net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.spear;

import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.crazedaerialcable.weaponworks.config.objects.spear.WoodenSpearConfigObj;

import java.lang.reflect.Constructor;

public class WoodenSpearObjAdapterConfig extends WeaponConfigObjAdapterConfig<WoodenSpearConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return WoodenSpearConfigObj.class;
    }

    @Override
    public Constructor<WoodenSpearConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return WoodenSpearConfigObj.class.getConstructor(String.class);
    }
}
