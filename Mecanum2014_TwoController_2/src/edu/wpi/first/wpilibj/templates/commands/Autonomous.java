/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.tables.TableKeyNotDefinedException;

/**
 *
 * @author Justin
 */
public class Autonomous extends CommandBase {
    NetworkTable smartDashboard;
    int autonomousChoice;
    
    public Autonomous() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
         smartDashboard = NetworkTable.getTable("SmartDashboard");
         
         autonomousChoice = (int) smartDashboard.getNumber("autonomousChoice", 0);
                  
         executeAuto(autonomousChoice);
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
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
    
    protected void executeAuto(int autoNum) {
        switch(autoNum) {
            case AutoId.NOTHING: 
                break; 
            case AutoId.MOVE_AND_SHOOT: 
                Scheduler.getInstance().add(new MoveandShoot());
                break; 
            case AutoId.MOVE:
                Scheduler.getInstance().add(new MoveForward());
                break;
            case AutoId.SHOOT: 
                Scheduler.getInstance().add(new ShootBall());
                break;
            default:
                break; 
        }
    }
    
    public static final class AutoId {
        public static final int NOTHING = 0;
        public static final int MOVE_AND_SHOOT = 10; 
        public static final int MOVE = 11;
        public static final int SHOOT = 12;
    }
}
