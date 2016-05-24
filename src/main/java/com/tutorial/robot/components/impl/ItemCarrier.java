
package com.tutorial.robot.components.impl;

import org.apache.commons.lang3.Validate;

import com.tutorial.robot.components.Carrier;
import com.tutorial.robot.components.Mover;
import com.tutorial.robot.components.PowerSource;
import com.tutorial.robot.exceptions.CarrierException;
import com.tutorial.robot.exceptions.ItemOverloadException;
import com.tutorial.robot.exceptions.MoverException;
import com.tutorial.robot.exceptions.UnderChargedException;
import com.tutorial.robot.item.Item;

public class ItemCarrier implements Carrier
{
    private final Mover mover;

    public ItemCarrier(Mover mover)
    {
        Validate.notNull(mover, "Mover must not be null");
        this.mover = mover;
    }

    @Override
    public float carry(Item item, int meters) throws CarrierException
    {
        if (item.getWeight() > MAX_ALLOWED_WEIGHT)
        {
            throw new ItemOverloadException(item.getWeight());
        }

        float powerConsumedInMove = mover.move(meters);

        try
        {
            float weightInKg = item.getWeight() / 1000.0f;
            float powerConsumedInCarry = PowerSource.POWER_CONSUMED_PER_KG_PER_METER * weightInKg * meters;
            return powerConsumedInMove + powerConsumedInCarry;
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

    @Override
    public float move(int meters) throws MoverException
    {
        return mover.move(meters);
    }

}
