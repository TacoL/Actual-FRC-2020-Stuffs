/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

/**
 * Add your docs here.
 */
public class Vision {

    double KpAim = -0.1;
    double KpDistance = -0.1;
    double min_aim_command = 0.05;
    

    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry tx = table.getEntry("tx");
    NetworkTableEntry ty = table.getEntry("ty");


    double x = tx.getDouble(0.0);
    double y = ty.getDouble(0.0);

    
    
    public double[] aim_dist(){
        double left_command = 0.0;
        double right_command = 0.0;

        double desired_Distance = 2.0;
        double current_Distance = 0.0;

        double distance_adjust;
        double heading_error = -x;

        double distance_error = 0.0;
        double steering_adjust = 0.0;

        double[] powerValues = new double[2];

        double h1 = 2.0;
        double h2 = 8.0;

        double a1 = 40.0;
        double a2 = y;

        if (x > 1.0)
        {
            steering_adjust = KpAim*heading_error - min_aim_command;
        }
        else if (x < 1.0)
        {
            steering_adjust = KpAim*heading_error + min_aim_command;
        }

        current_Distance = (h2-h1) / Math.tan(a1+a2);
        distance_error = desired_Distance - current_Distance;
        distance_adjust = KpDistance * distance_error;

        left_command += steering_adjust + distance_adjust;
        right_command -= steering_adjust + distance_adjust;

        powerValues[0] = left_command;
        powerValues[1] = right_command;

        return powerValues;
    }

    public double[] aim(){
        double left_command = 0.0;
        double right_command = 0.0;

        double steering_adjust = 0.0;

        double heading_error = -x;

        double[] powerValues = new double[2];

        if (x > 1.0)
        {
            steering_adjust = KpAim*heading_error - min_aim_command;
        }
        else if (x < 1.0)
        {
            steering_adjust = KpAim*heading_error + min_aim_command;
        }

        left_command += steering_adjust;
        right_command -= steering_adjust;

        powerValues[0] = left_command;
        powerValues[1] = right_command;
        
        return powerValues;

    }
}
