package net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.scythe;

import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.crazedaerialcable.weaponworks.config.objects.scythe.DiamondScytheConfigObj;

import java.lang.reflect.Constructor;

public class DiamondScytheObjAdapterConfig extends WeaponConfigObjAdapterConfig<DiamondScytheConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return DiamondScytheConfigObj.class;
    }

    @Override
    public Constructor<DiamondScytheConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return DiamondScytheConfigObj.class.getConstructor(String.class);
    }
}
