package com.epam.dp.factory;

import com.epam.dp.factory.annotation.Component;
import org.reflections.Reflections;

import java.util.*;

/**
 * @author Ivan_Zhuravel
 */
public class BeanFactory {

    private Reflections reflections =
            new Reflections("com.epam.dp.factory");
    private Map<String, Object> beans = new HashMap<>();

    {
        Set<Class<?>> annotatedWith = reflections
                .getTypesAnnotatedWith(Component.class);

        for (Class<?> clazz : annotatedWith) {
            tryAddBean(clazz);
        }
    }

    public Object getBean(final String id) {
        return beans.get(id);
    }

    public Collection<Object> getBeans() {
        return beans.values();
    }

    public Reflections getReflections() {
        return reflections;
    }

    private void tryAddBean(Class<?> clazz) {
        try {
            Component annotation = clazz.getAnnotation(Component.class);

            beans.put(annotation.value(), clazz.newInstance());
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
