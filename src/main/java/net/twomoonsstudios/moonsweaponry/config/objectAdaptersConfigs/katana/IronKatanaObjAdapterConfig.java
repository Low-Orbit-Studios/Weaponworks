package net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.katana;

import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.katana.IronKatanaConfigObj;

import java.lang.reflect.Constructor;

public class IronKatanaObjAdapterConfig extends WeaponConfigObjAdapterConfig<IronKatanaConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return IronKatanaConfigObj.class;
    }

    @Override
    public Constructor<IronKatanaConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return IronKatanaConfigObj.class.getConstructor(String.class);
    }
}
