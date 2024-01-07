package net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.rapier;

import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.rapier.WoodenRapierConfigObj;

import java.lang.reflect.Constructor;

public class WoodenRapierObjAdapterConfig extends WeaponConfigObjAdapterConfig<WoodenRapierConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return WoodenRapierConfigObj.class;
    }

    @Override
    public Constructor<WoodenRapierConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return WoodenRapierConfigObj.class.getConstructor(String.class);
    }
}
