package net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.warglaive;

import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.crazedaerialcable.weaponworks.config.objects.warglaive.IronWarglaiveConfigObj;

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
