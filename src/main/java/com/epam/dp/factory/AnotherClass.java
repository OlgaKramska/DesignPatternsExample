package com.epam.dp.factory;

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
}
