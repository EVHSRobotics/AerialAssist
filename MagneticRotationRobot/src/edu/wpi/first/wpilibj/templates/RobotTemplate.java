/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.Timer;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends SimpleRobot {

    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    public void autonomous() {
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {
        int channel = 5;
        AnalogChannel magInput = new AnalogChannel(5);
        magInput.getModule().setSampleRate(50000);
        while (true) {
            int raw = magInput.getValue();
            double volts = magInput.getVoltage();
            int averageRaw = magInput.getAverageValue();
            double averageVolts = magInput.getAverageVoltage();
            
            Timer.delay(.1);
            System.out.println("raw " + raw + " volts " + volts + " aRaw " + averageRaw + " aVolts " + averageVolts);
        }
    }

    /**
     * This function is called once each time the robot enters test mode.
     */
    public void test() {
    }
}
