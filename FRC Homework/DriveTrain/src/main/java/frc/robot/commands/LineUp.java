/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.Vision;

/**
 * Add your docs here.
 */

public class LineUp extends CommandBase {
    public Vision _lineup;
    public DriveSubsystem _driveTrain;
    private final int heightOfVisionTargets = 83; //Bottom of targets is 83 inches, top of targets is 98 inches

    public LineUp(Vision subsystem, DriveSubsystem drive){
        _lineup = subsystem;
        _driveTrain = drive;
        addRequirements(subsystem, drive);
    }

      // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        double horizontalAngle = _lineup.getTxValue();
        double verticalAngle = _lineup.getTyValue();
        double d = (heightOfVisionTargets * Math.cos(horizontalAngle)) / Math.tan(verticalAngle);
        //rotate 90 degrees
        //drive d inches
        //rotate 90 degrees back
        
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }

}
