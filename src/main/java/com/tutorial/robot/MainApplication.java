
package com.tutorial.robot;

import com.tutorial.robot.commands.CarryCommand;
import com.tutorial.robot.commands.ChargeCommand;
import com.tutorial.robot.commands.Command;
import com.tutorial.robot.commands.MoveCommand;
import com.tutorial.robot.commands.ScanCommand;
import com.tutorial.robot.components.ComponentFactory;
import com.tutorial.robot.components.Mover;
import com.tutorial.robot.components.RobotComponentFactory;
import com.tutorial.robot.exceptions.ComponentNotFoundException;
import com.tutorial.robot.item.BarCodeItem;
import com.tutorial.robot.item.Item;

public class MainApplication
{
    public static void main(String[] args) throws ComponentNotFoundException
    {
        // Abstract Factory Design Pattern
        ComponentFactory factory = new RobotComponentFactory();

        // Builder and Strategy Design Pattern
        Mover mover = factory.createMover();
        Robot robot = new Robot.RobotBuilder().withPowerSource(factory.createPowerSource()).withDisplay(factory.createDisplay())
                .withCharger(factory.createCharger()).withMover(mover).withCarrier(factory.createCarrier(mover)).withScanner(factory.createScanner())
                .withHeadLightBulb(factory.createHeadLightBulb()).build();

        // Singleton Lazy loading Design Pattern
        RobotController controller = RobotController.getInstance();

        // Command and Template Method Design Pattern
        // Charge 100%
        Command chargingCommand = new ChargeCommand(robot, 100);
        controller.addCommand(chargingCommand);

        // Robot walks for 3.5 KM
        Command moveCommand = new MoveCommand(robot, 3500);
        controller.addCommand(moveCommand);

        // Charge again 20% more
        Command nextChargingCommand = new ChargeCommand(robot, 20);
        controller.addCommand(nextChargingCommand);

        // Robot walks for 2 KM carrying 3 KG weight
        BarCodeItem item = new BarCodeItem("ABC-99", 3000.00f);
        // Decorator Design Pattern
        Command carryCommand = new CarryCommand(robot, item, 2000);
        controller.addCommand(carryCommand);

        // Scan an item of price 99
        Command scanCommand = new ScanCommand(robot, item);
        controller.addCommand(scanCommand);

        // Robot carries over weight 12 KG weight
        Item overweightItem = new BarCodeItem("XYZ-1999", 12000.00f);
        Command nextCarryCommand = new CarryCommand(robot, overweightItem, 2000);
        controller.addCommand(nextCarryCommand);

        controller.executeCommands();

    }
}
