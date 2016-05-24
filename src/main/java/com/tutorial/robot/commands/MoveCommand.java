
package com.tutorial.robot.commands;

import com.tutorial.robot.Robot;
import com.tutorial.robot.exceptions.CommandFailureException;
import com.tutorial.robot.exceptions.MoverException;

public class MoveCommand extends RobotCommand implements PowerConsumptionCommand
{
    private final int meters;

    public MoveCommand(Robot robot, int meters)
    {
        super("move", robot);
        this.meters = meters;
    }

    @Override
    public void performAction() throws CommandFailureException
    {
        try
        {
            robot.display("Moving alone, Distance: " + meters + " meters");
            robot.move(meters);
            robot.display("Reached successfully at destination");
        }
        catch (MoverException e)
        {
            throw new CommandFailureException("Failed to move", e);
        }
    }

}
