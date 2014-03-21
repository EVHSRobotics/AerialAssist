/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
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
    public Relay launchMotor2;
    public Encoder quadEncoder;
    //public Encoder triggerEncoder;
    public AnalogChannel potentiometer;
    public DigitalInput limitSwitch;
    public static final int 
            START = 0, 
            SHOOTING1 = 50 , 
            SHOOTING2 = 30, 
            PASSING = 25, 
            PICKUP = 5, 
            DISTANCE = 1, 
            TRIGGER_SETPOINT = 500,
            TRIGGER_SETPOINT_2 = 900;
    public static final double TOLERANCE = 10, MINRATE = .2;
    
    public Shooter() {
        super("Shooter" , 1, .1, 0); //PID
        leftCim = new Victor(RobotMap.LEFT_SHOOT_MOTOR);
        rightCim = new Victor(RobotMap.RIGHT_SHOOT_MOTOR);
        launchMotor = new Victor(RobotMap.LAUNCH_MOTOR);
        launchMotor2 = new Relay(RobotMap.LAUNCH_MOTOR_2);
        armMotor = new Victor(RobotMap.ARM_MOTOR); 
        
        limitSwitch = new DigitalInput(4);
        
        quadEncoder = new Encoder(RobotMap.ENCODER_A_PORT , RobotMap.ENCODER_B_PORT, false ,CounterBase.EncodingType.k4X);
//        triggerEncoder = new Encoder(RobotMap.ENCODER_2A_PORT, RobotMap.ENCODER_2B_PORT, false, CounterBase.EncodingType.k4X);        
        potentiometer = new AnalogChannel(2); //don't plug into port 8; clockwise positive; lowest ~475, highest ~961
        
        setAbsoluteTolerance(300);
        getPIDController().setContinuous(false);
        quadEncoder.setMinRate(MINRATE);
        quadEncoder.setReverseDirection(true);
        quadEncoder.setDistancePerPulse(DISTANCE);
        quadEncoder.reset();
//        triggerEncoder.setMinRate(MINRATE);
//        triggerEncoder.setReverseDirection(true);
//        triggerEncoder.setDistancePerPulse(DISTANCE);
//        triggerEncoder.reset();
        enable();
    
        setSetpoint(START);
        quadEncoder.start();
//        triggerEncoder.start();
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new ShootBall());
    }
    
    public void usePIDOutput(double output){
        //System.out.println("O" +output);
        if (Math.abs(getSetpoint() - quadEncoder.getDistance()) > TOLERANCE){
           // if(output != 0) System.out.println("O: " + output);
            //armMotor.set(getSign(output) * .3);
            armMotor.set(output * .3);
           // System.out.println("PID set" + armMotor.get());   
        }
        else {
            armMotor.set(0);
        }

    }
    
    protected double returnPIDInput() {
//        if(getSetpoint() - quadEncoder.getDistance() != 0) System.out.println
//             ("I: " + (getSetpoint() - quadEncoder.getDistance()));
//       
//       return (getSetpoint() - quadEncoder.getDistance());
       // if(quadEncoder.getDistance() != 0) System.out.println("I: " + quadEncoder.getDistance());
        return (quadEncoder.getDistance());
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
    
    public void setTrigger(double value) {
        launchMotor.set(value);
        Value relayDirection;
        if(value > 0) {
            relayDirection = Relay.Value.kForward;
        } else if (value < 0) {
            relayDirection = Relay.Value.kReverse;
        } else {
            relayDirection = Relay.Value.kOff;
        }
        launchMotor2.set(relayDirection);
    }
}