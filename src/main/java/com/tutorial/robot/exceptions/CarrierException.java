
package com.tutorial.robot.exceptions;

@SuppressWarnings("serial")
public class CarrierException extends MoverException
{
    public CarrierException(String message)
    {
        super("Failed to carry item");
    }

    public CarrierException(String message, Exception rootCause)
    {
        super("Failed to carry item", rootCause);
    }
}