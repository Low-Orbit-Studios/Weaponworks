package net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.halberd;

import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.halberd.GoldenHalberdConfigObj;

import java.lang.reflect.Constructor;

public class GoldenHalberdObjAdapterConfig extends WeaponConfigObjAdapterConfig<GoldenHalberdConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return GoldenHalberdConfigObj.class;
    }

    @Override
    public Constructor<GoldenHalberdConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return GoldenHalberdConfigObj.class.getConstructor(String.class);
    }
}
