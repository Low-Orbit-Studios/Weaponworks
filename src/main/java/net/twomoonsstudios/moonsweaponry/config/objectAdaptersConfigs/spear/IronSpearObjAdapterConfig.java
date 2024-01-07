package net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.spear;

import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.spear.IronSpearConfigObj;

import java.lang.reflect.Constructor;

public class IronSpearObjAdapterConfig extends WeaponConfigObjAdapterConfig<IronSpearConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return IronSpearConfigObj.class;
    }

    @Override
    public Constructor<IronSpearConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return IronSpearConfigObj.class.getConstructor(String.class);
    }
}
