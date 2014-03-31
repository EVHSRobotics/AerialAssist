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
    double direction;
    final double DEADBAND = 10;
    boolean done = false;
    double fTime = 1, bTime = 1;

    public TriggerCommand(double fT, double bT) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        fTime = fT;
        bTime = bT;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("Trigger Forward");
        shooter.setTrigger(-1);
        Timer.delay(fTime);
        System.out.println("Trigger Backward");
        shooter.setTrigger(1);
        Timer.delay(bTime);
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
//        if (Math.abs(shooter.triggerPot.getAverageValue() - Shooter.TRIGGER_START) < DEADBAND) {
//
//            shooter.setTrigger(0);
//            done = true;
//        }
//        if (shooter.triggerPot.getAverageValue() > DEADBAND) {
//            direction = 1;
//        }
//        if (shooter.triggerPot.getAverageValue() < -DEADBAND) {
//            direction = -1;
//        }
//        shooter.setTrigger(.5 * direction);
//        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
       // System.out.println("Final Pot: " + shooter.triggerPot.getAverageValue());
        
        shooter.setTrigger(0);
             shooter.triggerRunning = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        
        shooter.setTrigger(0);
             shooter.triggerRunning = false;
    }
}