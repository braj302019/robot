
package com.tutorial.robot.components;

import com.tutorial.robot.exceptions.ScanFailureException;
import com.tutorial.robot.item.HasBarCode;

public interface Scanner extends Component
{
    String scan(HasBarCode item) throws ScanFailureException;
}
