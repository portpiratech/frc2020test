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
  private boolean highGoal = true;

  public TurretSubsystem() {
    xMotor = new TalonSRX(RobotMap.turretXMotorID);
    xMotor.configForwardLimitSwitchSource(RemoteLimitSwitchSource.Deactivated, LimitSwitchNormal.Disabled,
        RobotMap.turretXMotorID, 10);
    xMotor.configReverseLimitSwitchSource(RemoteLimitSwitchSource.Deactivated, LimitSwitchNormal.Disabled,
        RobotMap.turretXMotorID, 10);
    xMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
    xMotor.getSensorCollection().setQuadraturePosition(0, 10);

    yMotor = new TalonSRX(RobotMap.turretYMotorID);
    yMotor.configForwardLimitSwitchSource(RemoteLimitSwitchSource.Deactivated, LimitSwitchNormal.NormallyOpen,
        RobotMap.turretYMotorID, 10);
    yMotor.configReverseLimitSwitchSource(RemoteLimitSwitchSource.Deactivated, LimitSwitchNormal.NormallyOpen,
        RobotMap.turretYMotorID, 10);
    yMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
    // yMotor.getSensorCollection().setQuadraturePosition(0, 10);
  }
  // Returns if the target is the high goal
  public boolean isHighGoal(){
    return highGoal;
  }
  // Switches between high and low goal.
  public void switchHighGoal(){
    highGoal = !highGoal;
  }
  // Sets the speed of the X motor.
  public void setXMotor(double speed) {
    SmartDashboard.putNumber("x Speed", speed);
    xMotor.set(ControlMode.PercentOutput, speed);
  }
  // Returns the encoder position on the X motor.
  public double getXPosition() {
    SmartDashboard.putNumber("Position", xMotor.getSelectedSensorPosition(0));
    return xMotor.getSelectedSensorPosition(0);
  }
  // Returns the forward limit switch on the X motor.
  public int getForwardLimitSwitchX() {
    SmartDashboard.putNumber("Forward Limit Switch X", xMotor.isFwdLimitSwitchClosed());
    return xMotor.isFwdLimitSwitchClosed();
  }
  // Returns the reverse limit switch on the X motor.
  public int getReverseLimitSwitchX() {
    SmartDashboard.putNumber("Reverse Limit Switch X", xMotor.isRevLimitSwitchClosed());
    return xMotor.isRevLimitSwitchClosed();
  }
  // Sets the speed of the Y motor.
  public void setYMotor(double speed) {
    SmartDashboard.putNumber("y Speed", speed);
    yMotor.set(ControlMode.PercentOutput, speed);
  }
  // Returns the angle of the Y motor.
  public double getYAngle() {
    SmartDashboard.putNumber("Y Angle", yMotor.getSelectedSensorPosition(0) * Math.PI * 2 / countsPerRev);
    return yMotor.getSelectedSensorPosition(0) * Math.PI * 2 / countsPerRev;
  }
  // Returns the forward limit switch on the Y motor.
  public int getForwardLimitSwitchY() {
    SmartDashboard.putNumber("Forward Limit Switch Y", yMotor.isFwdLimitSwitchClosed());
    return yMotor.isFwdLimitSwitchClosed();
  }
  // Returns the reverse limit switch on the Y motor.
  public int getReverseLimitSwitchY() {
    SmartDashboard.putNumber("Reverse Limit Switch Y", yMotor.isRevLimitSwitchClosed());
    return yMotor.isRevLimitSwitchClosed();
  }
  // Sets the encoder's counts on the Y motor to 0.
  public void resetEncoder() {
    yMotor.getSensorCollection().setQuadraturePosition(0, 10);
  }
}
