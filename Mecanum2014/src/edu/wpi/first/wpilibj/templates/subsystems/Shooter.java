/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.ShootBall;

/**
 *
 * @author kevin
 */
public class Shooter extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public Victor leftCim;
    public Victor rightCim; 
    public Victor armMotor;
    public Victor launchMotor;
    public DigitalInput limitSwitch;
    public static final double TOLERANCE = 10, MINRATE = .2;
    
    public Shooter() {
        leftCim = new Victor(RobotMap.LEFT_SHOOT_MOTOR);
        rightCim = new Victor(RobotMap.RIGHT_SHOOT_MOTOR);
        launchMotor = new Victor(RobotMap.LAUNCH_MOTOR);
        armMotor = new Victor(RobotMap.ARM_MOTOR); 
        
        limitSwitch = new DigitalInput(4);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new ShootBall());
    }
    
    public void shoot(double speed) {
        leftCim.set(-speed);
        rightCim.set(-speed);
    }
    
    public void armStop() {
        armMotor.set(0);
    }
}