package net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.rapier;

import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.crazedaerialcable.weaponworks.config.objects.rapier.WoodenRapierConfigObj;

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
