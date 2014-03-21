/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.subsystems.Shooter;

/**
 *
 * @author kevin
 */
public class TriggerCommand extends CommandBase {

    int raw, averageRaw;
    double volts, averageVolts;
    double direction;
    final double DEADBAND = .5;
    boolean done = false;

    public TriggerCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {

        while (shooter.potentiometer.getAverageValue() < Shooter.TRIGGER_SETPOINT) {
            shooter.setTrigger(1);
        }
        shooter.setTrigger(0);
        while (shooter.potentiometer.getAverageValue() > Shooter.TRIGGER_SETPOINT_2) {
            shooter.setTrigger(-1);
        }
        shooter.setTrigger(0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//        if (Math.abs(shooter.potentiometer.getAverageValue() - Shooter.TRIGGER_SETPOINT_2) < DEADBAND) {
//
//            shooter.setTrigger(0);
//            done = true;
//        }
//        if (shooter.triggerEncoder.get() > DEADBAND) {
//            direction = 1;
//        }
//        if (shooter.triggerEncoder.get() < DEADBAND) {
//            direction = -1;
//        }
//        shooter.setTrigger(.6 * direction);
        done = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return done;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}