/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.subsystems.Arm;

/**
 *
 * @author Justin
 */
public class MoveArm extends CommandBase {
    double finalPosition, difference;
    double TOLERANCE = 50;
    double pos;
    
    public MoveArm(double setpoint) {
        // Use requires() here to declare subsystem dependencies
        // requires(chassis);
        requires(arm);
        finalPosition = setpoint;
    }

    // Called just before this Command runs the first time
    protected void initialize() {

        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
           pos= arm.returnArmPosition();
           difference = finalPosition - pos;
            arm.armMotor.set(getSign(difference));
            System.out.println("Difference: " + difference);
            System.out.println("F: " + finalPosition);
            System.out.println("P: " + pos);
            System.out.println("O: " + arm.armMotor.get());
       
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
         
         return (Math.abs(difference ) < Arm.TOLERANCE);
       }

    // Called once after isFinished returns true
    protected void end() {
        System.out.println("Finished");
         arm.armMotor.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
         arm.armMotor.set(0);
    }
    public double getSign(double f) {
        if (f != f) {
            throw new IllegalArgumentException("NaN");
        }
        if (f == 0) {
            return 0;
        }
        f *= Double.POSITIVE_INFINITY;
        if (f == Double.POSITIVE_INFINITY) {
            return +1;
        }
        if (f == Double.NEGATIVE_INFINITY) {
            return -1;
        }

        //this should never be reached, but I've been wrong before...
        throw new IllegalArgumentException("Unfathomed double");
    }
}
