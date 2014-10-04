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
    double forwardTime = driveTrain.driveTime;
    public MoveForward(){
        
    }
    public MoveForward(double time) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        forwardTime = time;
    }

    // Called just before this Command runs the first time
     protected void initialize() {
         System.out.println("FORWARD COMMAND STARTED");
        driveTrain.autoRunning = true;
        driveTrain.mecDrive(0, .6, 0, 0);
        Timer.delay(1);
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
        driveTrain.mecDrive(0, 0, 0, 0);
        driveTrain.autoRunning = false;
        System.out.println("FORWARD COMMAND Finished");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        
        driveTrain.mecDrive(0, 0, 0, 0);
        driveTrain.autoRunning = false;
    }
}
