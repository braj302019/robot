
package com.tutorial.robot.behaviours;

import com.tutorial.robot.exceptions.MoverException;

public interface MoveBehaviour
{
    void move(int meters) throws MoverException;
}
