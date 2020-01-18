/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Addresses;
import frc.robot.commands.DriveTankWithJoystick;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveTrain extends Subsystem {
  
  private static DriveTrain _instance = null;
  private TalonSRX _leftFrontMotor, _leftBackMotor, _rightFrontMotor, _rightBackMotor;

    private DriveTrain() {
        _leftFrontMotor = new TalonSRX(Addresses.DRIVETRAIN_LEFT_FRONT_MOTOR);
		    _leftFrontMotor.setNeutralMode(NeutralMode.Coast);
        _leftBackMotor = new TalonSRX(Addresses.DRIVETRAIN_LEFT_BACK_MOTOR);
        _leftBackMotor.setNeutralMode(NeutralMode.Coast);
        _rightFrontMotor = new TalonSRX(Addresses.DRIVETRAIN_RIGHT_FRONT_MOTOR);
        _rightFrontMotor.setNeutralMode(NeutralMode.Coast);
        _rightBackMotor = new TalonSRX(Addresses.DRIVETRAIN_RIGHT_BACK_MOTOR);
        _rightBackMotor.setNeutralMode(NeutralMode.Coast);
        

        _leftFrontMotor.configOpenloopRamp(0);
        _leftBackMotor.configOpenloopRamp(0);
        _rightBackMotor.configOpenloopRamp(0);
        _rightFrontMotor.configOpenloopRamp(0);

        
    }

  public static DriveTrain getInstance() {
    if (_instance == null) {
        _instance = new DriveTrain();
    }
    return _instance;
  }


  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new DriveTankWithJoystick());
  }

  public void tankDrive(double[] wheelSpeeds){

    if(wheelSpeeds[0] > .15 || wheelSpeeds[0] < -.15){
      _leftFrontMotor.set(ControlMode.PercentOutput, -wheelSpeeds[0]); 
      _leftBackMotor.set(ControlMode.PercentOutput, -wheelSpeeds[0]);
    }else{
      _leftFrontMotor.set(ControlMode.PercentOutput, 0); 
      _leftBackMotor.set(ControlMode.PercentOutput, 0);
    }

    if(wheelSpeeds[1] > .15 || wheelSpeeds[1] < -.15){
      _rightFrontMotor.set(ControlMode.PercentOutput, wheelSpeeds[1]);
      _rightBackMotor.set(ControlMode.PercentOutput, wheelSpeeds[1]);
    }else{
      _rightFrontMotor.set(ControlMode.PercentOutput, 0); 
      _rightBackMotor.set(ControlMode.PercentOutput, 0);
    }
  }
}
