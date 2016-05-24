
package com.tutorial.robot.exceptions;

@SuppressWarnings("serial")
public class CommandFailureException extends RuntimeException
{
    public CommandFailureException(Exception rootCause)
    {
        this("Failed to execute the command", rootCause);
    }

    public CommandFailureException(String message, Exception rootCause)
    {
        super(message, rootCause);
    }
}
