/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *
 * @author Justin
 */
public class MoveForward extends CommandBase {
    double forwardTime =2; //time to move forward
    public MoveForward(){
        
    }
    public MoveForward(double time) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        driveTrain.autoRunning = true; //boolean from driveTrain class
        driveTrain.mecDrive(0, -.8, 0, 0); //should set motors runnning forward
        Timer.delay(forwardTime); //moves forward for 2 seconds
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
        driveTrain.mecDrive(0, 0, 0, 0); //stops motors
        driveTrain.autoRunning = false; //sets boolean to false
        System.out.println("Auto Finished"); //diagnostic text
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        
        driveTrain.mecDrive(0, 0, 0, 0); //stops motors
        driveTrain.autoRunning = false; //sets boolean to false
    }
}
