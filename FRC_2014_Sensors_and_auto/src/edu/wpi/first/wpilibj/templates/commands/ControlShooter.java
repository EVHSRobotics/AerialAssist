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

    double pickUpSpeed = .8; //constant to slow down pick up speed
    double shootingSpeed = 1;//shoots at full speed
    double armSpeed = .8;//controls arm speed

    public ControlShooter() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(shooter); //needs the shooter, so any other command that requires shooter cannot run
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        System.out.println("Arm: " + arm.returnArmPosition()); //data purposes
        if (oi.getStart()) { //if start button is pressed
        }

        {
            if (oi.getA()) { //if 'A' button is pressed
                shooter.shoot(-pickUpSpeed); //spins shooter at pickup speed
                System.out.println("button: A"); //diagnostic purposes
            } else if (oi.getX()) { //if 'X' button is pressed
                shooter.shoot(shootingSpeed); //spins shooter at full speed
                System.out.println("button: X"); //diagnostic purposes
            } else {
                shooter.shoot(0);
            }
        }
        {
            if (oi.getY()) { //if 'Y' button is pressed
                //Scheduler.getInstance().add(new MoveArm(Arm.SHOOTING1)); 
                //NOTE: we used manual movement instead of a command because we couldn't get the sensor working
               
                arm.armMotor.set(-armSpeed); //moves arm up
                System.out.println("button: Y"); //diagnostic purposes
                System.out.println("Arm Position" + arm.returnArmPosition()); //diagnostic purposes
            } else if (oi.getB()) { //if 'B' button is pressed
                //Scheduler.getInstance().add(new MoveArm(Arm.PICKUP));
                //NOTE: we used manual movement instead of a command because we couldn't get the sensor working
                
                arm.armMotor.set(armSpeed); //moves arm down
                System.out.println("button: B"); //diagnostic purposes
                System.out.println("Arm Position" + arm.returnArmPosition()); //diagnostic purposes
            } else {
               arm.armMotor.set(0); //stops arm from moving - probably unneeded if sensor added
            }
        }

        { if (oi.getRB() && !(shooter.triggerRunning)) { //if 'R' button is pressed and trigger is not already moving
                                                        //prevents multiple commands from being sent
           shooter.triggerRunning = true; //marks the trigger as running
            Scheduler.getInstance().add(new TriggerCommand()); //adds command to move trigger through a cycle
            System.out.println("RB Pressed"); //diagnostic purposes
        }
        if (oi.getLB() && !(shooter.triggerRunning)){ //if 'L' button is pressed and trigger is not already moving
                                                      //prevents multiple commands from being sent
            shooter.triggerRunning=true; //marks the trigger as running
            Scheduler.getInstance().add(new MoveTrigger()); //adds command to move trigger back slightly
            System.out.println("LB Pressed"); //diagnostic purposes
        }
        }

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false; //command is always executing
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
