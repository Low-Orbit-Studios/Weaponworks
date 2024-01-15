package net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.spear;

import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.spear.WoodenSpearConfigObj;

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
