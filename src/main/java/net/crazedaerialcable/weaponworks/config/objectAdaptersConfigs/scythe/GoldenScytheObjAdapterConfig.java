package net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.scythe;

import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.crazedaerialcable.weaponworks.config.objects.scythe.GoldenScytheConfigObj;

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
