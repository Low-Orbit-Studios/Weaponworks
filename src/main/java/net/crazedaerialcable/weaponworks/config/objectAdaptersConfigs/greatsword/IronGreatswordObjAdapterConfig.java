package net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.greatsword;

import net.crazedaerialcable.weaponworks.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.crazedaerialcable.weaponworks.config.objects.greatsword.IronGreatswordConfigObj;

import java.lang.reflect.Constructor;

public class IronGreatswordObjAdapterConfig extends WeaponConfigObjAdapterConfig<IronGreatswordConfigObj> {
    @Override
    public Class getConfigObjClass() {
        return IronGreatswordConfigObj.class;
    }

    @Override
    public Constructor<IronGreatswordConfigObj> getConstructorForDeserialization() throws NoSuchMethodException {
        return IronGreatswordConfigObj.class.getConstructor(String.class);
    }
}
