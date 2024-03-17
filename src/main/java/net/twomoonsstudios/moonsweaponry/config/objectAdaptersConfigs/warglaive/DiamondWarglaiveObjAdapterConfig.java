package net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.warglaive;

import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.warglaive.DiamondWarglaiveConfigObj;

import java.lang.reflect.Constructor;

public class DiamondWarglaiveObjAdapterConfig extends WeaponConfigObjAdapterConfig<DiamondWarglaiveConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return DiamondWarglaiveConfigObj.class;
    }

    @Override
    public Constructor<DiamondWarglaiveConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return DiamondWarglaiveConfigObj.class.getConstructor(String.class);
    }
}
