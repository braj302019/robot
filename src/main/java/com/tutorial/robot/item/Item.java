
package com.tutorial.robot.item;

import org.apache.commons.lang3.Validate;

public abstract class Item
{
    private final String code;
    private final float weight;

    public Item(String code, float weight)
    {
        Validate.notEmpty(code, "Item code must not be empty");
        this.code = code;
        this.weight = weight;
    }

    public String getCode()
    {
        return code;
    }

    public float getWeight()
    {
        return weight;
    }

}
