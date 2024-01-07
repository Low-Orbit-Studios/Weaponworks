package net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.halberd;

import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.halberd.IronHalberdConfigObj;

import java.lang.reflect.Constructor;

public class IronHalberdObjAdapterConfig extends WeaponConfigObjAdapterConfig<IronHalberdConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return IronHalberdConfigObj.class;
    }

    @Override
    public Constructor<IronHalberdConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return IronHalberdConfigObj.class.getConstructor(String.class);
    }
}
