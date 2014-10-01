
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI { //controls input from controllers and buttons
    
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
    
    
    public Joystick controller; //defines controller as a joystick
    
    public OI() { //constructor for OI
        controller = new Joystick(1); //defines controller as joystick in port 1 
                                            //(viewable on Driver Station)
    }
    
    public Joystick getJoystick() { //method to return the joystick 
        return controller; 
    }
    
    //following methods are for an X-Box Controller - regular joystick uses different methods
    public double getLeftX(){ //returns x-value of left stick
        return controller.getRawAxis(1);
    }
    public double getLeftY(){ //returns y-value of left stick
        return controller.getRawAxis(2);
    }
    public double getRightX(){ //returns x-value of right stick
        return controller.getRawAxis(4);
    }
    public double getRightY(){ //returns y-value of right stick
        return controller.getRawAxis(5);
    }
    public double getTriggers() {
        return controller.getRawAxis(3);
    }
    
    public boolean getA(){ //returns 'A' button
        return controller.getRawButton(1);
    }
    public boolean getB() { //returns 'B' button
        return controller.getRawButton(2);
    }
    public boolean getX() { //returns 'X' button
        return controller.getRawButton(3);
    }
    public boolean getY() { //returns 'Y' button
        return controller.getRawButton(4);
    }
    public boolean getLB() { //returns left button
        return controller.getRawButton(5);
    }
    public boolean getRB() { //returns right button
        return controller.getRawButton(6);
    }
    public boolean getBack() { //returns back button
        return controller.getRawButton(7);
    }
    public boolean getStart() { //returns start button
        return controller.getRawButton(8);
    }
    
//X-Box controller mapping index    
//Axis indexes:
//1 - LeftX
//2 - LeftY
//3 - Triggers (Each trigger = 0 to 1, axis value = right - left)
//4 - RightX
//5 - RightY
//6 - DPad Left/Right
//double axisValue = controller.getRawAxis(n); n is the axis index
    
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
//double buttonValue = controller.getRawButton(n); n is the button you want    
    
//    Move Robot
//X-Movement - Axis 1
//Y-Movement - Axis 2
//Twist - Axis 3
//
//Shooter & Arm
//Trigger - RB (6)
//
//Move Arm
//Picking up - A (1)
//Passing - B (2)
//Shooting - X (3) 
//2nd angle shooting? - Y (4)
//
//Safety
//Reset gyro (or disable) - Back
//Start Position - Start
}

