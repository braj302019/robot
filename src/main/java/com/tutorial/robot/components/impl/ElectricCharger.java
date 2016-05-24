
package com.tutorial.robot.components.impl;

import com.tutorial.robot.components.Charger;
import com.tutorial.robot.components.PowerSource;
import com.tutorial.robot.exceptions.OverChargedException;

public class ElectricCharger implements Charger
{

    @Override
    public void charge(PowerSource powerSource, float powerLevel) throws OverChargedException
    {
        if (powerSource.getPower() + powerLevel > 100)
        {
            throw new OverChargedException();
        }
        powerSource.charge(powerLevel);
    }

    @Override
    public String name()
    {
        return "Electric Charger";
    }
}
