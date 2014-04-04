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
    int count;
    public ShootBall() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        count = 0;
        Scheduler.getInstance().add(new MoveArm(Arm.SHOOTING1));
        shooter.shoot(1);
        Timer.delay(.5);
        while((Arm.armMoving) && (count < 100)){
            Timer.delay(.05);
            count++;
        }
        Scheduler.getInstance().add(new TriggerCommand());
        Timer.delay(2);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
        shooter.shoot(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        shooter.shoot(0);
    }
}
