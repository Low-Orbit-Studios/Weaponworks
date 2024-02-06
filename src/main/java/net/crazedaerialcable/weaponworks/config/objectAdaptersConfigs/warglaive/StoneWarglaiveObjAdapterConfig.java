package net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.warglaive;

import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.crazedaerialcable.weaponworks.config.objects.warglaive.StoneWarglaiveConfigObj;

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
