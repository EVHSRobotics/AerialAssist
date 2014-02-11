/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.templates.subsystems.Shooter;

/**
 *
 * @author Justin
 */
public class ShootBall extends CommandBase {
    double speed = .6;
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
        
        if(oi.controller.getRawButton(1)){
            System.out.println("arm should stop right now. if it doesn't we are screwed");
            shooter.armStop();
        } 
        
        if(oi.controller.getRawButton(6)){ //right trigger
            if( shooter.getSetpoint() == Shooter.START) {
                System.out.println("go to finish");
                shooter.setSetpoint(Shooter.FINISH);
            } else if (shooter.getSetpoint() == Shooter.FINISH) {
                shooter.setSetpoint(Shooter.START);
                System.out.println("go to start");
            }
        } 
        if (oi.controller.getRawButton(3)){
            speed -= .1; 
            System.out.println("S: " +speed);
        }
        if (oi.controller.getRawButton(4)){
            speed += .1;
            System.out.println("S: " +speed);
        }
        
        if (oi.controller.getRawAxis(3) > DEADBAND) {
            shooter.shoot(1);
            System.out.println("the ball should have launched");
        } else if (oi.controller.getRawAxis(3) < -DEADBAND) {
            shooter.shoot(-.6);
            System.out.println("pick up the ball");
        } else {
            shooter.shoot(0);
        }
        
        Timer.delay(.1);
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
