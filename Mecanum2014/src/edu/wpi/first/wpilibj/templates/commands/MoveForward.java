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
public class MoveForward extends CommandBase {
    
    public MoveForward() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        driveTrain.backLeft.set(.3);
        driveTrain.backRight.set(-.3);
        driveTrain.frontLeft.set(.3);
        driveTrain.frontRight.set(-.3);
        setTimeout(.5);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
                driveTrain.backLeft.set(0);
        driveTrain.backRight.set(0);
        driveTrain.frontLeft.set(0);
        driveTrain.backRight.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
                driveTrain.backLeft.set(0);
        driveTrain.backRight.set(0);
        driveTrain.frontLeft.set(0);
        driveTrain.backRight.set(0);
    }
}
