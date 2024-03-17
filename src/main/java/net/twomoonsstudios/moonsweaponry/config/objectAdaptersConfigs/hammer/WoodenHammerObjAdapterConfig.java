package net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.hammer;

import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.hammer.WoodenHammerConfigObj;

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
