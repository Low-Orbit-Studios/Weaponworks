package net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.warglaive;

import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.warglaive.GoldenWarglaiveConfigObj;

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
