
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
     Joystick controller1;
     Joystick controller2;
    
    public OI() {
        controller1 = new Joystick(1);
        controller2 = new Joystick(2);
    }
    
    public Joystick getJoystick(int n) {
        if (n==1){
            return controller1;
        }else{
            return controller2;
        }
    }
    
    public double getLeftX_1(){
        return controller1.getRawAxis(1);
    }
    public double getLeftY_1(){
        return controller1.getRawAxis(2);
    }
    public double getRightX_1(){
        return controller1.getRawAxis(4);
    }
    public double getRightY_1(){
        return controller1.getRawAxis(5);
    }
    public double getTriggers_1() {
        return controller1.getRawAxis(3);
    }
    public double getDPad_1(){
        return controller1.getRawAxis(6);
    }
    
    public boolean getA_1(){
        return controller1.getRawButton(1);
    }
    public boolean getB_1() {
        return controller1.getRawButton(2);
    }
    public boolean getX_1() {
        return controller1.getRawButton(3);
    }
    public boolean getY_1() {
        return controller1.getRawButton(4);
    }
    public boolean getLB_1() {
        return controller1.getRawButton(5);
    }
    public boolean getRB_1() {
        return controller1.getRawButton(6);
    }
    public boolean getBack_1() {
        return controller1.getRawButton(7);
    }
    public boolean getStart_1() {
        return controller1.getRawButton(8);
    }
    
    public double getLeftX_2(){
        return controller2.getRawAxis(1);
    }
    public double getLeftY_2(){
        return controller2.getRawAxis(2);
    }
    public double getRightX_2(){
        return controller2.getRawAxis(4);
    }
    public double getRightY_2(){
        return controller2.getRawAxis(5);
    }
    public double getTriggers_2() {
        return controller2.getRawAxis(3);
    }
    public double getDPad_2(){
        return controller2.getRawAxis(6);
    }
    
    public boolean getA_2(){
        return controller2.getRawButton(1);
    }
    public boolean getB_2() {
        return controller2.getRawButton(2);
    }
    public boolean getX_2() {
        return controller2.getRawButton(3);
    }
    public boolean getY_2() {
        return controller2.getRawButton(4);
    }
    public boolean getLB_2() {
        return controller2.getRawButton(5);
    }
    public boolean getRB_2() {
        return controller2.getRawButton(6);
    }
    public boolean getBack_2() {
        return controller2.getRawButton(7);
    }
    public boolean getStart_2() {
        return controller2.getRawButton(8);
    }
    
    
//Axis indexes:
//1 - LeftX
//2 - LeftY
//3 - Triggers (Each trigger = 0 to 1, axis value = right - left)
//4 - RightX
//5 - RightY
//6 - DPad Left/Right (-1 is left, +1 is right, 0 is center)
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

