/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
  /**
   * Creates a new DriveSubsystem
   */
  private final TalonSRX _rightFrontMotor, _leftFrontMotor, _rightBackMotor, _leftBackMotor, _rightMiddleMotor, _leftMiddleMotor;


  public DriveSubsystem() {
    _rightFrontMotor = new TalonSRX(1);
    _rightFrontMotor.setNeutralMode(NeutralMode.Coast);
    _rightFrontMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);

    _rightMiddleMotor = new TalonSRX(2);
    _rightMiddleMotor.setNeutralMode(NeutralMode.Coast);
    _rightMiddleMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    
    _rightBackMotor =  new TalonSRX(3);
    _rightBackMotor.setNeutralMode(NeutralMode.Coast);
    _rightBackMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);

    _leftFrontMotor = new TalonSRX(11);
    _leftFrontMotor.setNeutralMode(NeutralMode.Coast);
    _leftFrontMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    _leftFrontMotor.setInverted(true);

    _leftMiddleMotor = new TalonSRX(12);
    _leftMiddleMotor.setNeutralMode(NeutralMode.Coast);
    _leftMiddleMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    _leftMiddleMotor.setInverted(true);

    _leftBackMotor = new TalonSRX(13);
    _leftBackMotor.setNeutralMode(NeutralMode.Coast);
    _leftBackMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    _leftBackMotor.setInverted(true);

  }

  public void tankDrive(double left, double right){
    _rightFrontMotor.set(ControlMode.PercentOutput, right);
    _rightMiddleMotor.set(ControlMode.PercentOutput, right);
    _rightBackMotor.set(ControlMode.PercentOutput, right);

    _leftFrontMotor.set(ControlMode.PercentOutput, left);
    _leftMiddleMotor.set(ControlMode.PercentOutput, left);
    _leftBackMotor.set(ControlMode.PercentOutput, left);

    SmartDashboard.putNumber("left", left);
    SmartDashboard.putNumber("right", right);
  }

  public void resetEncoders(){
    _rightBackMotor.setSelectedSensorPosition(0);
    _rightFrontMotor.setSelectedSensorPosition(0);
    _leftFrontMotor.setSelectedSensorPosition(0);
    _leftBackMotor.setSelectedSensorPosition(0);
  }

  public int getLeftBackPosition(){
    return _leftBackMotor.getSelectedSensorPosition();
  }

  public int getLeftFrontPosition(){
    return _leftFrontMotor.getSelectedSensorPosition();
  }

  public int getRightBackPosition(){
    return _rightBackMotor.getSelectedSensorPosition();
  }

  public int getRightFrontPosition(){
    return _rightBackMotor.getSelectedSensorPosition();
  }

  public int getleftPosition(){
    return (_leftFrontMotor.getSelectedSensorPosition() + _leftBackMotor.getSelectedSensorPosition()) / 2;
  }

  public int getrightPosition(){
    return (_rightFrontMotor.getSelectedSensorPosition() + _rightBackMotor.getSelectedSensorPosition()) / 2;
  }

}
