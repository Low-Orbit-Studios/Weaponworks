package net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.halberd;

import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.halberd.DiamondHalberdConfigObj;

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
