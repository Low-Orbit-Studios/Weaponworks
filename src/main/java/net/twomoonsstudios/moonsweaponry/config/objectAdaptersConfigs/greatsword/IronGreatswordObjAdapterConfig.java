package net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.greatsword;

import net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs.WeaponConfigObjAdapterConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.greatsword.IronGreatswordConfigObj;

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
