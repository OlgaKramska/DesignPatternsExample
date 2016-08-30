package com.epam.dp.factory.bean;

import com.epam.dp.factory.annotation.Component;
import com.epam.dp.factory.annotation.InjectRandomInt;

/**
 * Created by Olga_Kramska on 8/29/2016.
 */
@Component(value = "AnotherClass")
public class AnotherClass {

    @InjectRandomInt
    private int random;

    public int getRandom() {
        return random;
    }

    @Override
    public String toString() {
        return "AnotherClass{" +
                "random=" + random +
                '}';
    }
}
