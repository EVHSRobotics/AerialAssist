/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Justin
 */
public class MecanumDrive extends CommandBase {

    public final double DEADBAND = .3; //deadband for joystick input
    private final double SENSITIVITY = 1; //limiting constant for motor (running at full right now)
    public double xValue; // X of joystick
    public double yValue;// Y of joystick
    public double twist; // Twist (or triggers for x-box) of joystick
    public double angle; //angle of gyro

    public MecanumDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(driveTrain); //drive train needed - other commands that require driveTrain cannot run
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        yValue = SENSITIVITY * fixDeadBand(oi.getLeftY(), DEADBAND); //modifies yValue of joystick by sensitivity and deadband fixing 
        xValue = SENSITIVITY * fixDeadBand(oi.getLeftX(), DEADBAND); //modifies xValue given by joystick using sensitivity and deadband
        
        if (yValue < 0 ){ //if yValue is negative (joystick forward)
            yValue *=1.08;//multiplied by 1.08 because joystick forward doesn't send full signal
        }
        if (yValue < -1){ 
            yValue = -1; //limits any yValue less than -1 to -1
        }
        
        twist = .7 * SENSITIVITY * fixDeadBand(oi.getTriggers(), DEADBAND); //twist limited to 70% of input
        angle = driveTrain.gyro.getAngle(); //diagnostic 
        System.out.println("A: " +angle); //diagnostic

        if (oi.getBack()) { //if back button is pressed
            driveTrain.gyro.reset(); //resets gyro
            System.out.println("Gyro Reset"); //diagnostic
        }
        driveTrain.mecDrive(xValue, -yValue, -twist, angle); //inverted yValue and twist to make robot drive correctly

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false; //command is always running
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }

    private double fixDeadBand(double speed, double deadBand) { //method to fix deadbands
        return (Math.abs(speed) > deadBand ? speed : 0.0); //ternary operation - if absolute value of speed is
                                                           //greater than the deadband, return speed, else return 0
    }
}
