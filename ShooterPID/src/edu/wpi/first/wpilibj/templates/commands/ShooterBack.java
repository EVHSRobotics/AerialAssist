/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.subsystems.Shooter;

/**
 *
 * @author Justin
 */
public class ShooterBack extends CommandBase {
    
    public ShooterBack() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
         requires(shooterSub);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("Backwards");
         shooterSub.setSetpoint(shooterSub.START);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        //System.out.println("ErrorB: " +Math.abs((shooterSub.getSetpoint() - shooterSub.getPosition())));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        System.out.println("Finished B");
        return Math.abs(shooterSub.getSetpoint() - shooterSub.getPosition()) < (Shooter.TOLERANCE);
    }

    // Called once after isFinished returns true
    protected void end() {
          System.out.println("finished");
        shooterSub.shooterMotor.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        shooterSub.shooterMotor.set(0);
    }
}
