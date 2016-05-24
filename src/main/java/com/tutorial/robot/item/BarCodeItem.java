
package com.tutorial.robot.item;

public class BarCodeItem extends Item implements HasBarCode
{

    public BarCodeItem(String code, float weight)
    {
        super(code, weight);
    }

    @Override
    public String getBarCode()
    {
        return super.getCode();
    }

}
