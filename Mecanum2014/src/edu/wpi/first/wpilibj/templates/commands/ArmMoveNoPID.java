/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Justin
 */
public class ArmMoveNoPID extends CommandBase {
    double speed = .4;
    public ArmMoveNoPID() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(arm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
                if (oi.controller.getRawButton(3)){
            speed -= .05; 
            System.out.println("S: " +speed);
        }
        if (oi.controller.getRawButton(4)){
            speed += .05;
            System.out.println("S: " +speed);
        }
               if(oi.controller.getRawButton(6)){ //right trigger
            arm.armMotor.set(-speed);
            System.out.println("Button 6");
//            if( shooter.getSetpoint() == Shooter.START) {
//                System.out.println("go to finish");
//                shooter.setSetpoint(Shooter.FINISH);
//            } else if (shooter.getSetpoint() == Shooter.FINISH) {
//                shooter.setSetpoint(Shooter.START);
//                System.out.println("go to start");
//            }
        } 
        else if (oi.controller.getRawButton(5)){//
            arm.armMotor.set(speed);
            System.out.println("Button 5");
        }
        else{
            arm.armMotor.set(0);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
