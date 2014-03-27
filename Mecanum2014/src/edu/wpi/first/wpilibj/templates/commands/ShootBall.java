/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.templates.subsystems.Shooter;
import edu.wpi.first.wpilibj.templates.commands.TriggerCommand;

/**
 *
 * @author Justin
 */
public class ShootBall extends CommandBase {
    NetworkTable values;
    double pickUpSpeed = .6;
    double shootingSpeed = 1;
    double triggerTime = 1;
    double armSpeed = 1;
    public final double DEADBAND = 0.1;

    public ShootBall() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        
         values = NetworkTable.getTable("SmartDashboard");
         values.putNumber("PickUp", pickUpSpeed);
         values.putNumber("Shooting", shootingSpeed);
         values.putNumber("TriggerTime", triggerTime);
         values.putNumber("ArmSpeed", armSpeed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

        //if(oi.controller.getRawButton(2)){
        //  shooter.quadEncoder.reset();
        //}

//        if (oi.getLB()) {
//            System.out.println("arm stop");
//            shooter.armStop();
//        }
        if (oi.getStart()) {
//            shooter.setSetpoint(Shooter.START);
//            System.out.println("go to start");
            pickUpSpeed = values.getNumber("PickUp", .6);
            shootingSpeed = values.getNumber("Shooting", 1);
            triggerTime = values.getNumber("TriggerTime" , 1);
            armSpeed = values.getNumber("ArmSpeed" , 1);
            System.out.println("P: " + pickUpSpeed + " S: " + shootingSpeed + " T: " + triggerTime
            + " A: " + armSpeed);
        }
//            shooter.setSetpoint(Shooter.START);
//            System.out.println("go to start");

        if (oi.getA()) {
            shooter.setSetpoint(Shooter.PICKUP);
            shooter.shoot(-pickUpSpeed);
            System.out.println("button: A");
        } else if (oi.getX()) {
            shooter.setSetpoint(Shooter.SHOOTING1);
            shooter.shoot(shootingSpeed);
            System.out.println("button: X");
        } else if (oi.getY()) {
//            shooter.setSetpoint(Shooter.SHOOTING2);
//            shooter.shoot(0.9);
            shooter.armMotor.set(armSpeed);
            System.out.println("button: Y");
        } else if (oi.getB()) {
            shooter.armMotor.set(-armSpeed);
//            shooter.setSetpoint(Shooter.PASSING);
//            shooter.shoot(0.85);
            System.out.println("button: B");
        } else {
            shooter.shoot(0);
        }

        {if (oi.getRB()) {
////            
//////            System.out.println("Starting Pot: " + shooter.triggerPot.getAverageValue());
//            Scheduler.getInstance().add(new TriggerCommand(triggerTime));
            shooter.launchMotor.set(-1);
            System.out.println("RB Pressed");
        }    
        else if (oi.getLB()){
            shooter.launchMotor.set(.7);
            
            System.out.println("LB Pressed");
        }
        else {
            shooter.launchMotor.set(0);
        }}
        
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
