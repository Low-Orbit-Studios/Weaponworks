package net.twomoonsstudios.moonsweaponry.config.objectAdaptersConfigs;

import io.github.hornster.itemfig.api.serialization.config.ConfigObjAdapterConfig;
import net.twomoonsstudios.moonsweaponry.config.objects.WeaponConfigObj;

import java.lang.reflect.Constructor;

public abstract class WeaponConfigObjAdapterConfig<T extends WeaponConfigObj> extends ConfigObjAdapterConfig<T> {

}
