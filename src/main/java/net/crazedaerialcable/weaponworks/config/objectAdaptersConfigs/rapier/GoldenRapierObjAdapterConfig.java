package net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.rapier;

import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.crazedaerialcable.weaponworks.config.objects.rapier.GoldenRapierConfigObj;

import java.lang.reflect.Constructor;

public class GoldenRapierObjAdapterConfig extends WeaponConfigObjAdapterConfig<GoldenRapierConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return GoldenRapierConfigObj.class;
    }

    @Override
    public Constructor<GoldenRapierConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return GoldenRapierConfigObj.class.getConstructor(String.class);
    }
}
