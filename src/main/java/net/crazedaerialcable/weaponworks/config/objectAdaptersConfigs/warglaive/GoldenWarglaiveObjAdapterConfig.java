package net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.warglaive;

import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.crazedaerialcable.weaponworks.config.objects.warglaive.GoldenWarglaiveConfigObj;

import java.lang.reflect.Constructor;

public class GoldenWarglaiveObjAdapterConfig extends WeaponConfigObjAdapterConfig<GoldenWarglaiveConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return GoldenWarglaiveConfigObj.class;
    }

    @Override
    public Constructor<GoldenWarglaiveConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return GoldenWarglaiveConfigObj.class.getConstructor(String.class);
    }
}
