
package com.tutorial.robot.components;

import com.tutorial.robot.exceptions.MoverException;

public interface Mover extends Component
{
    float move(int meters) throws MoverException;
}
