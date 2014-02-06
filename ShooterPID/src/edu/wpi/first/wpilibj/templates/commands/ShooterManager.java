/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 *
 * @author Justin
 */
public class ShooterManager extends CommandBase {
    
    public ShooterManager() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(shooterSub );
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //System.out.println("Z: "+oi.joystick.getRawAxis(3));
        if(oi.joystick.getRawButton(1)){//A
            Scheduler.getInstance().add(new ShooterStop());
            Timer.delay(.5);
        }
        if(oi.joystick.getRawButton(2)){
            shooterSub.quadEncoder.reset();
            Timer.delay(.5);
        }
        if(oi.joystick.getRawAxis(3) < -.5){ //right trigger 
            System.out.println("Right");
            Scheduler.getInstance().add(new ShooterForward());
            Timer.delay(.5);
        }
        if(oi.joystick.getRawAxis(3) > .5){ //left trigger
            System.out.println("Left");
            Scheduler.getInstance().add(new ShooterBack());
            Timer.delay(.5);
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
