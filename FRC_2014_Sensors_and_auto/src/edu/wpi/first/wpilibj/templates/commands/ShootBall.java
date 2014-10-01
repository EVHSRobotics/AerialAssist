/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.templates.subsystems.Arm;

/**
 *
 * @author Justin
 */
public class ShootBall extends CommandBase {
    int count; //used to count
    public ShootBall() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        count = 0; //internal counter
        
        Scheduler.getInstance().add(new MoveArm(Arm.SHOOTING1)); //begins to move arm to shooting position
        /* Manual arm movement
        arm.armMotor.set(.7);
        Timer.delay(.3);
        arm.armMotor.set(0);
        */
        shooter.shoot(1); //spins up shooter
        Timer.delay(1.5); //Delay to allow shooter get up to speed
        while((Arm.armMoving) && (count < 100)){ //waits for reasonable time for arm to stop moving
            Timer.delay(.05); //wait
            count++; //increments count
        }
        Scheduler.getInstance().add(new TriggerCommand()); //starts trigger
        Timer.delay(2); //waits for ball to be shot
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true; //finishes immediately
    }

    // Called once after isFinished returns true
    protected void end() {
        shooter.shoot(0); //stops shooter
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        shooter.shoot(0); //stops shooter
    }
}
