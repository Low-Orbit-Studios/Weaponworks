package net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.katana;

import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.katana.StoneKatanaConfigObj;

import java.lang.reflect.Constructor;

public class StoneKatanaObjAdapterConfig extends WeaponConfigObjAdapterConfig<StoneKatanaConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return StoneKatanaConfigObj.class;
    }

    @Override
    public Constructor<StoneKatanaConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return StoneKatanaConfigObj.class.getConstructor(String.class);
    }
}
