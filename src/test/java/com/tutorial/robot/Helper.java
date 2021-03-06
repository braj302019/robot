
package com.tutorial.robot;

import com.tutorial.robot.components.Mover;
import com.tutorial.robot.components.PowerSource;
import com.tutorial.robot.components.impl.ElectricCharger;
import com.tutorial.robot.components.impl.ItemCarrier;
import com.tutorial.robot.components.impl.LEDDisplay;
import com.tutorial.robot.components.impl.LightBulb;
import com.tutorial.robot.components.impl.WheelMover;

public abstract class Helper
{
    public static Robot createRobot(PowerSource powerSource)
    {
        Mover mover = new WheelMover();
        Robot robot = new Robot.RobotBuilder().withPowerSource(powerSource).withDisplay(new LEDDisplay()).withCharger(new ElectricCharger())
                .withHeadLightBulb(new LightBulb()).withMover(mover).withCarrier(new ItemCarrier(mover)).build();
        return robot;
    }
}
