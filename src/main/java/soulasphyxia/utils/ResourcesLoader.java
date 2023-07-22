package soulasphyxia.utils;

import lombok.Getter;

@Getter
public class ResourcesLoader {
    private final ClassLoader classLoader = getClass().getClassLoader();

    public ResourcesLoader() {
    }

    public java.net.URL getResource(String filename) {
        return classLoader.getResource(filename);
    }
}
