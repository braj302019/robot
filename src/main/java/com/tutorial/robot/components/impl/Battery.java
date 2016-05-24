
package com.tutorial.robot.components.impl;

import com.tutorial.robot.components.PowerSource;
import com.tutorial.robot.exceptions.OverChargedException;
import com.tutorial.robot.exceptions.UnderChargedException;

public class Battery implements PowerSource
{
    private float power;

    @Override
    public float getPower()
    {
        return power;
    }

    @Override
    public void consume(float power) throws UnderChargedException
    {
        if (this.power - power < PowerSource.MIN_POWER_LEVEL)
        {
            throw new UnderChargedException(power, this.power);
        }
        this.power -= power;
    }

    @Override
    public void charge(float power) throws OverChargedException
    {
        if (this.power + power > PowerSource.MAX_POWER_LEVEL)
        {
            throw new OverChargedException();
        }
        this.power += power;

    }

    @Override
    public String name()
    {
        return "Battery";
    }
}
