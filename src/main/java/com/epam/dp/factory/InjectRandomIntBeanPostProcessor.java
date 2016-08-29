package com.epam.dp.factory;


import java.lang.reflect.Field;
import java.util.Random;

/**
 * Created by Olga_Kramska on 8/29/2016.
 */
public class InjectRandomIntBeanPostProcessor implements BeanPostProcessor {
    private Random random = new Random();

    @Override
    public void beanPostCreateMethod(Object bean) {
        Field[] fields = bean.getClass().getFields();
//        for (Field field : fields) {
        for (int i = 0; i < fields.length; i++) {
            tryToSetInt(bean, fields[i]);
        }
    }

    private void tryToSetInt(Object bean, Field field) {
        if (field.getAnnotation(InjectRandomInt.class) != null) {
            try {
                field.setInt(bean, random.nextInt());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}

