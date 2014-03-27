package edu.wpi.first.wpilibj.templates;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {    
    public static final int LEFT_MOTOR_BACK = 2; //1
    public static final int LEFT_MOTOR_FRONT = 1; //4
    public static final int RIGHT_MOTOR_BACK = 8; //2
    public static final int RIGHT_MOTOR_FRONT = 5; //3
    
    public static final int LEFT_SHOOT_MOTOR = 3; // I believe this polarity switched
    public static final int RIGHT_SHOOT_MOTOR = 7; 
    public static final int ARM_MOTOR = 4;
    public static final int LAUNCH_MOTOR = 6; //POLARITY MUST BE SWITCHED
//    public static final int LAUNCH_MOTOR_2 = 1;
//    
//    public static final int ARM_GYRO_PORT = 1;
    public static final int GYRO_PORT = 2;
    public static final int ARM_POT_PORT = 5;
    public static final int TRIGGER_POT_PORT = 3;
//    
//    public static final int ENCODER_A_PORT = 7;
//    public static final int ENCODER_B_PORT = 6;
//    public static final int ENCODER_2A_PORT = 8; 
//    public static final int ENCODER_2B_PORT = 9;
}
