/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;

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
        Victor triggerMotor = new Victor(4);
        //A 1 B 2 
        Joystick controller = new Joystick(1);
        //boolean buttonA = controller.getRawButton(1);
        //boolean buttonB = controller.getRawButton(2);
        DigitalInput limitSwitch = new DigitalInput(1);
        while(true){
            Timer.delay(0.05);
//            if(controller.getRawButton(1)) {
//                windowMotor.set(0.8);
//            } else if (controller.getRawButton(2)) {
//                windowMotor.set(-0.8);
//            } else {
//                windowMotor.set(0);
//            }
            if(controller.getRawButton(1)) {
//                triggerMotor.set(-1);
//                Timer.delay(0.1);
//                while(limitSwitch.get() != false || controller.getRawButton(4)) {
//                    Timer.delay(0.05);
//                }
//                triggerMotor.set(1); 
//                while(limitSwitch.get() != false || controller.getRawButton(4)) {
//                    Timer.delay(0.05);
//                }
//                triggerMotor.set(0);
                triggerMotor.set(-0.7);
                
            } else {
                triggerMotor.set(0);
            }
        }
    }
    
    /**
     * This function is called once each time the robot enters test mode.
     */
    public void test() {
    
    }
}
