package net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.scythe;

import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.scythe.StoneScytheConfigObj;

import java.lang.reflect.Constructor;

public class StoneScytheObjAdapterConfig extends WeaponConfigObjAdapterConfig<StoneScytheConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return StoneScytheConfigObj.class;
    }

    @Override
    public Constructor<StoneScytheConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return StoneScytheConfigObj.class.getConstructor(String.class);
    }
}
