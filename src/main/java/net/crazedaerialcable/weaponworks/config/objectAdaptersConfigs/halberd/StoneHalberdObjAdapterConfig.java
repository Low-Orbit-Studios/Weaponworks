package net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.halberd;

import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.crazedaerialcable.weaponworks.config.objects.halberd.StoneHalberdConfigObj;

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
