
package com.tutorial.robot.components.impl;

import com.tutorial.robot.components.Scanner;
import com.tutorial.robot.exceptions.ScanFailureException;
import com.tutorial.robot.item.HasBarCode;

public class BarCodeScanner implements Scanner
{

    @Override
    public String scan(HasBarCode item) throws ScanFailureException
    {
        return item.getBarCode();
    }

    @Override
    public String name()
    {
        return "Barcode Scanner";
    }

}
