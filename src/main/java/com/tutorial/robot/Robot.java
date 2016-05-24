
package com.tutorial.robot;

import org.apache.commons.lang3.Validate;

import com.tutorial.robot.awares.HeadLightStatusAware;
import com.tutorial.robot.awares.PowerConsumptionAware;
import com.tutorial.robot.behaviours.CarryBehaviour;
import com.tutorial.robot.behaviours.ChargeBehaviour;
import com.tutorial.robot.behaviours.DisplayBehaviour;
import com.tutorial.robot.behaviours.MoveBehaviour;
import com.tutorial.robot.behaviours.ScanBehaviour;
import com.tutorial.robot.components.Bulb;
import com.tutorial.robot.components.Bulb.Color;
import com.tutorial.robot.components.Bulb.Status;
import com.tutorial.robot.components.Carrier;
import com.tutorial.robot.components.Charger;
import com.tutorial.robot.components.Display;
import com.tutorial.robot.components.Mover;
import com.tutorial.robot.components.PowerSource;
import com.tutorial.robot.components.Scanner;
import com.tutorial.robot.exceptions.CarrierException;
import com.tutorial.robot.exceptions.ComponentNotFoundException;
import com.tutorial.robot.exceptions.MoverException;
import com.tutorial.robot.exceptions.OverChargedException;
import com.tutorial.robot.exceptions.ScanFailureException;
import com.tutorial.robot.item.HasBarCode;
import com.tutorial.robot.item.Item;

public class Robot implements PowerConsumptionAware, HeadLightStatusAware, ScanBehaviour, MoveBehaviour, CarryBehaviour, DisplayBehaviour, ChargeBehaviour
{
    private PowerSource powerSource;

    private Display display;
    private Charger charger;
    private Bulb headLightBulb;

    private Scanner scanner;
    private Mover mover;
    private Carrier carrier;

    public static class RobotBuilder
    {
        private Robot instance = new Robot();

        public RobotBuilder withPowerSource(PowerSource powerSource)
        {
            Validate.notNull(powerSource, "Power source must not be null");
            instance.powerSource = powerSource;
            return this;
        }

        public RobotBuilder withDisplay(Display display)
        {
            Validate.notNull(display, "Display must not be null");
            instance.display = display;
            return this;
        }

        public RobotBuilder withCharger(Charger charger)
        {
            Validate.notNull(charger, "Charger must not be null");
            instance.charger = charger;
            return this;
        }

        public RobotBuilder withScanner(Scanner scanner)
        {
            Validate.notNull(scanner, "Scanner must not be null");
            instance.scanner = scanner;
            return this;
        }

        public RobotBuilder withMover(Mover mover)
        {
            Validate.notNull(mover, "Mover must not be null");
            instance.mover = mover;
            return this;
        }

        public RobotBuilder withCarrier(Carrier carrier)
        {
            Validate.notNull(carrier, "Carrier must not be null");
            instance.carrier = carrier;
            return this;
        }

        public RobotBuilder withHeadLightBulb(Bulb bulb)
        {
            Validate.notNull(bulb, "Head Light Bulb must not be null");
            instance.headLightBulb = bulb;
            return this;
        }

        public Robot build() throws ComponentNotFoundException
        {
            if (instance.powerSource == null)
            {
                throw new ComponentNotFoundException("Power Source");
            }
            else if (instance.display == null)
            {
                throw new ComponentNotFoundException("Display");
            }
            else if (instance.charger == null)
            {
                throw new ComponentNotFoundException("Charger");
            }
            else if (instance.headLightBulb == null)
            {
                throw new ComponentNotFoundException("Head Light Blub");
            }
            return instance;
        }
    }

    @Override
    public String scan(HasBarCode item) throws ScanFailureException
    {
        if (scanner == null)
        {
            throw new ScanFailureException("Scanner is not attached");
        }

        return scanner.scan(item);
    }

    @Override
    public void move(int meters) throws MoverException
    {
        if (mover == null)
        {
            throw new MoverException("Mover is not attached");
        }
        mover.move(powerSource, meters);
        updateHeadLightBlub();
    }

    @Override
    public void carry(Item item, int meters) throws CarrierException
    {
        if (carrier == null)
        {
            throw new CarrierException("Carrier is not attached");
        }
        else if (mover == null)
        {
            throw new CarrierException("Mover is not attached");
        }
        carrier.carry(item, mover, powerSource, meters);
        updateHeadLightBlub();
    }

    @Override
    public void display(String message)
    {
        display.display(message);
    }

    @Override
    public void charge(float powerLevel) throws OverChargedException
    {
        charger.charge(powerSource, powerLevel);
        updateHeadLightBlub();
    }

    @Override
    public float getRemainingPower()
    {
        return powerSource.getPower();
    }

    @Override
    public Status getHeadLightBlubStatus()
    {
        return headLightBulb.getStatus();
    }

    private void updateHeadLightBlub()
    {
        if (getRemainingPower() < PowerSource.WARNING_POWER_LEVEL)
        {
            this.headLightBulb.turnOn(Color.RED);
            display("WARNING: Battery running low, charge it soon");
        }
        else
        {
            this.headLightBulb.turnOff();
        }
    }

}
