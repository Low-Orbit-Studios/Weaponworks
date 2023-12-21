package net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.greatsword;

import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.greatsword.GoldenGreatswordConfigObj;

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
