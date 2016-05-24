
package com.tutorial.robot.exceptions;

@SuppressWarnings("serial")
public class ScannerException extends RuntimeException
{
    public ScannerException(String message)
    {
        super("Failed to scan item");
    }

    public ScannerException(String message, Exception rootCause)
    {
        super("Failed to scan item", rootCause);
    }
}