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
public class TestMotor extends CommandBase {
    
    public TestMotor() {
        requires(shooterSub);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("go");
        shooterSub.shooterMotor.set(.25);
        Timer.delay(.5);
        shooterSub.shooterMotor.set(0);
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
        shooterSub.shooterMotor.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        shooterSub.shooterMotor.set(0);
    }
}
