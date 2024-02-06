package net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.greatsword;

import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.crazedaerialcable.weaponworks.config.objects.greatsword.NetheriteGreatswordConfigObj;

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
