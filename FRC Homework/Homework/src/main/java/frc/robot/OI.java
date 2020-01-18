/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OI {
  private static OI _instance;

  private Joystick _driverControllerLeft, _driverControllerRight;

  private double _rightYSpeed = 0, _leftYSpeed = 0;


  private OI(){
    _driverControllerLeft = new Joystick(Addresses.CONTROLLER_DRIVER_LEFT); // logitech
    _driverControllerRight = new Joystick(Addresses.CONTROLLER_DRIVER_RIGHT); // logitech
  }

  public static OI getInstance() {
    if (_instance == null) {
        _instance = new OI();
    }
    return _instance;
  }

  public double[] getJoystickInput(){
    _leftYSpeed = getLeftYInputJoystick();
    _rightYSpeed = getRightYInputJoystick();

    return new double[] {_leftYSpeed, _rightYSpeed};
  }

  public double getLeftXInputJoystick(){
    return _driverControllerLeft.getRawAxis(Addresses.LEFT_X_AXIS);
  }

  public double getLeftYInputJoystick(){
    return _driverControllerLeft.getRawAxis(Addresses.LEFT_Y_AXIS);
  }

  public double getRightXInputJoystick(){
    return _driverControllerRight.getRawAxis(Addresses.RIGHT_X_AXIS);
  }

  public double getRightYInputJoystick(){
    return _driverControllerRight.getRawAxis(Addresses.RIGHT_Y_AXIS);
  }
}
