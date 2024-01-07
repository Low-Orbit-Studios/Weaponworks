package net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.spear;

import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.spear.NetheriteSpearConfigObj;

import java.lang.reflect.Constructor;

public class NetheriteSpearObjAdapterConfig extends WeaponConfigObjAdapterConfig<NetheriteSpearConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return NetheriteSpearConfigObj.class;
    }

    @Override
    public Constructor<NetheriteSpearConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return NetheriteSpearConfigObj.class.getConstructor(String.class);
    }
}
