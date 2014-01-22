/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.image.CriteriaCollection;
import edu.wpi.first.wpilibj.image.NIVision.MeasurementType;
import edu.wpi.first.wpilibj.templates.commands.Vision;

/**
 *
 * @author kevin
 */
public class VisionCamera extends Subsystem {

    public AxisCamera axisCamera;
    public CriteriaCollection cc;

    public VisionCamera() {
        cc = new CriteriaCollection();      // create the criteria for the particle filter
        //uncomment this later after we are done testing the test images axisCamera = AxisCamera.getInstance();
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new Vision());
    }
}