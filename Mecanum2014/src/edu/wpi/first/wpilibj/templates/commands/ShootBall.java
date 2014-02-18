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

        if (oi.getLB()) {
            System.out.println("arm stop");
            shooter.armStop();
        }
        if (oi.getStart()) {
        }

        if (oi.getX()) { //motor out
            shooter.shoot(1);
            System.out.println("button: A");
        } else if (oi.getA()) { //motor in
            shooter.shoot(-0.6);
            System.out.println("button: X");
        } else if (oi.getY()) {//arm up
            shooter.armMotor.set(-0.5);
            System.out.println("button: Y");
        } else if (oi.getB()) {//arm down
            shooter.armMotor.set(0.5);
            System.out.println("button: B");
        } else {
            shooter.shoot(0);
            shooter.armMotor.set(0);
        }

        {if (oi.getRB()) {
            shooter.launchMotor.set(1);
//            System.out.println("button: RB");
//            shooter.launchMotor.set(0.6);
//            do {
//                System.out.println("Trigger Forward");
//                Timer.delay(0.1);
//            } while (shooter.limitSwitch.get() || oi.getLB());
//                
//                
//            
//            shooter.launchMotor.set(-0.6);
//            do {
//                System.out.println("Trigger Backward");
//                Timer.delay(0.1);
//            } while (shooter.limitSwitch.get() || oi.getLB());
//                
//            shooter.launchMotor.set(0);
      }
        else if(oi.getLB()){
            shooter.launchMotor.set(-1);
        }
        else{
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
