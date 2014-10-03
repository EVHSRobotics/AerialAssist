/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author kevin
 */
public class TriggerFire extends CommandBase {

    public TriggerFire() {
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

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {

        shooter.setTrigger(0);
        shooter.triggerRunning = false;
    }
}
