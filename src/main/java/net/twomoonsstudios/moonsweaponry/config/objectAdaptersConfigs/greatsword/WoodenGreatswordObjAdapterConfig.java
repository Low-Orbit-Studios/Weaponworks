package net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.greatsword;

import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.greatsword.WoodenGreatswordConfigObj;

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
