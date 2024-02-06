package net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.warglaive;

import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.crazedaerialcable.weaponworks.config.objects.warglaive.DiamondWarglaiveConfigObj;

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
