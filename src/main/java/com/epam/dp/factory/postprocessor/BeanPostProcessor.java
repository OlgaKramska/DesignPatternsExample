package com.epam.dp.factory.postprocessor;

/**
 * Created by Olga_Kramska on 8/29/2016.
 */
public interface BeanPostProcessor {
    void beanPostCreateMethod(Object bean);
}
