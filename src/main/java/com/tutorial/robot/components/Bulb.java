
package com.tutorial.robot.components;

import com.tutorial.robot.exceptions.LightBulbException;

public interface Bulb extends Component
{
    enum Color
    {
        RED, GREEN, NONE
    }

    enum Status
    {
        ON, OFF
    }

    void turnOn(Color color) throws LightBulbException;

    void turnOff() throws LightBulbException;

    Status getStatus();

    Color getColor();
}
