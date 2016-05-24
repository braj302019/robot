
package com.tutorial.robot.components;

import com.tutorial.robot.exceptions.CarrierException;
import com.tutorial.robot.item.Item;

public interface Carrier extends Component
{
    float MAX_ALLOWED_WEIGHT = 10000;// weight in grams

    void carry(Item item, Mover mover, PowerSource powerSource, int meters) throws CarrierException;

}