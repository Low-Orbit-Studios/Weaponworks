package net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.warglaive;

import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.warglaive.StoneWarglaiveConfigObj;

import java.lang.reflect.Constructor;

public class StoneWarglaiveObjAdapterConfig extends WeaponConfigObjAdapterConfig<StoneWarglaiveConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return StoneWarglaiveConfigObj.class;
    }

    @Override
    public Constructor<StoneWarglaiveConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return StoneWarglaiveConfigObj.class.getConstructor(String.class);
    }
}
