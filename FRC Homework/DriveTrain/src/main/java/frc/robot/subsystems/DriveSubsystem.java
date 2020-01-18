/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
  
  private TalonSRX _leftFront, _leftMiddle, _leftBack, _rightFront, _rightMiddle, _rightBack;

  private Joystick _leftDrive = new Joystick(1);
  private Joystick _rightDrive = new Joystick(2);

  double left, right;

  /**
   * Creates a new DriveTrain.
   */
  public DriveSubsystem() {
    _leftFront = new TalonSRX(11);
    _leftFront.setNeutralMode(NeutralMode.Brake);
    _leftFront.setInverted(true);

    _leftMiddle = new TalonSRX(12);
    _leftMiddle.setNeutralMode(NeutralMode.Brake);
    _leftMiddle.setInverted(true);

    _leftBack = new TalonSRX(13);
    _leftBack.setNeutralMode(NeutralMode.Brake);
    _leftBack.setInverted(true);
    
    _rightFront = new TalonSRX(1);
    _rightFront.setNeutralMode(NeutralMode.Brake);
    //_rightFront.setInverted(true);

    _rightMiddle = new TalonSRX(2);
    _rightMiddle.setNeutralMode(NeutralMode.Brake);
    //_rightMiddle.setInverted(true);

    _rightBack = new TalonSRX(3);
    _rightBack.setNeutralMode(NeutralMode.Brake);
    //_rightBack.setInverted(true);
  }

public void tankDrive (double left, double right) {
  _leftFront.set(ControlMode.PercentOutput, left);
  _leftMiddle.set(ControlMode.PercentOutput, left);
  _leftBack.set(ControlMode.PercentOutput, left);

  _rightFront.set(ControlMode.PercentOutput, right);
  _rightMiddle.set(ControlMode.PercentOutput, right);
  _rightBack.set(ControlMode.PercentOutput, right);
  
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    right = _rightDrive.getRawAxis(1);
    left = _leftDrive.getRawAxis(1);
  }

  public double getLeft() {
    if(Math.abs(left) > .05) {
      if(Math.pow(left, 3) >= 1) {
        return 1;
      }else {
        return left;
      }
    }else {
      return 0;
    }
  }

  public double getRight() {
    if(Math.abs(right) > .05 ){
      if(Math.pow(right, 3) >= 1) {
        return 1;
      }else {
        return right;
      }
    }else {
      return 0;
    }
  }
}
