
package com.tutorial.robot.exceptions;

@SuppressWarnings("serial")
public class MoverException extends RuntimeException
{
    public MoverException(String message)
    {
        super(message);
    }

    public MoverException(String message, Exception rootCause)
    {
        super(message, rootCause);
    }

}