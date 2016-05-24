
package com.tutorial.robot.behaviours;

import com.tutorial.robot.exceptions.CarrierException;
import com.tutorial.robot.item.Item;

public interface CarryBehaviour
{
    void carry(Item item, int meters) throws CarrierException;
}
