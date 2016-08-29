package com.epam.dp.factory;

/**
 * @author Ivan_Zhuravel
 */
public class Main {

    public static void main(String[] args) {
        BeanFactory factory = new BeanFactory();
        System.out.println(factory.getBean("SomeClass"));
        System.out.println(factory.getBean("AnotherClass"));
    }
}
