package com.epam.dp.factory;

/**
 * @author Ivan_Zhuravel
 */
public class Main {

    public static void main(String[] args) {
        BeanFactory factory = new BeanFactory();
        SomeClass someClass =
                (SomeClass) factory.getBean("SomeClass");
        System.out.println(someClass.getTest());
        System.out.println(someClass.getRandom());

        AnotherClass anotherClass =
                (AnotherClass) factory.getBean("AnotherClass");
        System.out.println(anotherClass.getRandom());
    }
}
