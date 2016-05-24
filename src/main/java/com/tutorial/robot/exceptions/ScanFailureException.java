
package com.tutorial.robot.exceptions;

@SuppressWarnings("serial")
public class ScanFailureException extends ScannerException
{
    public ScanFailureException()
    {
        this("Failed to scan the item. Bar code might not clear enough for scanning");
    }

    public ScanFailureException(String message)
    {
        super(message);
    }
}
