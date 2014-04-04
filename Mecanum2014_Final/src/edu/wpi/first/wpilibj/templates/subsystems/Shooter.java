/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.ControlShooter;

/**
 *
 * @author kevin
 */
public class Shooter extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public Victor leftCim;
    public Victor rightCim;
    public Victor armMotor;
    public Victor launchMotor;
    public AnalogChannel triggerPot;
    public AnalogChannel armPot;
    public static final int 
            TRIGGER_START = 73, //Encoder axle from inside turning clockwise is positive 771?
            TRIGGER_END = 720; //other pot 500-900
    public int initialTriggerPos;
    public static final double TOLERANCE = 50, MINRATE = .2;
    public boolean triggerRunning;
    public double position,   oldTriggerReading,
            newTriggerReading, numberOfTriggerCycles;

    public Shooter() {
        leftCim = new Victor(RobotMap.LEFT_SHOOT_MOTOR);
        rightCim = new Victor(RobotMap.RIGHT_SHOOT_MOTOR);
        launchMotor = new Victor(RobotMap.LAUNCH_MOTOR);
     
        triggerPot = new AnalogChannel(RobotMap.TRIGGER_POT_PORT); //don't plug into port 8; clockwise positive; lowest ~475, highest ~961
        initialTriggerPos = triggerPot.getAverageValue();
        System.out.println("Initial Trigger Position:" + initialTriggerPos);
        oldTriggerReading = triggerPot.getAverageValue();
        numberOfTriggerCycles = 0;

    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new ControlShooter());
    }



    
    public double returnTriggerPosition() {
        newTriggerReading = triggerPot.getAverageValue();

        if (Math.abs(newTriggerReading - oldTriggerReading) > 450) {
            if ((newTriggerReading - oldTriggerReading) > 450) {
                numberOfTriggerCycles--;
               System.out.println("Increment Down" + " N: " +newTriggerReading + " O: "+ oldTriggerReading);
            } else if ((newTriggerReading - oldTriggerReading) < -450) {
                numberOfTriggerCycles++;
               System.out.println("Increment Up" + " N: " +newTriggerReading + " O: "+ oldTriggerReading);
            }
        }
        position = 960 * numberOfTriggerCycles + newTriggerReading;
        oldTriggerReading = newTriggerReading;
        //System.out.println("P: " +position);
        //System.out.println("Position: " + position + " Reading:" +newArmReading);
        return position; 

    }    

    public double getSign(double f) {
        if (f != f) {
            throw new IllegalArgumentException("NaN");
        }
        if (f == 0) {
            return 0;
        }
        f *= Double.POSITIVE_INFINITY;
        if (f == Double.POSITIVE_INFINITY) {
            return +1;
        }
        if (f == Double.NEGATIVE_INFINITY) {
            return -1;
        }

        //this should never be reached, but I've been wrong before...
        throw new IllegalArgumentException("Unfathomed double");
    }

    public void shoot(double speed) {
        leftCim.set(speed);
        rightCim.set(-speed);
    }


    public void setTrigger(double value) {
        launchMotor.set(value);
    }

}
