package net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.greatsword;

import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.crazedaerialcable.weaponworks.config.objects.greatsword.WoodenGreatswordConfigObj;

import java.lang.reflect.Constructor;

public class WoodenGreatswordObjAdapterConfig extends WeaponConfigObjAdapterConfig<WoodenGreatswordConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return WoodenGreatswordConfigObj.class;
    }

    @Override
    public Constructor<WoodenGreatswordConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return WoodenGreatswordConfigObj.class.getConstructor(String.class);
    }
}
