package com.epam.dp.factory.bean;

import com.epam.dp.factory.annotation.Component;
import com.epam.dp.factory.annotation.InjectRandomInt;

/**
 * @author Ivan_Zhuravel
 */
@Component("SomeClass")
public class SomeClass {

    private String test = "test";

    @InjectRandomInt
    private int random;

    public String getTest() {
        return test;
    }

    public int getRandom() {
        return random;
    }

    @Override
    public String toString() {
        return "SomeClass{" +
                "test='" + test + '\'' +
                ", random=" + random +
                '}';
    }
}
