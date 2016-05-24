
package com.tutorial.robot.behaviours;

import com.tutorial.robot.exceptions.PowerException;

public interface ChargeBehaviour
{
    void charge(float powerLevel) throws PowerException;

}
