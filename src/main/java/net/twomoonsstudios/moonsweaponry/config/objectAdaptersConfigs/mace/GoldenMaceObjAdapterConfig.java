package net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.mace;

import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.mace.GoldenMaceConfigObj;

import java.lang.reflect.Constructor;

public class GoldenMaceObjAdapterConfig extends WeaponConfigObjAdapterConfig<GoldenMaceConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return GoldenMaceConfigObj.class;
    }

    @Override
    public Constructor<GoldenMaceConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return GoldenMaceConfigObj.class.getConstructor(String.class);
    }
}
