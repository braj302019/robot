
package com.tutorial.robot.exceptions;

@SuppressWarnings("serial")
public class UnderChargedException extends PowerException
{
    public UnderChargedException(float powerRequired, float powerRemaining)
    {
        super("Power source is running low. Power required:" + powerRequired + " and power remaining: " + powerRemaining);
    }
}
