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
    
    public Victor leftCim;//left wheel motor
    public Victor rightCim;//right wheel motor
    public Victor launchMotor; //trigger motor
    public AnalogChannel triggerPot;//sensor
    public static final int 
            TRIGGER_START = 73, //Encoder axle from inside turning clockwise is positive 771?
            TRIGGER_END = 720; 
    public int initialTriggerPos; //starting position of trigger
    public static final double TOLERANCE = 50, MINRATE = .2;
    public boolean triggerRunning; //marks if trigger is running
    public double position,   oldTriggerReading,
            newTriggerReading, numberOfTriggerCycles;

    public Shooter() {
        //creates motors
        leftCim = new Victor(RobotMap.LEFT_SHOOT_MOTOR);
        rightCim = new Victor(RobotMap.RIGHT_SHOOT_MOTOR);
        launchMotor = new Victor(RobotMap.LAUNCH_MOTOR);
     
        triggerPot = new AnalogChannel(RobotMap.TRIGGER_POT_PORT); //don't plug into port 8; clockwise positive; lowest ~475, highest ~961
        initialTriggerPos = triggerPot.getAverageValue(); //sets initial value
        System.out.println("Initial Trigger Position:" + initialTriggerPos); //diagnostic
        oldTriggerReading = triggerPot.getAverageValue();//sets old value to initial
        numberOfTriggerCycles = 0;//resets number of cycles to 0

    }

    public void initDefaultCommand() {
        setDefaultCommand(new ControlShooter()); //sets Control Shooter as default command
    }



    
    public double returnTriggerPosition() { //see Arm subsystem's 'returnArmPosition()' (they're the same thing)
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
        return position; 

    }    

    public void shoot(double speed) { //spins motors at certain speed
        leftCim.set(speed);
        rightCim.set(-speed); //inverts one motor so motors spin same direction
    }


    public void setTrigger(double value) { //sets trigger to certain speed
        launchMotor.set(value);
    }

}
