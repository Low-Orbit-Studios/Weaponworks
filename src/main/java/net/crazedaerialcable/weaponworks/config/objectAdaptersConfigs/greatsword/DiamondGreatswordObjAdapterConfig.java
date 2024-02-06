package net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.greatsword;

import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.crazedaerialcable.weaponworks.config.objects.greatsword.DiamondGreatswordConfigObj;

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
