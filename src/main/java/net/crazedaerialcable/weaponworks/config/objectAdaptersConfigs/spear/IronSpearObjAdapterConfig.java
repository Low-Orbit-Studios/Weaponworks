package net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.spear;

import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.crazedaerialcable.weaponworks.config.objects.spear.IronSpearConfigObj;

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
