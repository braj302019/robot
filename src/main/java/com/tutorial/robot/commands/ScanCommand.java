
package com.tutorial.robot.commands;

import org.apache.commons.lang3.Validate;

import com.tutorial.robot.Robot;
import com.tutorial.robot.exceptions.CommandFailureException;
import com.tutorial.robot.exceptions.ScanFailureException;
import com.tutorial.robot.helpers.BarCodePriceConvertor;
import com.tutorial.robot.item.HasBarCode;

public class ScanCommand extends RobotCommand
{
    private final HasBarCode item;

    public ScanCommand(Robot robot, HasBarCode item)
    {
        super("scan", robot);
        Validate.notNull(item, "Item must not be null");
        this.item = item;
    }

    @Override
    public void performAction() throws CommandFailureException
    {
        try
        {
            robot.display("Scanning item");
            String barCode = robot.scan(item);
            robot.display("Item price scanned: " + BarCodePriceConvertor.price(barCode));
        }
        catch (ScanFailureException e)
        {
            robot.display("Scan Failure");
            throw new CommandFailureException("Failed to scan", e);
        }
    }

}
