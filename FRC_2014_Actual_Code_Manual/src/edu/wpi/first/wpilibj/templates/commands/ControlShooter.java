/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.templates.subsystems.Arm;

/**
 *
 * @author Justin
 */
public class ControlShooter extends CommandBase {

    NetworkTable values;
    double pickUpSpeed = .8;
    double shootingSpeed = 1;
    double fTime = 1;
    double bTime = .5;
    double armSpeed = .7;
    double driveForwardTime = driveTrain.driveTime;
    public final double DEADBAND = 0.1;
    double initialTriggerPos;

    public ControlShooter() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        initialTriggerPos = shooter.returnTriggerPosition();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //System.out.println("Arm: " + arm.returnArmPosition());
        if (oi.getStart()) {
        }

        {
            if (oi.getA()) {
                shooter.shoot(-pickUpSpeed);
                System.out.println("button: A");
            } else if (oi.getX()) {
                shooter.shoot(shootingSpeed);
                System.out.println("button: X");
            } else {
                shooter.shoot(0);
            }
        }
        if (oi.getBack()) {
            driveTrain.gyro.reset();
            System.out.println("Gyro Reset");
        }
        {
            if (oi.getY()) {
                arm.armMotor.set(-armSpeed);
                System.out.println("button: Y");
                System.out.println("Arm Position" + arm.returnArmPosition());
            } else if (oi.getB()) {
                arm.armMotor.set(armSpeed);
                System.out.println("button: B");
                System.out.println("Arm Position" + arm.returnArmPosition());
            } else {
               arm.armMotor.set(0); 
            }
        }

        { if (oi.getRB() && !(shooter.triggerRunning)) {
           shooter.triggerRunning = true;
            Scheduler.getInstance().add(new TriggerCommand());
            System.out.println("RB Pressed");
        }
        if (oi.getLB() && !(shooter.triggerRunning)){
            shooter.triggerRunning=true;
            Scheduler.getInstance().add(new MoveTrigger());
            System.out.println("LB Pressed");
        }
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
