package soulasphyxia.utils;

import lombok.Getter;

import java.io.InputStream;

@Getter
public class ResourcesLoader {
    private final ClassLoader classLoader = getClass().getClassLoader();

    public ResourcesLoader() {
    }

    public java.net.URL getResource(String filename) {
        return classLoader.getResource(filename);
    }

    public InputStream getFontResource(String filename){
        return classLoader.getResourceAsStream(filename);

    }
}
