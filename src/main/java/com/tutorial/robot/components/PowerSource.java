
package com.tutorial.robot.components;

import java.io.InputStream;
import java.util.Properties;

import com.tutorial.robot.exceptions.OverChargedException;
import com.tutorial.robot.exceptions.UnderChargedException;

public interface PowerSource extends Component
{
    Properties CONFIG = loadPowerConfiguration();

    float MIN_POWER_LEVEL = getProperty("MIN_POWER_LEVEL");
    float WARNING_POWER_LEVEL = getProperty("WARNING_POWER_LEVEL");
    float MAX_POWER_LEVEL = getProperty("MAX_POWER_LEVEL");
    float POWER_CONSUMED_PER_METER = getProperty("POWER_CONSUMED_PER_METER");
    float POWER_CONSUMED_PER_KG_PER_METER = getProperty("POWER_CONSUMED_PER_KG_PER_METER");

    static Properties loadPowerConfiguration()
    {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Properties props = new Properties();
        try (InputStream resourceStream = loader.getResourceAsStream("config.properties"))
        {
            props.load(resourceStream);
            return props;
        }
        catch (Exception e)
        {
            throw new ExceptionInInitializerError("failed to load config.properties");
        }
    }

    static float getProperty(String key)
    {
        if (!CONFIG.containsKey(key))
        {
            throw new ExceptionInInitializerError("failed to load config property " + key);
        }
        return Float.parseFloat(CONFIG.getProperty(key));
    }

    float getPower();

    void consume(float power) throws UnderChargedException;

    void charge(float power) throws OverChargedException;
}
