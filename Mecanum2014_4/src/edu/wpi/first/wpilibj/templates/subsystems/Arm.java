/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Justin
 */
public class Arm extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
public AnalogChannel armPot;
public Victor armMotor;
    public static final int START = 0,
            SHOOTING1 = 2000,
            SHOOTING2 = 3600,
            PASSING = 25,
            PICKUP = -2000,
            TOLERANCE = 50;
    public double position, oldArmReading, newArmReading, numberOfArmCycles;
    public Arm(){
        armMotor = new Victor(RobotMap.ARM_MOTOR);
                armPot = new AnalogChannel(RobotMap.ARM_POT_PORT);
        oldArmReading = armPot.getAverageValue();
        numberOfArmCycles = 0;
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
        public double returnArmPosition() {
        newArmReading = armPot.getAverageValue();

        if (Math.abs(newArmReading - oldArmReading) > 450) {
            if ((newArmReading - oldArmReading) > 450) {
                numberOfArmCycles--;
               System.out.println("Increment Down" + " N: " +newArmReading + " O: "+ oldArmReading);
            } else if ((newArmReading - oldArmReading) < -450) {
                numberOfArmCycles++;
               System.out.println("Increment Up" + " N: " +newArmReading + " O: "+ oldArmReading);
            }
        }
        position = 960 * numberOfArmCycles + newArmReading;
        oldArmReading = newArmReading;
        //System.out.println("P: " +position);
        //System.out.println("Position: " + position + " Reading:" +newArmReading);
        return position; 

    }
}
