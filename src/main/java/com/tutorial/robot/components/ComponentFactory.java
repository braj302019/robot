
package com.tutorial.robot.components;

public abstract class ComponentFactory
{
    public abstract PowerSource createPowerSource();

    public abstract Scanner createScanner();

    public abstract Mover createMover();

    public abstract Carrier createCarrier();

    public abstract Charger createCharger();

    public abstract Display createDisplay();

    public abstract Bulb createHeadLightBulb();
}
