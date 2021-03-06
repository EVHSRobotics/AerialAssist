
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
    
    
    public Joystick controller;
    public Button gyroReset;
    public Button shootButton; 
    public Button pickupButton; 
    public Button shiftArmButton;
    public double leftAxisX, leftAxisY, rightAxisX, rightAxisY, triggers;
    public boolean ButtonAPressed;
    
    public OI() {

        controller = new Joystick(1);
        leftAxisX = controller.getRawAxis(1);
        leftAxisY = controller.getRawAxis(2);
        rightAxisX = controller.getRawAxis(4);
        rightAxisY = controller.getRawAxis(5);
        triggers = controller.getRawAxis(3);
        //ButtonAPressed = controller.getRawButton(1);
        
        shootButton = new JoystickButton(controller,2);
        pickupButton = new JoystickButton(controller,3);
        shiftArmButton = new JoystickButton(controller,4);
        
	gyroReset = new JoystickButton(controller,1);    
        // SmartDashboard Buttons

       
    }
    public Joystick getJoystick() {
        return controller;
    }
    
    public double getLeftX(){
        return leftAxisX;
    }
    public double getLeftY(){
        return leftAxisY;
    }
    public double getRightX(){
        return rightAxisX;
    }
    public double getRightY(){
        return rightAxisY;
    }

    
    public boolean getBackRightButton() {
        return controller.getRawButton(6);
    }    
    public double getTriggers() {
        return triggers;
    }    
    
    public boolean getAButton(){
        return controller.getRawButton(1);
    }
    
    public boolean getBButton() {
        return controller.getRawButton(2);
    }
    
    
    
//Axis indexes:
//1 - LeftX
//2 - LeftY
//3 - Triggers (Each trigger = 0 to 1, axis value = right - left)
//4 - RightX
//5 - RightY
//6 - DPad Left/Right
//double axisValue = mXboxController.getRawAxis(2); // Where "2" is the index of the Y axis on the left stick (see above)
    
//Button indexes: 
    //1 A 
    //2 B
    //3 X 
    //4 Y 
    //5 LB 
    //6 RB 
    //7 back 
    //8 start 
    //9 left stick press 
    //10 right stick press 
}

