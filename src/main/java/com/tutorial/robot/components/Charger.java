
package com.tutorial.robot.components;

import com.tutorial.robot.exceptions.OverChargedException;

public interface Charger extends Component
{
    void charge(PowerSource powerSource, float powerLevel) throws OverChargedException;

}
