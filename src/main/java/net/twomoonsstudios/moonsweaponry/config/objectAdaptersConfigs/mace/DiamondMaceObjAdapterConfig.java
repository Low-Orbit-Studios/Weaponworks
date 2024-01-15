package net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.mace;

import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.mace.DiamondMaceConfigObj;

import java.lang.reflect.Constructor;

public class DiamondMaceObjAdapterConfig extends WeaponConfigObjAdapterConfig<DiamondMaceConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return DiamondMaceConfigObj.class;
    }

    @Override
    public Constructor<DiamondMaceConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return DiamondMaceConfigObj.class.getConstructor(String.class);
    }
}
