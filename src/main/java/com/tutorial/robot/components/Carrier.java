
package com.tutorial.robot.components;

import com.tutorial.robot.exceptions.CarrierException;
import com.tutorial.robot.item.Item;

public interface Carrier extends Mover
{
    float MAX_ALLOWED_WEIGHT = 10000;// weight in grams

    float carry(Item item, int meters) throws CarrierException;

}