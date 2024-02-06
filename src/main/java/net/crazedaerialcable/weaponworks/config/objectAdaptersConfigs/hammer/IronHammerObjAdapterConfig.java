package net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.hammer;

import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.crazedaerialcable.weaponworks.config.objects.hammer.IronHammerConfigObj;

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
