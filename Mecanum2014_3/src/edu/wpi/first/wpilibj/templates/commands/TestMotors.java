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
public class TestMotors extends CommandBase {
    
    public TestMotors() {
        requires(driveTrain);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        driveTrain.backLeft.set(1);
        driveTrain.frontLeft.set(1);
        driveTrain.backRight.set(1);
        driveTrain.frontRight.set(1);
        shooter.armMotor.set(1);
        shooter.launchMotor.set(1);
        shooter.leftCim.set(1);
        shooter.rightCim.set(1);
        Timer.delay(2.5);
         driveTrain.backLeft.set(-1);
        driveTrain.frontLeft.set(-1);
        driveTrain.backRight.set(-1);
        driveTrain.frontRight.set(-1);
        shooter.armMotor.set(-1);
        shooter.launchMotor.set(-1);
        shooter.leftCim.set(-1);
        shooter.rightCim.set(-1);
        Timer.delay(2.5);
         driveTrain.backLeft.set(0);
        driveTrain.frontLeft.set(0);
        driveTrain.backRight.set(0);
        driveTrain.frontRight.set(0);
        shooter.armMotor.set(0);
        shooter.launchMotor.set(0);
        shooter.leftCim.set(0);
        shooter.rightCim.set(0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
