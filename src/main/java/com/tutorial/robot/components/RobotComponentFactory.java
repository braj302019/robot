
package com.tutorial.robot.components;

import com.tutorial.robot.components.impl.BarCodeScanner;
import com.tutorial.robot.components.impl.Battery;
import com.tutorial.robot.components.impl.ElectricCharger;
import com.tutorial.robot.components.impl.ItemCarrier;
import com.tutorial.robot.components.impl.LEDDisplay;
import com.tutorial.robot.components.impl.LightBulb;
import com.tutorial.robot.components.impl.WheelMover;

public class RobotComponentFactory extends ComponentFactory
{

    @Override
    public Scanner createScanner()
    {
        return new BarCodeScanner();
    }

    @Override
    public Mover createMover()
    {
        return new WheelMover();
    }

    @Override
    public Carrier createCarrier(Mover mover)
    {
        return new ItemCarrier(mover);
    }

    @Override
    public Charger createCharger()
    {
        return new ElectricCharger();
    }

    @Override
    public Display createDisplay()
    {
        return new LEDDisplay();
    }

    @Override
    public Bulb createHeadLightBulb()
    {
        return new LightBulb();
    }

    @Override
    public PowerSource createPowerSource()
    {
        return new Battery();
    }

}
