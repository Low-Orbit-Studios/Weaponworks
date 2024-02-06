package net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.rapier;

import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.crazedaerialcable.weaponworks.config.objects.rapier.StoneRapierConfigObj;

import java.lang.reflect.Constructor;

public class StoneRapierObjAdapterConfig extends WeaponConfigObjAdapterConfig<StoneRapierConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return StoneRapierConfigObj.class;
    }

    @Override
    public Constructor<StoneRapierConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return StoneRapierConfigObj.class.getConstructor(String.class);
    }
}
