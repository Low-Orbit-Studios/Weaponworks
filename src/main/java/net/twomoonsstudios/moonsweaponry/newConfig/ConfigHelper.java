package net.twomoonsstudios.moonsweaponry.newConfig;

import java.nio.file.Path;

public class ConfigHelper {
    public WeaponworksConfig weaponworksConfig;

    public ConfigHelper(Path configPath) {
        this.weaponworksConfig = WeaponworksConfig.load(configPath.resolve("weaponworks.json").toFile());
    }

    public int convertToInt(Object variable) {
        Class<?> variableClass = variable.getClass();
        if (variableClass.equals(Double.class)) {
            return Math.round(((Double) variable).floatValue());
        } if (variableClass.equals(Integer.class)) {
            return (int) variable;
        } else return 0;
    }

}
