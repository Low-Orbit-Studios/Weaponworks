package net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.halberd;

import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.halberd.WoodenHalberdConfigObj;

import java.lang.reflect.Constructor;

public class WoodenHalberdObjAdapterConfig extends WeaponConfigObjAdapterConfig<WoodenHalberdConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return WoodenHalberdConfigObj.class;
    }

    @Override
    public Constructor<WoodenHalberdConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return WoodenHalberdConfigObj.class.getConstructor(String.class);
    }
}
