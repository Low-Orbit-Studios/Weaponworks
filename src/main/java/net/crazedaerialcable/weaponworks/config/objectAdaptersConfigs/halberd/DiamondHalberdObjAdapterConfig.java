package net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.halberd;

import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.crazedaerialcable.weaponworks.config.objects.halberd.DiamondHalberdConfigObj;

import java.lang.reflect.Constructor;

public class DiamondHalberdObjAdapterConfig extends WeaponConfigObjAdapterConfig<DiamondHalberdConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return DiamondHalberdConfigObj.class;
    }

    @Override
    public Constructor<DiamondHalberdConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return DiamondHalberdConfigObj.class.getConstructor(String.class);
    }
}
