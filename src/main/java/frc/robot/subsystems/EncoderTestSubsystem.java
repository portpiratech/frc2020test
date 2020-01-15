/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class EncoderTestSubsystem extends SubsystemBase {
  /**
   * Creates a new EncoderTest.
   */
  private long startTime;
  private long count;
  private TalonSRX encoderMotor;
  public EncoderTestSubsystem() {
    encoderMotor = new TalonSRX(RobotMap.encoderMotorID);
    encoderMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
    encoderMotor.getSensorCollection().setQuadraturePosition(0, 10);
    startTime = System.currentTimeMillis();
    count = 0;
  }

  public void move(double speed){
    encoderMotor.set(ControlMode.PercentOutput, speed);
  }

  public void output() {
    count++;
    SmartDashboard.putNumber("Encoder Sensor Position", encoderMotor.getSelectedSensorPosition(0));
    SmartDashboard.putNumber("Encoder Checks / Second", count / ((System.currentTimeMillis() - startTime) / 1000));
    //1988 per 360
  }

}
