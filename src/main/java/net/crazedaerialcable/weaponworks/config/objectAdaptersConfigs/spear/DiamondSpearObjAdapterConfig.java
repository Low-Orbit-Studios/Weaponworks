package net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.spear;

import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.crazedaerialcable.weaponworks.config.objects.spear.DiamondSpearConfigObj;

import java.lang.reflect.Constructor;

public class DiamondSpearObjAdapterConfig extends WeaponConfigObjAdapterConfig<DiamondSpearConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return DiamondSpearConfigObj.class;
    }

    @Override
    public Constructor<DiamondSpearConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return DiamondSpearConfigObj.class.getConstructor(String.class);
    }
}
