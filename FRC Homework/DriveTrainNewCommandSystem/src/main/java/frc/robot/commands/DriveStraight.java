/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class DriveStraight extends CommandBase {
  public final DriveSubsystem _drive;
  public final double _distance, _speed;
  /**
   * Creates a new DriveStraight.
   */
  public DriveStraight(DriveSubsystem _subsystem, double inches, double speed) {
    _drive = _subsystem;
    _distance = inches;
    _speed = speed;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(_drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    _drive.resetEncoders();
    _drive.tankDrive(_speed, _speed);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    _drive.tankDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (((_drive.getleftPosition() + _drive.getrightPosition()) / 2) / 4096) / 18.84956 >= _distance;
  }
}
