package net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.greatsword;

import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.crazedaerialcable.weaponworks.config.objects.greatsword.GoldenGreatswordConfigObj;

import java.lang.reflect.Constructor;

public class GoldenGreatswordObjAdapterConfig extends WeaponConfigObjAdapterConfig<GoldenGreatswordConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return GoldenGreatswordConfigObj.class;
    }

    @Override
    public Constructor<GoldenGreatswordConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return GoldenGreatswordConfigObj.class.getConstructor(String.class);
    }
}
