package com.epam.dp.factory;

/**
 * @author Ivan_Zhuravel
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ApplicationContext();
        System.out.println(context.getBean("SomeClass"));
        System.out.println(context.getBean("AnotherClass"));
    }
}
