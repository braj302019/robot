
package com.tutorial.robot;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tutorial.robot.commands.ChargeCommand;
import com.tutorial.robot.commands.Command;
import com.tutorial.robot.components.impl.Battery;

@Test(groups = "unit")
public class ChargeCommandTest
{
    @Test
    public void testCommand()
    {
        float chargePowerLevel = 60.0f;
        
        Robot robot = Helper.createRobot(new Battery());

        Assert.assertEquals(robot.getRemainingPower(), 0.0f);

        Command command = new ChargeCommand(robot, chargePowerLevel);
        command.execute();

        Assert.assertEquals(robot.getRemainingPower(), chargePowerLevel);
    }
}
