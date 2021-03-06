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
public class ShootBall extends CommandBase {
    NetworkTable values;
    double pickUpSpeed = .8;
    double shootingSpeed = 1;
    double fTime = 1;
    double bTime = .5;
    double armSpeed = .6;
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
         values.putNumber("TriggerF", fTime);
         values.putNumber("TriggerB" , bTime);
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
            pickUpSpeed = values.getNumber("PickUp", pickUpSpeed);
            shootingSpeed = values.getNumber("Shooting", shootingSpeed);
            fTime = values.getNumber("TriggerF" , fTime);
            bTime = values.getNumber("TriggerB", bTime);
            armSpeed = values.getNumber("ArmSpeed" , armSpeed);
            System.out.println("P: " + pickUpSpeed + " S: " + shootingSpeed + " TF: " + fTime + " TB:"
                    + bTime     + " A: " + armSpeed);
        }
//            shooter.setSetpoint(Shooter.START);
//            System.out.println("go to start");

        {if (oi.getA()) {
            //shooter.setSetpoint(Shooter.PICKUP);
            Scheduler.getInstance().add(new MoveArm(Arm.PICKUP));
            shooter.shoot(-pickUpSpeed);
            System.out.println("button: A");
        } else if (oi.getX()) {
           // shooter.setSetpoint(Shooter.SHOOTING1);
            Scheduler.getInstance().add(new MoveArm(Arm.SHOOTING1));
            shooter.shoot(shootingSpeed);
            System.out.println("button: X");
        }
            else {
            shooter.shoot(0);
        }}
        { if (oi.getY()) {
//            shooter.setSetpoint(Shooter.SHOOTING2);
//            shooter.shoot(0.9);
           shooter.armMotor.set(-armSpeed);
            System.out.println("button: Y");
        } else if (oi.getB()) {
            shooter.armMotor.set(armSpeed);
//            shooter.setSetpoint(Shooter.PASSING);
//            shooter.shoot(0.85);
            System.out.println("button: B");
        }
        else{
            //shooter.armMotor.set(0);
        }}

        {if (oi.getRB() && !(shooter.triggerRunning)) {
////            
//////            System.out.println("Starting Pot: " + shooter.triggerPot.getAverageValue());
           shooter.triggerRunning = true;
            Scheduler.getInstance().add(new TriggerCommand(fTime, bTime));
//            shooter.launchMotor.set(-1);
            System.out.println("RB Pressed");
        }    
        else if (oi.getLB()){
            shooter.launchMotor.set(armSpeed);
            
            System.out.println("LB Pressed");
        }
        else {
           // shooter.launchMotor.set(0);
        }}
        
        Timer.delay(.05);
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
