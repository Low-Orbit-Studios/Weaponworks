package net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.rapier;

import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.rapier.GoldenRapierConfigObj;

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
