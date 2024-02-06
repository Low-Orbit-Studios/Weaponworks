package net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.spear;

import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.crazedaerialcable.weaponworks.config.objects.spear.GoldenSpearConfigObj;

import java.lang.reflect.Constructor;

public class GoldenSpearObjAdapterConfig extends WeaponConfigObjAdapterConfig<GoldenSpearConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return GoldenSpearConfigObj.class;
    }

    @Override
    public Constructor<GoldenSpearConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return GoldenSpearConfigObj.class.getConstructor(String.class);
    }
}
