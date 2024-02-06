package net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.greatsword;

import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.crazedaerialcable.weaponworks.config.objects.greatsword.StoneGreatswordConfigObj;

import java.lang.reflect.Constructor;

public class StoneGreatswordObjAdapterConfig extends WeaponConfigObjAdapterConfig<StoneGreatswordConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return StoneGreatswordConfigObj.class;
    }

    @Override
    public Constructor<StoneGreatswordConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return StoneGreatswordConfigObj.class.getConstructor(String.class);
    }
}
