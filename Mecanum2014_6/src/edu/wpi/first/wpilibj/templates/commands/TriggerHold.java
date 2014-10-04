/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author Justin
 */
public class TriggerHold extends CommandBase {

    public TriggerHold() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    protected void initialize() {
        System.out.println("BEGIN HOLD");
        shooter.launchMotor.set(1);
        Timer.delay(.8);
        shooter.launchMotor.set(0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        System.out.println("TRIGGER HELD");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !oi.getLB();
    }

    // Called once after isFinished returns true
    protected void end() {
        shooter.setTrigger(-1);
        Timer.delay(.43);
        shooter.setTrigger(0);
        shooter.triggerRunning = false;
        System.out.println("RELEASE HOLD");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        shooter.setTrigger(-1);
        Timer.delay(.43);
        shooter.setTrigger(0);
        shooter.triggerRunning = false;
        System.out.println("RELEASE HOLD");
    }
}
