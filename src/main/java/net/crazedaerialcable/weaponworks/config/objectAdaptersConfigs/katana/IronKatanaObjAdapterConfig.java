package net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.katana;

import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.crazedaerialcable.weaponworks.config.objects.katana.IronKatanaConfigObj;

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
