/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Justin
 */
public class ShootBall extends CommandBase {
    
    public ShootBall() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (oi.getShooting()) {
            shooter.shoot(0.75);
        } else if (oi.getPickingUp()) {
            shooter.shoot(-0.5);
        } else {
            shooter.shoot(0);
        }
        
        if(oi.getShiftingArm()) {
            //dummy code 
            //if(getBottomEncoder) { shooter.moveArm(0.5); } 
            //else if(getTopEncoder) { shooter.moveArm(-0.5); }
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
