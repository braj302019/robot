
package com.tutorial.robot.components.impl;

import com.tutorial.robot.components.Mover;
import com.tutorial.robot.components.PowerSource;
import com.tutorial.robot.exceptions.MoverException;
import com.tutorial.robot.exceptions.UnderChargedException;

public class WheelMover implements Mover
{

    @Override
    public void move(PowerSource powerSource, int meters)

    {
        try
        {
            float powerConsumed = PowerSource.POWER_CONSUMED_PER_METER * meters;
            powerSource.consume(powerConsumed);
        }
        catch (UnderChargedException e)
        {
            throw new MoverException("Failed to move", e);
        }
    }

    @Override
    public String name()
    {
        return "Wheel Mover";
    }

}
