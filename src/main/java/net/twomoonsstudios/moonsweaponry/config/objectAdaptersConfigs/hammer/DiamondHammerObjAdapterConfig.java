package net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.hammer;

import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.hammer.DiamondHammerConfigObj;

import java.lang.reflect.Constructor;

public class DiamondHammerObjAdapterConfig extends WeaponConfigObjAdapterConfig<DiamondHammerConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return DiamondHammerConfigObj.class;
    }

    @Override
    public Constructor<DiamondHammerConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return DiamondHammerConfigObj.class.getConstructor(String.class);
    }
}
