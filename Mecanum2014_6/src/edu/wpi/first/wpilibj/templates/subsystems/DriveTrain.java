// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package edu.wpi.first.wpilibj.templates.subsystems;


import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.MecanumDrive;

/**
 *
 */
public class DriveTrain extends Subsystem {
    public Victor backRight;// = RobotMap.driveTrainBackRight;
    public Victor frontRight;// = RobotMap.driveTrainFrontRight;
    public Victor backLeft;// = RobotMap.driveTrainBackLeft;
    public Victor frontLeft;// = RobotMap.driveTrainFrontLeft;
    public Gyro gyro;
    public double driveTime = 2;
            public boolean autoRunning;
            public boolean gyroEnabled = false;
    
    public DriveTrain(){
        backRight = new Victor(RobotMap.RIGHT_MOTOR_BACK);
        frontRight = new Victor(RobotMap.RIGHT_MOTOR_FRONT);
        backLeft = new Victor(RobotMap.LEFT_MOTOR_BACK);
        frontLeft = new Victor(RobotMap.LEFT_MOTOR_FRONT);
        gyro = new Gyro(RobotMap.GYRO_PORT);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new MecanumDrive());
    }
    public void rightFrontMove(double speed){
        frontRight.set(speed);
    }
    
    public void rightBackMove(double speed){
        backRight.set(speed);
    }
        public void leftFrontMove(double speed){
        frontLeft.set(speed);
    }
            public void leftBackMove(double speed){
        backLeft.set(speed);
    }

public void mecDrive(double x, double y, double t, double a){
    double temp = y*Math.cos(Math.toRadians(a)) - x*Math.sin(Math.toRadians(a));
    x = y*Math.sin(Math.toRadians(a)) + x*Math.cos(Math.toRadians(a));
    y = temp;

    
    double front_left = y + t + x;
    double front_right = y - t - x;
    double back_left = y + t - x;
    double back_right = y - t + x;
    
    double max = Math.abs(front_left);
    if (Math.abs(front_right)>max) {
        max = Math.abs(front_right);
    }
    if (Math.abs(back_left)>max){
        max=Math.abs(back_left);
    }
    if (Math.abs(back_right)>max) {
        max=Math.abs(back_right);
    }
    if (max>1){
      front_left/=max; front_right/=max; back_left/=max; back_right/=max;

    }
    if(Math.abs(x+y+t) > 0){
        System.out.println("DriveX: " +x + " DriveY: " + y);
    }    
    frontLeft.set(-front_left); //inverts motor
    frontRight.set(front_right);
    backRight.set(back_right);
    backLeft.set(-back_left); //inverts motor
}
}
