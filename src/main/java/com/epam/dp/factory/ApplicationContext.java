package com.epam.dp.factory;

import com.epam.dp.factory.postprocessor.BeanPostProcessor;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Set;

/**
 * Created by Olga_Kramska on 8/30/2016.
 */
public class ApplicationContext {
    private BeanFactory factory;

    public ApplicationContext() {
        factory = new BeanFactory();
        Reflections reflections = factory.getReflections();
        Set<Class<? extends BeanPostProcessor>> subTypesOf = reflections.getSubTypesOf(BeanPostProcessor.class);
        for (Class<?> clazz : subTypesOf) {
            tryPostCreateMethod((Class<? extends BeanPostProcessor>) clazz, factory.getBeans());
        }
    }

    public Object getBean(final String id) {
        return factory.getBean(id);
    }

    public Collection<Object> getBeans() {
        return factory.getBeans();
    }

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
