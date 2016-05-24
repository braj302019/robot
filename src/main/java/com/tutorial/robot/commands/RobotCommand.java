
package com.tutorial.robot.commands;

import org.apache.commons.lang3.Validate;

import com.tutorial.robot.Robot;
import com.tutorial.robot.exceptions.CommandFailureException;

public abstract class RobotCommand implements Command
{
    protected final Robot robot;
    protected final String name;

    public RobotCommand(String name, Robot robot)
    {
        Validate.notBlank(name, "Name must not be null");
        Validate.notNull(robot, "Robot must not be null");
        this.name = name;
        this.robot = robot;
    }

    @Override
    public void execute() throws CommandFailureException
    {
        float power = this.robot.getRemainingPower();

        beforeAction();
        performAction();
        afterAction(power);
    }

    protected void beforeAction()
    {
        System.out.println("Start Command");
        System.out.println("Battery status: " + this.robot.getRemainingPower());
        System.out.println("Start performing \"" + this.name + "\"");
    }

    protected abstract void performAction() throws CommandFailureException;

    protected void afterAction(float power)
    {
        System.out.println("End performing \"" + this.name + "\"");
        if (this instanceof PowerConsumptionCommand)
        {
            System.out.println("Battery consumed: " + (power - this.robot.getRemainingPower()));
        }

        System.out.println("Head Light status: " + this.robot.getHeadLightBlubStatus());
        System.out.println("Battery remaining: " + this.robot.getRemainingPower());
        System.out.println("End Command");
        System.out.println("------------------------------------------");
    }

}
