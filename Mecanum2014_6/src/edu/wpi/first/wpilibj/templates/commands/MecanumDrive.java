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
public class MecanumDrive extends CommandBase {

    private final double DRIVE_SENSITIVITY = 1;
    public double xValue;
    public double yValue;
    public double twist;
    public double angle;

    public MecanumDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(driveTrain);
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        yValue = DRIVE_SENSITIVITY * UtilityFunctions.fixDeadBand(oi.getLeftY()); 
        xValue = DRIVE_SENSITIVITY * UtilityFunctions.fixDeadBand(oi.getLeftX());
        
        if (yValue < 0 ){
            yValue *=1.08;//multiplied by 1.08 because joystick forward doesn't send full signal
        }
        if (yValue < -1){
            yValue = -1;
        }
        
        twist = .7 * DRIVE_SENSITIVITY * UtilityFunctions.fixDeadBand(oi.getTriggers()); //double deadband
        angle = driveTrain.gyro.getAngle();
        //System.out.println("A: " +angle);

        if (oi.getBack()) {
            driveTrain.gyro.reset();
            System.out.println("Gyro Reset");
        }
        driveTrain.mecDrive(xValue, -yValue, -twist, 0); //replace 0 with angle if using gyro

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
