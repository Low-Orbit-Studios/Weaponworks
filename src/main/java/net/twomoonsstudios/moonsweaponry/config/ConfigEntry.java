package net.twomoonsstudios.moonsweaponry.config;

import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ConfigEntry<T> {
    public List<String> path;
    public T fallback;

    public ConfigEntry(String path) {
        this(path, null);
    }

    public ConfigEntry(String path, @Nullable T fallback) {
        this.path = List.of(path.split("\\."));
        this.fallback = fallback;
    }

    public T get() {
        return this.get(this.fallback);
    }

    @SuppressWarnings("unchecked")
    public T get(T fallback) {
        Map next = MoonsWeaponsConfig.CONFIG;
        Object result = null;

        for (String step : this.path) {
            try {
                next = (Map) next.get(step);
            }
            catch (Exception e) {
                if (Objects.equals(step, this.path.get(this.path.size() - 1)))
                    result = next.get(step);
                else
                    return fallback;
            }
            if (next == null)
                return fallback;
        }

        if (fallback.getClass() == Integer.class)
            return (T) (Integer) Long.valueOf(Math.round(Double.parseDouble(String.valueOf(result)))).intValue();
        if (fallback.getClass() == Double.class)
            return (T) Double.valueOf(String.valueOf(result));
        if (fallback.getClass() == String.class)
            return (T) String.valueOf(result);
        if (fallback.getClass() == Boolean.class)
            return (T) Boolean.valueOf(String.valueOf(result));
        if (fallback instanceof Map)
            return (T) next;
        if (fallback instanceof List)
            return (T) result;
        return fallback;
    }
}