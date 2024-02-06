package net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.halberd;

import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.crazedaerialcable.weaponworks.config.objects.halberd.IronHalberdConfigObj;

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
