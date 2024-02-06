package net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.katana;

import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.crazedaerialcable.weaponworks.config.objects.katana.StoneKatanaConfigObj;

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
