package net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.mace;

import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.mace.StoneMaceConfigObj;

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
