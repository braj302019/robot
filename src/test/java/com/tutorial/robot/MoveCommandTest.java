
package com.tutorial.robot;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tutorial.robot.commands.Command;
import com.tutorial.robot.commands.MoveCommand;
import com.tutorial.robot.components.PowerSource;
import com.tutorial.robot.components.impl.Battery;

@Test(groups = "unit")
public class MoveCommandTest
{
    @Test
    public void testCommand()
    {
        int distanceInMeters = 3500; // 3.5 KM

        PowerSource powerSource = new Battery();
        powerSource.charge(100.0f); // fully charged
        Robot robot = Helper.createRobot(powerSource);

        Assert.assertEquals(robot.getRemainingPower(), 100.0f);

        Command command = new MoveCommand(robot, distanceInMeters);
        command.execute();

        float actualRemainingPower = robot.getRemainingPower();
        float expectedRemainingPower = 30.0f; // 70% power consumed
        Assert.assertEquals(actualRemainingPower, expectedRemainingPower);
    }
}
