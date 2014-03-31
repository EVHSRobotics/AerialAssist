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
public class Vision extends CommandBase {
    NetworkTable server;
    Timer timer;
    boolean shot;
    double count;
    double distance;
    public Vision() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
         server = NetworkTable.getTable("RoborealmData");
         shot = false;
         count = 0;
         timer = new Timer();
        timer.start();
         
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        count++;
	
        try
	{
            String s = server.getString("Triangle");
            distance = server.getNumber("Distance");
            if (s.equals("True")){
                //Scheduler.getInstance().add(new ShootBall());
                Timer.delay(.2);
                if (s.equals("True")){
                  System.out.println("Shoot");
                shot = true;  
                }
            }
            System.out.println(server.getString("Triangle"));
                        
	}
        
	catch (TableKeyNotDefinedException ex)
	{
            System.out.println("Error");
	}
        
        System.out.println("Count " + count);
        System.out.println("Time " + timer.get());
        System.out.println("Distance " + distance);
        if (timer.get() > 5){
                   
                //Scheduler.getInstance().add(new ShootBall());
                System.out.println("Shoot");
                shot = true;   
        }
        if (shot){
            Scheduler.getInstance().add(new MoveForward());
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return shot;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
