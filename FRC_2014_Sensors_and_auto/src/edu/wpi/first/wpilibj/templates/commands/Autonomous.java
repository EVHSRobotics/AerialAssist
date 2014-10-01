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
    NetworkTable server; //defines NetworkTable, used to send/receive info wirelessly
    Timer timer; //defines timer, used to keep time (accesses info from Driver Station)
    boolean shot; //tells if ball has been shot
    double count; //counter to keep time
    double distance; //distance from goal
    public Autonomous() {
        // Use requires() here to declare subsystem dependencies
        // if multiple commands require the same subsystem, only the most recent will run
        //the others will be interrupted
    }

    // Called just before this Command runs the first time
    protected void initialize() {
         server = NetworkTable.getTable("RoborealmData"); //Gets data from table in Tableviewer (external program) 
                                                          //called "RoborealmData"
         shot = false; //ball has not been shot
         count = 0; //counter starts at 0
         timer = new Timer(); //timer initialized
        timer.start(); //timer started
         
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        count++; //counter incremented every iteration of loop
	
        try
	{
            String s = server.getString("Triangle"); //gets data from table named Triangle (boolean represented as String)
                                                     //tells if retroreflective tape form a sort of Triangle
            distance = server.getNumber("Distance"); //gets data from table named Distance (number) 
                                                    //gives distance from goal
            if (s.equals("True")){ //if retroreflective tape forms a triangle (both horizontal and vertical strips showing)
                Timer.delay(.2); //Wait .2 seconds
                if (s.equals("True")){ //check again for triangle (helps avoid false positives)
                  Scheduler.getInstance().add(new ShootBall()); //add ShootBall command
                  shot = true; //mark that ball was shot 
                  System.out.println("Ball shot"); //shows on console that shot was attempted
                }
            }
            System.out.println(server.getString("Triangle")); //shows on console state of "Triangle"
                        
	}
        
	catch (TableKeyNotDefinedException ex) //if data that doesn't exist on the table is asked for
	{
            System.out.println("Error");
	}
        
        //more data for testing/logging purposes below
        System.out.println("Count " + count);
        System.out.println("Time " + timer.get());
        System.out.println("Distance " + distance);
        
        if (timer.get() > 5 || count > 500){ //If either the DriverStation clock or internal count exceeds limit
                   
                Scheduler.getInstance().add(new MoveandShoot()); //adds MoveandShoot command to queue
                System.out.println("Ball shot");
                shot = true;   //mark that ball was shot
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return shot; //if shot is true, ends
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
