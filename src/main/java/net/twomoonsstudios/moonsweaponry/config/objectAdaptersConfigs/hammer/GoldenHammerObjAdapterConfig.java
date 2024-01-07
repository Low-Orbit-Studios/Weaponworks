package net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.hammer;

import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.hammer.GoldenHammerConfigObj;

import java.lang.reflect.Constructor;

public class GoldenHammerObjAdapterConfig extends WeaponConfigObjAdapterConfig<GoldenHammerConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return GoldenHammerConfigObj.class;
    }

    @Override
    public Constructor<GoldenHammerConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return GoldenHammerConfigObj.class.getConstructor(String.class);
    }
}
