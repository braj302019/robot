
package com.tutorial.robot.components;

import com.tutorial.robot.exceptions.MoverException;

public interface Mover extends Component
{
    void move(PowerSource powerSource, int meters) throws MoverException;
}
