package net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.spear;

import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.crazedaerialcable.weaponworks.config.objects.spear.StoneSpearConfigObj;

import java.lang.reflect.Constructor;

public class StoneSpearObjAdapterConfig extends WeaponConfigObjAdapterConfig<StoneSpearConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return StoneSpearConfigObj.class;
    }

    @Override
    public Constructor<StoneSpearConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return StoneSpearConfigObj.class.getConstructor(String.class);
    }
}
