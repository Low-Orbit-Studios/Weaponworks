package net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.scythe;

import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.crazedaerialcable.weaponworks.config.objects.scythe.StoneScytheConfigObj;

import java.lang.reflect.Constructor;

public class StoneScytheObjAdapterConfig extends WeaponConfigObjAdapterConfig<StoneScytheConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return StoneScytheConfigObj.class;
    }

    @Override
    public Constructor<StoneScytheConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return StoneScytheConfigObj.class.getConstructor(String.class);
    }
}
