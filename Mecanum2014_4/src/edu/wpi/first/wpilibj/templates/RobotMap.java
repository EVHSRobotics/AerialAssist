package edu.wpi.first.wpilibj.templates;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {    
    public static final int LEFT_MOTOR_BACK = 2; //2
    public static final int LEFT_MOTOR_FRONT = 4;
    public static final int RIGHT_MOTOR_BACK = 5;//8 
    public static final int RIGHT_MOTOR_FRONT = 6; 
    
    public static final int LEFT_SHOOT_MOTOR = 1; // I believe this polarity switched
    public static final int RIGHT_SHOOT_MOTOR = 3;//7 
    public static final int ARM_MOTOR = 7; //4
    public static final int LAUNCH_MOTOR = 8; //POLARITY MUST BE SWITCHED //6
//    public static final int LAUNCH_MOTOR_2 = 1;
//    
//    public static final int ARM_GYRO_PORT = 1;
    public static final int GYRO_PORT = 2;
    public static final int ARM_POT_PORT = 4;
    public static final int TRIGGER_POT_PORT = 5;
//    
//    public static final int ENCODER_A_PORT = 7;
//    public static final int ENCODER_B_PORT = 6;
//    public static final int ENCODER_2A_PORT = 8; 
//    public static final int ENCODER_2B_PORT = 9;
}
