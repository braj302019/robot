
package com.tutorial.robot.exceptions;

@SuppressWarnings("serial")
public class ComponentNotFoundException extends RuntimeException
{
    public ComponentNotFoundException(String name)
    {
        super("Component " + name + " is not attached");
    }
}
