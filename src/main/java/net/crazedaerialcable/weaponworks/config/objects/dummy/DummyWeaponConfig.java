package net.crazedaerialcable.weaponworks.config.objects.dummy;

import io.github.hornster.itemfig.api.serialization.config.ConfigObj;

import java.lang.reflect.Type;

public class DummyWeaponConfig extends ConfigObj {
    /**
     * @param myType needed for auto deserialization.
     * @param myID   will be used to discern this config object from others during deserialization.
     *               It MUST be unique. Just like in MC itself.
     */
    public DummyWeaponConfig(Type myType, String myID) {
        super(myType, myID);
    }

    @Override
    public void chkDefaultValues() {

    }
}
