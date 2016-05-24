
package com.tutorial.robot.commands;

import com.tutorial.robot.Robot;
import com.tutorial.robot.exceptions.CommandFailureException;
import com.tutorial.robot.exceptions.PowerException;

public class ChargeCommand extends RobotCommand
{
    private float powerLevel;

    public ChargeCommand(Robot robot, float powerLevel)
    {
        super("charge", robot);
        this.powerLevel = powerLevel;
    }

    @Override
    public void performAction() throws CommandFailureException
    {
        try
        {
            robot.display("Charging, power level: " + powerLevel);
            robot.charge(powerLevel);
            robot.display("Charging completed");
        }
        catch (PowerException e)
        {
            throw new CommandFailureException("Failed to charge", e);
        }
    }

}
