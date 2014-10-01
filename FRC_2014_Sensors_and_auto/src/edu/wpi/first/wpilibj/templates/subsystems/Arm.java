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
public AnalogChannel armPot; //sensor for arm
public Victor armMotor; //motor for arm
    
//various constants for arm position (values given by sensor) - untested
    public static final int START = 0,
            SHOOTING1 = 2000,
            SHOOTING2 = 3600,
            PASSING = 25,
            PICKUP = -2000,
            TOLERANCE = 50;
    
    //values for sensor keeping arm position
    public double position, //current position of arm
            oldArmReading, //previous reading of sensor
            newArmReading,//current reading of sensor
            numberOfArmCycles; //number of full rotations sensor has recorded
    
    public static boolean armMoving; //tells whether the arm is moving
    public Arm(){ 
        armMotor = new Victor(RobotMap.ARM_MOTOR); //creates motor
        armPot = new AnalogChannel(RobotMap.ARM_POT_PORT); //creates sensor
        oldArmReading = armPot.getAverageValue(); //gives initial value of sensor
        numberOfArmCycles = 0; //resets number of cycles
    }
    public void initDefaultCommand() {
    }
    
    public double returnArmPosition() {
        newArmReading = armPot.getAverageValue(); //gets current value of sensor

        if (Math.abs(newArmReading - oldArmReading) > 450) { //if there is a large difference between old and new 
                                            //values - our potentiometer could only record values between 0 and 960
            if ((newArmReading - oldArmReading) > 450) { //if the new is greater than the old (arm went from 0 to 960)
                numberOfArmCycles--; //decrement arm cycles
               System.out.println("Increment Down" + " N: " +newArmReading + " O: "+ oldArmReading); //diagnostic
            } else if ((newArmReading - oldArmReading) < -450) { //if new is less than old (arm went from 960 to 0)
                numberOfArmCycles++; //increment arm cycles
               System.out.println("Increment Up" + " N: " +newArmReading + " O: "+ oldArmReading); //diagnostic
            }
        }
        position = 960 * numberOfArmCycles + newArmReading; //calculate position based on number of cycles and current reading
        oldArmReading = newArmReading; //put current reading as old reading
        return position; //give value

    }
}
