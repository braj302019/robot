
package com.tutorial.robot;

import org.easymock.EasyMock;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tutorial.robot.commands.CarryCommand;
import com.tutorial.robot.commands.Command;
import com.tutorial.robot.components.PowerSource;
import com.tutorial.robot.components.impl.Battery;
import com.tutorial.robot.exceptions.CommandFailureException;
import com.tutorial.robot.item.Item;

@Test(groups = "unit")
public class CarryCommandTest
{
    @Test
    public void testCommand()
    {
        int distanceInMeters = 2000; // 2 KM
        float weightInGrams = 2000; // 2 KG

        PowerSource powerSource = new Battery();
        powerSource.charge(100.0f); // fully charged
        Robot robot = Helper.createRobot(powerSource);

        Assert.assertEquals(robot.getRemainingPower(), 100.0f);

        Item item = EasyMock.createMock(Item.class);
        EasyMock.expect(item.getWeight()).andStubReturn(weightInGrams);
        EasyMock.replay(item);

        Command command = new CarryCommand(robot, item, distanceInMeters);
        command.execute();

        float actualRemainingPower = robot.getRemainingPower();
        float expectedRemainingPower = 52.0f; // 48% power consumed (40% in
                                              // moving + 8% in carrying item)
        Assert.assertEquals(actualRemainingPower, expectedRemainingPower);
    }

    @Test(expectedExceptions = CommandFailureException.class)
    public void testItemOverweight()
    {
        int distanceInMeters = 1; // 1 meter
        float weightInGrams = 12000; // 12 KG

        PowerSource powerSource = new Battery();
        powerSource.charge(100.0f); // fully charged
        Robot robot = Helper.createRobot(powerSource);

        Assert.assertEquals(robot.getRemainingPower(), 100.0f);

        Item item = EasyMock.createMock(Item.class);
        EasyMock.expect(item.getWeight()).andStubReturn(weightInGrams);
        EasyMock.replay(item);

        Command command = new CarryCommand(robot, item, distanceInMeters);
        command.execute();
    }
}
