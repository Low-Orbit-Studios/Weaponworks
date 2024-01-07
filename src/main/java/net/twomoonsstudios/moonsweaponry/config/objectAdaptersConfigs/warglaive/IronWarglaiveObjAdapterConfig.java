package net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.warglaive;

import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.warglaive.IronWarglaiveConfigObj;

import java.lang.reflect.Constructor;

public class IronWarglaiveObjAdapterConfig extends WeaponConfigObjAdapterConfig<IronWarglaiveConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return IronWarglaiveConfigObj.class;
    }

    @Override
    public Constructor<IronWarglaiveConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return IronWarglaiveConfigObj.class.getConstructor(String.class);
    }
}
