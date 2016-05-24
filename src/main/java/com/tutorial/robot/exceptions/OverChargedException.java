
package com.tutorial.robot.exceptions;

@SuppressWarnings("serial")
public class OverChargedException extends PowerException
{
    public OverChargedException()
    {
        super("Power source is running over charged");
    }
}
