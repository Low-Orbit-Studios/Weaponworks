package net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.halberd;

import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.halberd.StoneHalberdConfigObj;

import java.lang.reflect.Constructor;

public class StoneHalberdObjAdapterConfig extends WeaponConfigObjAdapterConfig<StoneHalberdConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return StoneHalberdConfigObj.class;
    }

    @Override
    public Constructor<StoneHalberdConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return StoneHalberdConfigObj.class.getConstructor(String.class);
    }
}
