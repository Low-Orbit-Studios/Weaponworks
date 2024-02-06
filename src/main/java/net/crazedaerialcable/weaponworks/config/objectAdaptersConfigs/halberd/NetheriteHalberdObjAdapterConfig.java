package net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.halberd;

import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.crazedaerialcable.weaponworks.config.objects.halberd.NetheriteHalberdConfigObj;

import java.lang.reflect.Constructor;

public class NetheriteHalberdObjAdapterConfig extends WeaponConfigObjAdapterConfig<NetheriteHalberdConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return NetheriteHalberdConfigObj.class;
    }

    @Override
    public Constructor<NetheriteHalberdConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return NetheriteHalberdConfigObj.class.getConstructor(String.class);
    }
}
