/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class PUOBSubsystem extends SubsystemBase {
  /**
   * Creates a new PUOBSubsystem.
   */
  private TalonSRX motor;
  private double speed = 0.3;
  private boolean motorOn = false;
// Picker Upper Of Balls
  public PUOBSubsystem() {
    motor = new TalonSRX(RobotMap.PUOBMotorID);
  }
  // Turns the motor on.
  public void motorOn() {
    motor.set(ControlMode.PercentOutput, speed);
    motorOn = true;
  }
  // Turns the motor off.
  public void motorOff() {
    motor.set(ControlMode.PercentOutput, 0);
    motorOn = false;
  }
  // Runs the motor in reverse.
  public void motorReverse() {
    motor.set(ControlMode.PercentOutput, -speed);
    motorOn = true;
  }
  // Returns if the motor is on.
  public boolean isMotorOn(){
    return motorOn;
  }

}
