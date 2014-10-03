/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

/**
 *
 * @author Justin
 */
public class UtilityFunctions {

    public static final double DEADBAND = 0.3;

    public static double fixDeadBand(double speed) {
        return (Math.abs(speed) > DEADBAND ? speed : 0.0);
    }

    public static double fixDeadBand(double speed, double deadBand) {
        return (Math.abs(speed) > deadBand ? speed : 0.0);
    }

    public static double getSign(double f) {
        if (f != f) {
            throw new IllegalArgumentException("NaN");
        }
        if (f == 0) {
            return 0;
        }
        f *= Double.POSITIVE_INFINITY;
        if (f == Double.POSITIVE_INFINITY) {
            return +1;
        }
        if (f == Double.NEGATIVE_INFINITY) {
            return -1;
        }

        //this should never be reached, but I've been wrong before...
        throw new IllegalArgumentException("Unfathomed double");
    }
}
