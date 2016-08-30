package com.epam.dp.factory.postprocessor.impl;


import com.epam.dp.factory.InjectRandomInt;
import com.epam.dp.factory.postprocessor.BeanPostProcessor;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * Created by Olga_Kramska on 8/29/2016.
 */
public class InjectRandomIntBeanPostProcessor implements BeanPostProcessor {
    private Random random = new Random();

    @Override
    public void beanPostCreateMethod(Object bean) {
        Field[] fields = bean.getClass().getDeclaredFields();

        for (Field field : fields) {
            tryToSetInt(bean, field);
        }
    }

    private void tryToSetInt(Object bean, Field field) {
        if (field.getAnnotation(InjectRandomInt.class) != null) {
            try {
                field.setAccessible(true);
                field.setInt(bean, random.nextInt());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } finally {
                field.setAccessible(false);//TODO Is it needed??
            }
        }
    }
}

