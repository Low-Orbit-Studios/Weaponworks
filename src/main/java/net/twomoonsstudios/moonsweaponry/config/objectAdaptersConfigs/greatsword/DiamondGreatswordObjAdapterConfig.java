package net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.greatsword;

import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.WeaponConfigObj;
import net.twomoonsstudios.moonsweaponry.config.objects.greatsword.DiamondGreatswordConfigObj;

import java.lang.reflect.Constructor;

public class DiamondGreatswordObjAdapterConfig extends WeaponConfigObjAdapterConfig<DiamondGreatswordConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return DiamondGreatswordConfigObj.class;
    }

    @Override
    public Constructor<DiamondGreatswordConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return DiamondGreatswordConfigObj.class.getConstructor(String.class);
    }
}
