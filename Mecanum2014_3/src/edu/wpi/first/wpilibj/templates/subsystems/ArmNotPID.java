/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
//import edu.wpi.first.wpilibj.templates.commands.ArmMoveNoPID;

/**
 *
 * @author Justin
 */
public class ArmNotPID extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public Victor armMotor;
    public ArmNotPID(){
        armMotor = new Victor(RobotMap.ARM_MOTOR);
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        //setDefaultCommand(new ArmMoveNoPID());
    }
}
