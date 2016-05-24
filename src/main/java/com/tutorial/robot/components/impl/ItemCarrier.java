
package com.tutorial.robot.components.impl;

import com.tutorial.robot.components.Carrier;
import com.tutorial.robot.components.Mover;
import com.tutorial.robot.components.PowerSource;
import com.tutorial.robot.exceptions.CarrierException;
import com.tutorial.robot.exceptions.ItemOverloadException;
import com.tutorial.robot.exceptions.UnderChargedException;
import com.tutorial.robot.item.Item;

public class ItemCarrier implements Carrier
{
    @Override
    public void carry(Item item, Mover mover, PowerSource powerSource, int meters) throws CarrierException
    {
        if (item.getWeight() > MAX_ALLOWED_WEIGHT)
        {
            throw new ItemOverloadException(item.getWeight());
        }

        mover.move(powerSource, meters);

        try
        {
            float weightInKg = item.getWeight() / 1000;
            float powerConsumed = PowerSource.POWER_CONSUMED_PER_KG * weightInKg * meters;
            powerSource.consume(powerConsumed);
        }
        catch (UnderChargedException e)
        {
            throw new CarrierException("Failed to carry", e);
        }
    }

    @Override
    public String name()
    {
        return "Item Carrier";
    }

}
