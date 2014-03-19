/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.ShootBall;

/**
 *
 * @author kevin
 */
public class Shooter extends PIDSubsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public Victor leftCim;
    public Victor rightCim; 
    public Victor armMotor;
    public Victor launchMotor;
    public Encoder quadEncoder;
    public Gyro armGyro;
    public DigitalInput limitSwitch;
    public static final int 
            START = 0, 
            SHOOTING1 = 25 , 
            SHOOTING2 = 30, 
            PASSING = 45, 
            PICKUP = 90, 
            DISTANCE = 1;
    public static final double TOLERANCE = 10, MINRATE = .2;
    
    public Shooter() {
        super("Shooter" , 1, .1, 0); //PID
        leftCim = new Victor(RobotMap.LEFT_SHOOT_MOTOR);
        rightCim = new Victor(RobotMap.RIGHT_SHOOT_MOTOR);
        launchMotor = new Victor(RobotMap.LAUNCH_MOTOR);
        armMotor = new Victor(RobotMap.ARM_MOTOR); 
        
        limitSwitch = new DigitalInput(4);
        armGyro = new Gyro(RobotMap.ARM_GYRO_PORT);
        armGyro.reset();
        
        quadEncoder = new Encoder(RobotMap.ENCODER_A_PORT , RobotMap.ENCODER_B_PORT, false ,CounterBase.EncodingType.k4X);
        
        //        quadEncoder.setMinRate(MINRATE);
//        quadEncoder.setReverseDirection(true);
//        quadEncoder.setDistancePerPulse(DISTANCE);
//        quadEncoder.reset();
        
        setAbsoluteTolerance(300);
        getPIDController().setContinuous(false);
        enable();
    
        setSetpoint(START);
        //quadEncoder.start();
        armGyro = new Gyro(RobotMap.ARM_GYRO_PORT);
    
        //setAbsoluteTolerance(300);
        //getPIDController().setContinuous(false);
        //gyro.setMinRate(MINRATE);
        //gyro.setReverseDirection(true);
        //gyro.setDistancePerPulse(DISTANCE);
        armGyro.reset();
        enable();
    
        setSetpoint(START);
        //gyro.start();
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new ShootBall());
    }
    
    public void usePIDOutput(double output){
        //System.out.println("O" +output);
       // if (Math.abs(getSetpoint() - quadEncoder.getDistance()) > TOLERANCE){
         if (Math.abs(getSetpoint() - armGyro.getAngle()) > TOLERANCE){ 
        // if(output != 0) System.out.println("O: " + output);
        if (Math.abs(getSetpoint() - armGyro.getAngle()) > TOLERANCE){
           // if(output != 0) System.out.println("O: " + output);
            //armMotor.set(getSign(output) * .3);
            armMotor.set(output * .3);
           // System.out.println("PID set" + armMotor.get());   
        }
        else {
            armMotor.set(0);
        }

    }
    }
    
    protected double returnPIDInput() {
//        if(getSetpoint() - quadEncoder.getDistance() != 0) System.out.println
//             ("I: " + (getSetpoint() - quadEncoder.getDistance()));
//       
//       return (getSetpoint() - quadEncoder.getDistance());
       // if(quadEncoder.getDistance() != 0) System.out.println("I: " + quadEncoder.getDistance());

       // return (quadEncoder.getDistance());
        return armGyro.getAngle();
    }
    
    public double getSign(double f){
        if (f != f) throw new IllegalArgumentException("NaN");
        if (f == 0) return 0;
        f *= Double.POSITIVE_INFINITY;
        if (f == Double.POSITIVE_INFINITY) return +1;
        if (f == Double.NEGATIVE_INFINITY) return -1;

    //this should never be reached, but I've been wrong before...
        throw new IllegalArgumentException("Unfathomed double");
    }
    
    public void shoot(double speed) {
        leftCim.set(-speed);
        rightCim.set(-speed);
    }
    
    public void armStop() {
        setSetpoint(getPosition());
    }
}