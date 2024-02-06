package net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.mace;

import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.crazedaerialcable.weaponworks.config.objects.mace.DiamondMaceConfigObj;

import java.lang.reflect.Constructor;

public class DiamondMaceObjAdapterConfig extends WeaponConfigObjAdapterConfig<DiamondMaceConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return DiamondMaceConfigObj.class;
    }

    @Override
    public Constructor<DiamondMaceConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return DiamondMaceConfigObj.class.getConstructor(String.class);
    }
}
