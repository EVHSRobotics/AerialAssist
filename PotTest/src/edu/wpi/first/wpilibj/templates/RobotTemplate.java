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
    int raw, averageRaw;
    double volts, averageVolts;
    public void autonomous() {
        
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {
        AnalogChannel potentiometer = new AnalogChannel(2); //clockwise positive; lowest ~475, highest ~961
        while (true){
            System.out.println("1");
            raw = potentiometer.getValue();
            System.out.println("2");
            volts = potentiometer.getVoltage();
            System.out.println("3");
            averageRaw = potentiometer.getAverageValue();
            System.out.println("4");
            averageVolts = potentiometer.getAverageVoltage();
            
            
            System.out.println("R: " + raw + " V: " + volts + " AR: " + averageRaw + " AV: " + averageVolts);
            Timer.delay(.1);
//            
//            potentiometer.setAccumulatorInitialValue(0);
//            potentiometer.setAccumulatorCenter(500);
//            potentiometer.setAccumulatorDeadband(10);
//            potentiometer.resetAccumulator();
        }
    }
    
    /**
     * This function is called once each time the robot enters test mode.
     */
    public void test() {
    
    }
}
