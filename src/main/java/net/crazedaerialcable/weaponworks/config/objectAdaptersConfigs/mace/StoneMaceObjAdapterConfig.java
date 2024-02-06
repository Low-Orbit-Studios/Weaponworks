package net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.mace;

import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.crazedaerialcable.weaponworks.config.objects.mace.StoneMaceConfigObj;

import java.lang.reflect.Constructor;

public class StoneMaceObjAdapterConfig extends WeaponConfigObjAdapterConfig<StoneMaceConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return StoneMaceConfigObj.class;
    }

    @Override
    public Constructor<StoneMaceConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return StoneMaceConfigObj.class.getConstructor(String.class);
    }
}
