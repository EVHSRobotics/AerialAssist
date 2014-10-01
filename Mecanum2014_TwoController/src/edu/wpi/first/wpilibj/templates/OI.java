
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

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
    
    
    public Joystick controller1;
    public Joystick controller2;
    Button button1_2, button2_2, button3_2, button4_2;
    public OI() {
        controller1 = new Joystick(1);
        controller2 = new Joystick(2);
        button1_2 = new JoystickButton(controller2,1);
        button2_2= new JoystickButton(controller2,2);
        button3_2= new JoystickButton(controller2,3);
        button4_2 = new JoystickButton(controller2, 4);
    }
    
    public Joystick getJoystick() {
        return controller1;
    }
    
    public double getLeftX_1(){
        return controller1.getRawAxis(1);
    }
    public double getLeftY_1(){
        return controller1.getRawAxis(2);
    }
    public double getRightX(){
        return controller1.getRawAxis(4);
    }
    public double getRightY(){
        return controller1.getRawAxis(5);
    }
    public double getLeftX_2(){
        return controller2.getX();
    }
    public double getLeftY_2(){
        return controller2.getY();
    }
    public double getTriggers() {
        return controller1.getRawAxis(3);
    }
    
    public boolean get1_2(){
        return button1_2.get();
    }
        public boolean get2_2() {
        return button2_2.get();
    }
    public boolean get3_2() {
        return button3_2.get();
    }
    public boolean get4_2() {
        return button4_2.get();
    }
    public boolean getB() {
        return controller1.getRawButton(2);
    }

    public boolean getY() {
        return controller1.getRawButton(4);
    }


    public boolean getBack() {
        return controller1.getRawButton(7);
    }
    public boolean getStart() {
        return controller1.getRawButton(8);
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
//    
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

