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
        

        shooter.setTrigger(1);
        Timer.delay(.8);
        shooter.setTrigger(-1);
        Timer.delay(.43);
    }

    // Called repeatedly when this Command is scheduled to run
 protected void execute() {
       
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