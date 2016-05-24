
package com.tutorial.robot.components;

import com.tutorial.robot.exceptions.OverChargedException;
import com.tutorial.robot.exceptions.UnderChargedException;

public interface PowerSource extends Component
{
    float MIN_POWER_LEVEL = 0;
    float WARNING_POWER_LEVEL = 15;
    float MAX_POWER_LEVEL = 100;
    float POWER_CONSUMED_PER_METER = 0.02F;
    float POWER_CONSUMED_PER_KG = 0.002F;

    float getPower();

    void consume(float power) throws UnderChargedException;

    void charge(float power) throws OverChargedException;
}
