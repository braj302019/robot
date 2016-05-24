
package com.tutorial.robot.components.impl;

import org.apache.commons.lang3.Validate;

import com.tutorial.robot.components.Bulb;

public class LightBulb implements Bulb
{
    private Color color = Color.NONE;
    private Status status = Status.OFF;

    @Override
    public void turnOn(Color color)
    {
        Validate.notNull(color, "Light Bulb color must not be null");
        if (status == Status.OFF)
        {
            status = Status.ON;
            this.color = color;
        }
    }

    @Override
    public void turnOff()
    {
        if (status == Status.ON)
        {
            status = Status.OFF;
        }
    }

    @Override
    public Status getStatus()
    {
        return status;
    }

    @Override
    public Color getColor()
    {
        return color;
    }

    @Override
    public String name()
    {
        return "Light Bulb";
    }
}
