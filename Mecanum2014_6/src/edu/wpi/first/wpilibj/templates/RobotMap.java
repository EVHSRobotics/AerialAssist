package edu.wpi.first.wpilibj.templates;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {    
    public static final int LEFT_MOTOR_BACK = 2; 
    public static final int LEFT_MOTOR_FRONT = 1;
    public static final int RIGHT_MOTOR_BACK = 3;
    public static final int RIGHT_MOTOR_FRONT = 4; 
    
    public static final int LEFT_SHOOT_MOTOR = 5; 
    public static final int RIGHT_SHOOT_MOTOR = 6;
    public static final int ARM_MOTOR = 8; 
    public static final int LAUNCH_MOTOR = 7;
    
    public static final int GYRO_PORT = 2;
    public static final int LIMIT_SWITCH_PICKUP_PORT = 5;
    public static final int LIMIT_SWITCH_SHOOT_PORT = 5;
}
