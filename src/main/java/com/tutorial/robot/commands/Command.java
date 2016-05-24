
package com.tutorial.robot.commands;

import com.tutorial.robot.exceptions.CommandFailureException;

public interface Command
{
    void execute() throws CommandFailureException;
}
