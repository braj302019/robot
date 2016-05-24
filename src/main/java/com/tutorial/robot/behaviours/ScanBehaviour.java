
package com.tutorial.robot.behaviours;

import com.tutorial.robot.exceptions.ScannerException;
import com.tutorial.robot.item.HasBarCode;

public interface ScanBehaviour
{
    String scan(HasBarCode item) throws ScannerException;
}
