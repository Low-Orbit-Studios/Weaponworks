package net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.rapier;

import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.rapier.DiamondRapierConfigObj;

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
