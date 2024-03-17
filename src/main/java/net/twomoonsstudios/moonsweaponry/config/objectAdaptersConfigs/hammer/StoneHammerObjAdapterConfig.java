package net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.hammer;

import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.hammer.StoneHammerConfigObj;

import java.lang.reflect.Constructor;

public class StoneHammerObjAdapterConfig extends WeaponConfigObjAdapterConfig<StoneHammerConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return StoneHammerConfigObj.class;
    }

    @Override
    public Constructor<StoneHammerConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return StoneHammerConfigObj.class.getConstructor(String.class);
    }
}
