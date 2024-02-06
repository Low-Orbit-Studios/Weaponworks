package net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.hammer;

import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.crazedaerialcable.weaponworks.config.objects.hammer.WoodenHammerConfigObj;

import java.lang.reflect.Constructor;

public class WoodenHammerObjAdapterConfig extends WeaponConfigObjAdapterConfig<WoodenHammerConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return WoodenHammerConfigObj.class;
    }

    @Override
    public Constructor<WoodenHammerConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return WoodenHammerConfigObj.class.getConstructor(String.class);
    }
}
