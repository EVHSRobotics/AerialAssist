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
import utilities.UtilityFunctions;

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
    double armSpeed = .8;
    double driveForwardTime = driveTrain.driveTime;

    public ControlShooter() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

        //Moves shooting wheels
        {
            if (oi.getA_2()) {
                shooter.shoot(-pickUpSpeed);
                System.out.println("button: A");
            } else if (oi.getX_2()) {
                shooter.shoot(shootingSpeed);
                System.out.println("button: X");
            } else {
                shooter.shoot(0);
            }
        }

        //Moves arm
        {
            double dPad = UtilityFunctions.fixDeadBand(oi.getDPad_2());
            if (dPad != 0 && !(Arm.armMoving)) {
                Arm.armMoving = true;
                Scheduler.getInstance().add(new MoveArmPosition(dPad));
            } else if (!(Arm.armMoving)) {
                double yValue = UtilityFunctions.fixDeadBand(oi.getRightY_2());

                if (yValue < 0) {
                    yValue *= 1.08;//multiplied by 1.08 because joystick forward doesn't send full signal
                }
                if (yValue < -1) {
                    yValue = -1;
                } else if (yValue > 1) {
                    yValue = 1;
                }
                arm.moveArm(armSpeed * yValue);
            }
        }

        //Moves trigger
        {
            if (oi.getRB_2() && !(shooter.triggerRunning)) {
                shooter.triggerRunning = true;
                Scheduler.getInstance().add(new TriggerFire());
                System.out.println("RB Pressed");
            }
            if (oi.getLB_2() && !(shooter.triggerRunning)) {
                shooter.triggerRunning = true;
                Scheduler.getInstance().add(new TriggerHold());
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
