package net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.hammer;

import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.crazedaerialcable.weaponworks.config.objects.hammer.NetheriteHammerConfigObj;

import java.lang.reflect.Constructor;

public class NetheriteHammerObjAdapterConfig extends WeaponConfigObjAdapterConfig<NetheriteHammerConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return NetheriteHammerConfigObj.class;
    }

    @Override
    public Constructor<NetheriteHammerConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return NetheriteHammerConfigObj.class.getConstructor(String.class);
    }
}
