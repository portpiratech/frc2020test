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

public class EncoderTestSubsystem extends SubsystemBase {
  /**
   * Creates a new EncoderTest.
   */
  private TalonSRX encoderMotor;
  public EncoderTestSubsystem() {
    encoderMotor = new TalonSRX(RobotMap.encoderMotorID);
  }

  public void move(){
    encoderMotor.set(ControlMode.PercentOutput, 0.9);
  }

}