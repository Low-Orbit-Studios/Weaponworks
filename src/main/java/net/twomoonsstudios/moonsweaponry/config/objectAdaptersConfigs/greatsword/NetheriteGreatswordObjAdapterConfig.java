package net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.greatsword;

import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.greatsword.NetheriteGreatswordConfigObj;

import java.lang.reflect.Constructor;

public class NetheriteGreatswordObjAdapterConfig extends WeaponConfigObjAdapterConfig<NetheriteGreatswordConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return NetheriteGreatswordConfigObj.class;
    }

    @Override
    public Constructor<NetheriteGreatswordConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return NetheriteGreatswordConfigObj.class.getConstructor(String.class);
    }
}
