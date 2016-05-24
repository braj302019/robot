
package com.tutorial.robot.components.impl;

import org.apache.commons.lang3.StringUtils;

import com.tutorial.robot.components.Display;

public class LEDDisplay implements Display
{
    private String message = StringUtils.EMPTY;

    public void display(String message)
    {
        this.message = message;
        System.out.println(message);
    }

    @Override
    public String getMessage()
    {
        return message;
    }

    @Override
    public String name()
    {
        return "LED Display";
    }
}
