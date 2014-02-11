/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.templates.subsystems.Shooter;

/**
 *
 * @author Justin
 */
public class ShootBall extends CommandBase {
    
    public final double DEADBAND = 0.1;
    
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
        
        //if(oi.controller.getRawButton(2)){
          //  shooter.quadEncoder.reset();
        //}
        
        if(oi.getAButton()){
            System.out.println("arm should stop right now. if it doesn't we are screwed");
            shooter.armStop();
        } 
        
        if(oi.getBackRightButton()){ //right trigger
            if( shooter.getSetpoint() == Shooter.START) {
                System.out.println("go to finish");
                shooter.setSetpoint(Shooter.FINISH);
            } else if (shooter.getSetpoint() == Shooter.FINISH) {
                shooter.setSetpoint(Shooter.START);
                System.out.println("go to start");
            }
        } 
        
        if (oi.getTriggers() > DEADBAND) {
            shooter.shoot(1);
            System.out.println("the ball should have launched");
        } else if (oi.getTriggers() < -DEADBAND) {
            shooter.shoot(-0.3);
            System.out.println("pick up the ball");
        } else {
            shooter.shoot(0);
        }
        
        Timer.delay(.5);
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
