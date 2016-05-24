
package com.tutorial.robot.exceptions;

@SuppressWarnings("serial")
public class LightBulbException extends RuntimeException
{
    public LightBulbException(String message)
    {
        super("Failed to light bulb");
    }

    public LightBulbException(String message, Exception rootCause)
    {
        super("Failed to light blub", rootCause);
    }
}