/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Justin
 */
public class Arm extends Subsystem {

    Victor armMotor;
    public static boolean armMoving;
    DigitalInput pickupLimit;
    DigitalInput shooterLimit;
    Counter pickupCounter;
    Counter shooterCounter;

    public Arm() {
        armMotor = new Victor(RobotMap.ARM_MOTOR);
        pickupLimit = new DigitalInput(RobotMap.LIMIT_SWITCH_PICKUP_PORT);
        shooterLimit = new DigitalInput(RobotMap.LIMIT_SWITCH_SHOOT_PORT);
        pickupCounter = new Counter(pickupLimit);
        shooterCounter = new Counter(pickupLimit);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void moveArm(double speed) {
        armMotor.set(speed);
    }

    public boolean isPickupHit() {
        return pickupCounter.get() > 0;
    }

    public boolean isShootingHit() {
        return shooterCounter.get() > 0;
    }

    public void resetCounters() {
        pickupCounter.reset();
        shooterCounter.reset();
    }

}
