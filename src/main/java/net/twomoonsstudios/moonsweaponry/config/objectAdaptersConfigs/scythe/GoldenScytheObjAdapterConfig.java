package net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.scythe;

import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.scythe.GoldenScytheConfigObj;

import java.lang.reflect.Constructor;

public class GoldenScytheObjAdapterConfig extends WeaponConfigObjAdapterConfig<GoldenScytheConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return GoldenScytheConfigObj.class;
    }

    @Override
    public Constructor<GoldenScytheConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return GoldenScytheConfigObj.class.getConstructor(String.class);
    }
}
