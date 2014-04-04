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

    int raw, averageRaw;
    double volts, averageVolts;
    double direction, difference, pos, init;
    final double DEADBAND = 10, TOLERANCE = 50;
    boolean done = false;
    double fTime = 1, bTime = 1;
    int count;
    public TriggerCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);

    }

    // Called just before this Command runs the first time
    protected void initialize() {
        
        init = shooter.triggerPot.getAverageValue();
        pos = init;
        System.out.println("Trigger Forward");
        shooter.setTrigger(1);
        System.out.println("Init: " + init);
        while ((pos < (Shooter.TRIGGER_END + init)) && (count < 22)){
            pos = shooter.returnTriggerPosition();
            System.out.println("P: " + pos);
           System.out.println("F: " + arm.armMotor.get());
            count++;
            System.out.println("C: " +count);
            Timer.delay(.05);
            
        }
        //Timer.delay(fTime);
        System.out.println("Trigger Backward");
        shooter.setTrigger(-1);
        count = 0;
        while (pos > (shooter.initialTriggerPos) && (count < 22)){
            pos = shooter.returnTriggerPosition();
            System.out.println("P: " + pos);
            
           System.out.println("F: " + arm.armMotor.get());
            count++;
            System.out.println("C: " +count);
            Timer.delay(.05);
        }
        //Timer.delay(bTime);
        System.out.println("Trigger Finished");
        shooter.setTrigger(0);
        shooter.triggerRunning = false;
//
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
 protected void execute() {
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
//         return (Math.abs(difference ) < TOLERANCE);
       }
    // Called once after isFinished returns true
    protected void end() {
       // System.out.println("Final Pot: " + shooter.triggerPot.getAverageValue());
        
        shooter.setTrigger(0);
             shooter.triggerRunning = false;
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

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        
        shooter.setTrigger(0);
             shooter.triggerRunning = false;
    }
}