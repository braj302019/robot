
package com.tutorial.robot.exceptions;

import com.tutorial.robot.components.Carrier;

@SuppressWarnings("serial")
public class ItemOverloadException extends CarrierException
{
    public ItemOverloadException(float weight)
    {
        super("Item is over loaded. Actual weight: " + weight + " and Max allowed weight: " + Carrier.MAX_ALLOWED_WEIGHT);
    }
}
