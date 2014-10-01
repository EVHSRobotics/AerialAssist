/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.templates.subsystems.Shooter;

/**
 *
 * @author kevin
 */
public class TriggerCommand extends CommandBase {

    int raw, averageRaw; //value returned by sensor
    double direction, difference, pos, init; //values for storing sensor
    //final double DEADBAND = 10, TOLERANCE = 50;
   // double fTime = 1, bTime = 1;
    int count; //used as a sort of timer
    public TriggerCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);

    }

    // Called just before this Command runs the first time
    protected void initialize() {
        pos = shooter.returnTriggerPosition(); //gets initial position of trigger
        System.out.println("Trigger Forward"); //diagnostic
        
        shooter.setTrigger(1); //starts trigger movement
        while ((pos < (Shooter.TRIGGER_END + shooter.initialTriggerPos)) && (count < 22)){ //while position is less than 
       //trigger end position (initial trigger added to be relative) and count is less than 22 (around 1.1 seconds)
            pos = shooter.returnTriggerPosition(); //position is equal to sensor
            
            System.out.println("P: " + pos); //diagnostic
           System.out.println("F: " + arm.armMotor.get()); //diagnostic
           
            count++; //increments cound
            System.out.println("C: " +count); //diagnostic
            Timer.delay(.05); //wait
            
        }
        //Timer.delay(fTime);
        
        System.out.println("Trigger Backward"); //diagnostic
        shooter.setTrigger(-1); //sets trigger to move backwards
        count = 0; //resets counter
        while (pos > (shooter.initialTriggerPos) && (count < 26)){ //while position is greater than starting position
                                                    //and less than count (around 1.3 seconds)
            pos = shooter.returnTriggerPosition(); //position updated to sensor reading
            
            System.out.println("P: " + pos); //diagnostic
           System.out.println("F: " + arm.armMotor.get()); //diagnostic
           
            count++; //increments count
            System.out.println("C: " +count); //diagnostic
            Timer.delay(.05); //wait
        }
        //Timer.delay(bTime);
        System.out.println("Trigger Finished"); //diagnostic
        shooter.setTrigger(0); //stops trigger
        shooter.triggerRunning = false; //marks trigger as stopped
        
//          old algorithm I believe; unused
//        while (shooter.triggerPot.getAverageValue() < Shooter.TRIGGER_END) {
//            shooter.setTrigger(-1);
//            System.out.println(shooter.triggerPot.getAverageValue());
//        }
//        shooter.setTrigger(0);
//        while (shooter.triggerPot.getAverageValue() > Shooter.TRIGGER_START) {
//            shooter.setTrigger(.7);
//            
//            System.out.println(shooter.triggerPot.getAverageValue());
//        }
//        shooter.setTrigger(0);
    }

    // Called repeatedly when this Command is scheduled to run
 protected void execute() { //untested correction algorithm
//        double position = shooter.returnTriggerPosition();
//           difference = Shooter.START - position;
//            shooter.armMotor.set(getSign(difference));
//            System.out.println("Difference: " + difference);
//            System.out.println("F: " + Shooter.START);
//            System.out.println("P: " + position);
//            System.out.println("O: " + shooter.launchMotor.get());
       
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
         return true;
//         return (Math.abs(difference ) < TOLERANCE); //if execute needs to be run
       }
    // Called once after isFinished returns true
    protected void end() {
       // System.out.println("Final Pot: " + shooter.triggerPot.getAverageValue());
        
        shooter.setTrigger(0); //stops trigger
             shooter.triggerRunning = false; //marks trigger as stopped
    }
     public double getSign(double f) {
        if (f != f) { //if f is not a number
            throw new IllegalArgumentException("NaN"); //diagnostic
        }
        if (f == 0) { //if number is 0
            return 0;
        }
        //else
        f *= Double.POSITIVE_INFINITY; //multiply by infinitely large number
        if (f == Double.POSITIVE_INFINITY) { //if f was positive (positive*positive) = positive
            return +1; //return 1
        }
        if (f == Double.NEGATIVE_INFINITY) { //if f was negative (positive*negative) = negative
            return -1; //return -1
        }

        //this should never be reached
        throw new IllegalArgumentException("Unfathomed double");
    }
     
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        
        shooter.setTrigger(0); //stops trigger
             shooter.triggerRunning = false;//marks trigger as stopped
    }
}