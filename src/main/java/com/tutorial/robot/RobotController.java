
package com.tutorial.robot;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.tutorial.robot.commands.Command;
import com.tutorial.robot.exceptions.CommandFailureException;

public class RobotController
{
    private RobotController()
    {}

    private static class RobotControllerHolder
    {
        private static final RobotController INSTANCE = new RobotController();
    }

    public static RobotController getInstance()
    {
        return RobotControllerHolder.INSTANCE;
    }

    private Queue<Command> commands = new ConcurrentLinkedQueue<Command>();

    public void addCommand(Command command)
    {
        commands.offer(command);
    }

    public void executeCommands() throws CommandFailureException
    {
        while (!commands.isEmpty())
        {
            commands.poll().execute();
        }
    }
}
