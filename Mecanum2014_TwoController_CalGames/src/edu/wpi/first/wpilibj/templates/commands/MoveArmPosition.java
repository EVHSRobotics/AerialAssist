/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import utilities.UtilityFunctions;

/**
 *
 * @author Justin
 */
public class MoveArmPosition extends CommandBase {

    boolean towardsPickup;
    double armMoveSpeed = .6;

    public MoveArmPosition(double d) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        if (UtilityFunctions.getSign(d) == 1) {
            towardsPickup = true;
        } else {
            towardsPickup = false;
        }
        System.out.println("Towards Pickup: " + towardsPickup);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        arm.resetCounters();
        if (towardsPickup) {
            arm.moveArm(armMoveSpeed);
        } else {
            arm.moveArm(-armMoveSpeed);
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (towardsPickup) {
            return arm.isPickupHit();
        } else {
            return arm.isShootingHit();
        }
    }

    // Called once after isFinished returns true
    protected void end() {
        arm.moveArm(0);
        arm.armMoving = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        arm.moveArm(0);
        arm.armMoving = false;
    }
}
