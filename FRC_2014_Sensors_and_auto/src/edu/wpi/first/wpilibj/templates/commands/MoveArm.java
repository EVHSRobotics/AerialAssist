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
    double finalPosition; //setpoint for arm to move to
    double difference; //difference between setpoint and current position
    double pos; //current position of arm
    
    public MoveArm(double setpoint) {
        // Use requires() here to declare subsystem dependencies
        // requires(chassis);
        requires(arm); //arm cannot be used by other commands
        finalPosition = setpoint; //sets target location to parameter
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        Arm.armMoving = true; //boolean used in other commands, marks arm as moving
        setTimeout(4); //lasts for 4 seconds at most (after which it times out)
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
           pos= arm.returnArmPosition(); //current position returned by sensor
           difference = finalPosition - pos; //difference calculated
            arm.armMotor.set(getSign(difference)); //arm set to either -1 or 1 depending on which direction it needs to move
            System.out.println("Difference: " + difference); //diagnostic
            System.out.println("F: " + finalPosition); //diagnostic
            System.out.println("P: " + pos); //diagnostic
            System.out.println("O: " + arm.armMotor.get()); //diagnostic
       
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
         
         return ((Math.abs(difference ) < Arm.TOLERANCE) || isTimedOut()); //command finished if difference between
                                            //setpoint and current position is less than tolerance or command timed out
       }

    // Called once after isFinished returns true
    protected void end() {
        Arm.armMoving = false; //marks arm as stopped
        System.out.println("Finished"); //diagnostic
         arm.armMotor.set(0); //stops arm motor
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        Arm.armMoving = false; //marks arm as stopped
         arm.armMotor.set(0); //stops motor
    }
    public double getSign(double f) {
        if (f != f) { //if f is not a number
            throw new IllegalArgumentException("NaN"); //diagnostic
        }
        if (f == 0) { //if number is 0
            return 0;
        }
        //else
        f *= Double.POSITIVE_INFINITY; //multiply by infinitely large number
        if (f == Double.POSITIVE_INFINITY) { //if f was positive (positive*positive) = positive
            return +1; //return 1
        }
        if (f == Double.NEGATIVE_INFINITY) { //if f was negative (positive*negative) = negative
            return -1; //return -1
        }

        //this should never be reached
        throw new IllegalArgumentException("Unfathomed double");
    }
}
