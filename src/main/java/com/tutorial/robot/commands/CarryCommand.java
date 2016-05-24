
package com.tutorial.robot.commands;

import org.apache.commons.lang3.Validate;

import com.tutorial.robot.Robot;
import com.tutorial.robot.exceptions.CarrierException;
import com.tutorial.robot.exceptions.CommandFailureException;
import com.tutorial.robot.exceptions.ItemOverloadException;
import com.tutorial.robot.item.Item;

public class CarryCommand extends RobotCommand implements PowerConsumptionCommand
{
    private final Item item;
    private final int meters;

    public CarryCommand(Robot robot, Item item, int meters)
    {
        super("carry", robot);
        Validate.notNull(item, "Item must not be null");
        this.item = item;
        this.meters = meters;
    }

    @Override
    public void performAction() throws CommandFailureException
    {
        try
        {
            robot.display("Delivering an item, Weight: " + item.getWeight() + " grams Distance: " + meters + " meters");
            robot.carry(item, meters);
            robot.display("Item delivered successfully at destination");
        }
        catch (ItemOverloadException e)
        {
            robot.display("Overweight");
            throw new CommandFailureException("Failed to carry due to overweight", e);
        }
        catch (CarrierException e)
        {
            throw new CommandFailureException("Failed to carry", e);
        }
    }

}
