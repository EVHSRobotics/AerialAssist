package edu.wpi.first.wpilibj.templates;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
    
    public static final int LEFT_MOTOR_BACK = 2; //1
    public static final int LEFT_MOTOR_FRONT = 1; //4
    public static final int RIGHT_MOTOR_BACK = 8; //2
    public static final int RIGHT_MOTOR_FRONT = 5; //3
    
    public static final int LEFT_SHOOT_MOTOR = 4; 
    public static final int RIGHT_SHOOT_MOTOR = 7; 
    public static final int ARM_MOTOR = 6;
    public static final int LAUNCH_MOTOR = 3;
    public static final int LAUNCH_MOTOR_2 = 1;
    
    public static final int ARM_GYRO_PORT = 1;
    public static final int GYRO_PORT = 2;
    
    public static final int ENCODER_A_PORT = 7;
    public static final int ENCODER_B_PORT = 6;
    public static final int ENCODER_2A_PORT = 8; 
    public static final int ENCODER_2B_PORT = 9;
}
