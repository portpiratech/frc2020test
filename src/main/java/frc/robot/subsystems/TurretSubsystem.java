/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.RemoteLimitSwitchSource;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class TurretSubsystem extends SubsystemBase {
  /**
   * Creates a new TurretSubsystem.
   */
  private double countsPerRev = 1988;
  private TalonSRX yMotor;
  private TalonSRX xMotor;
  public TurretSubsystem() {
    xMotor = new TalonSRX(RobotMap.turretXMotorID);
    xMotor.configForwardLimitSwitchSource(RemoteLimitSwitchSource.RemoteTalonSRX, LimitSwitchNormal.NormallyClosed, RobotMap.turretXMotorID, 10);
    xMotor.configReverseLimitSwitchSource(RemoteLimitSwitchSource.RemoteTalonSRX, LimitSwitchNormal.NormallyClosed, RobotMap.turretXMotorID, 10);
    xMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
    xMotor.getSensorCollection().setQuadraturePosition(0, 10);

    yMotor = new TalonSRX(RobotMap.turretYMotorID);
    yMotor.configForwardLimitSwitchSource(RemoteLimitSwitchSource.RemoteTalonSRX, LimitSwitchNormal.NormallyClosed, RobotMap.turretYMotorID, 10);
    yMotor.configReverseLimitSwitchSource(RemoteLimitSwitchSource.RemoteTalonSRX, LimitSwitchNormal.NormallyClosed, RobotMap.turretYMotorID, 10);
    yMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
    yMotor.getSensorCollection().setQuadraturePosition(0, 10);
  }

  public void setXMotor(double speed){
    SmartDashboard.putNumber("x Speed", speed);
    xMotor.set(ControlMode.PercentOutput, speed);
  }

  public double getXPosition(){
    SmartDashboard.putNumber("Position", xMotor.getSelectedSensorPosition(0));
    SmartDashboard.putNumber("Forward Limit Switch", xMotor.isFwdLimitSwitchClosed());
    SmartDashboard.putNumber("Reverse Limit Switch", xMotor.isRevLimitSwitchClosed());
    return xMotor.getSelectedSensorPosition(0);
  }

  public int getForwardLimitSwitchX(){
    SmartDashboard.putNumber("Forward Limit Switch", xMotor.isFwdLimitSwitchClosed());
    return xMotor.isFwdLimitSwitchClosed();
  }

  public int getReverseLimitSwitchX(){
    SmartDashboard.putNumber("Reverse Limit Switch", xMotor.isRevLimitSwitchClosed());
    return xMotor.isRevLimitSwitchClosed();
  }

  public void setYMotor(double speed){
    SmartDashboard.putNumber("y Speed", speed);
    yMotor.set(ControlMode.PercentOutput, speed);
  }

  public double getYAngle(){
    SmartDashboard.putNumber("Y Angle", yMotor.getSelectedSensorPosition(0)*Math.PI*2/countsPerRev);
    return yMotor.getSelectedSensorPosition(0)*Math.PI*2/countsPerRev;
  }

  public int getForwardLimitSwitchY(){
    SmartDashboard.putNumber("Forward Limit Switch", yMotor.isFwdLimitSwitchClosed());
    return yMotor.isFwdLimitSwitchClosed();
  }

  public int getReverseLimitSwitchY(){
    SmartDashboard.putNumber("Reverse Limit Switch", yMotor.isRevLimitSwitchClosed());
    return yMotor.isRevLimitSwitchClosed();
  }
}
