package net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.halberd;

import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.halberd.NetheriteHalberdConfigObj;

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
