package net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.hammer;

import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.crazedaerialcable.weaponworks.config.objects.hammer.StoneHammerConfigObj;

import java.lang.reflect.Constructor;

public class StoneHammerObjAdapterConfig extends WeaponConfigObjAdapterConfig<StoneHammerConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return StoneHammerConfigObj.class;
    }

    @Override
    public Constructor<StoneHammerConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return StoneHammerConfigObj.class.getConstructor(String.class);
    }
}
