package net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.hammer;

import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.hammer.IronHammerConfigObj;

import java.lang.reflect.Constructor;

public class IronHammerObjAdapterConfig extends WeaponConfigObjAdapterConfig<IronHammerConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return IronHammerConfigObj.class;
    }

    @Override
    public Constructor<IronHammerConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return IronHammerConfigObj.class.getConstructor(String.class);
    }
}
