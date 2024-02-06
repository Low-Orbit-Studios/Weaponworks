package net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.rapier;

import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.crazedaerialcable.weaponworks.config.objects.rapier.DiamondRapierConfigObj;

import java.lang.reflect.Constructor;

public class DiamondRapierObjAdapterConfig extends WeaponConfigObjAdapterConfig<DiamondRapierConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return DiamondRapierConfigObj.class;
    }

    @Override
    public Constructor<DiamondRapierConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return DiamondRapierConfigObj.class.getConstructor(String.class);
    }
}
