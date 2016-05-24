
package com.tutorial.robot.helpers;

public abstract class BarCodePriceConvertor
{
    public static float price(String barCode)
    {
        return Float.parseFloat(barCode.split("-")[1]);
    }
}
