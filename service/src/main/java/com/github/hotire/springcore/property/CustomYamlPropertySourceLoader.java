package com.github.hotire.springcore.property;

import java.io.IOException;
import java.util.List;

import org.springframework.boot.env.PropertySourceLoader;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import lombok.RequiredArgsConstructor;

/**
 * @see org.springframework.boot.env.YamlPropertySourceLoader
 */
@RequiredArgsConstructor
public class CustomYamlPropertySourceLoader implements PropertySourceLoader {

    private static final Resource[] EMPTY_RESOURCES = {};

    private final ResourceLoader resourceLoader;

    private static final String CLASSPATH_URL_PREFIX = ResourceLoader.CLASSPATH_URL_PREFIX;

    @Override
    public String[] getFileExtensions() {
        return new String[0];
    }

    @Override
    public List<PropertySource<?>> load(String name, Resource resource) throws IOException {
        return null;
    }

//    public <T> T load(String resourcePath, Class<T> type) {
//        @Cleanup
//        final InputStream inputStream = getClass().getClassLoader().getResourceAsStream(resourcePath);
//        return new Yaml().loadAs(inputStream, type);
//    }

    private Resource[] getResources(String locationReference) {
        try {
            return new Resource[] { this.resourceLoader.getResource(locationReference) };
        } catch (Exception ex) {
            return EMPTY_RESOURCES;
        }
    }
}
