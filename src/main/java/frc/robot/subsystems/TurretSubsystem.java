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

public class TurretSubsystem extends SubsystemBase {
  /**
   * Creates a new TurretSubsystem.
   */
  private TalonSRX xMotor;
  public TurretSubsystem() {
    xMotor = new TalonSRX(RobotMap.turretXMotorID);
    xMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
    xMotor.getSensorCollection().setQuadraturePosition(0, 10);
  }

  public void setXMotor(double speed){
    xMotor.set(ControlMode.PercentOutput, speed);
  }

  public double getPosition(){
    SmartDashboard.putNumber("Position", xMotor.getSelectedSensorPosition(0));
    return xMotor.getSelectedSensorPosition(0);
  }
}
