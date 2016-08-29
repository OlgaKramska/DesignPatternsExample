package com.epam.dp.factory;

import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * @author Ivan_Zhuravel
 */
public class BeanFactory {

    private Reflections reflections =
            new Reflections("com.epam.dp.factory");
    private Map<String, Object> beans = new HashMap<>();
//    private List<Object> postProcessors = new ArrayList<>();

    {
        Set<Class<?>> annotatedWith = reflections
                .getTypesAnnotatedWith(Component.class);

        for (Class<?> clazz : annotatedWith) {
            tryAddBean(clazz);
        }
    }

    {
        Set<Class<? extends BeanPostProcessor>> subTypesOf = reflections.getSubTypesOf(BeanPostProcessor.class);
        for (Class<?> clazz : subTypesOf) {
            tryPostCreateMethod((Class<? extends BeanPostProcessor>) clazz, getBeans());
        }
    }

    public Object getBean(final String id) {
        return beans.get(id);
    }

    public Collection<Object> getBeans() {
        return beans.values();
    }

    private void tryAddBean(Class<?> clazz) {
        try {
            Component annotation = clazz.getAnnotation(Component.class);

            beans.put(annotation.value(), clazz.newInstance());
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

//    private void tryAddPostProcessor(Class<?> clazz) {
//        try {
//            postProcessors.add(clazz.newInstance());
//        } catch (InstantiationException | IllegalAccessException e) {
//            e.printStackTrace();
//        }
//    }

    private void tryPostCreateMethod(Class<? extends BeanPostProcessor> beanPostProcessor, Collection<Object> beans) {
        for (Object bean : beans) {
            try {
                beanPostProcessor.getMethod("beanPostCreateMethod", Object.class).invoke(beanPostProcessor.newInstance(), bean);
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
        }
    }
}
