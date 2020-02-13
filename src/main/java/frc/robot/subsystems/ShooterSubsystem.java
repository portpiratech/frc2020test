/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class ShooterSubsystem extends SubsystemBase {
  /**
   * Creates a new ShooterSubsystem.
   */
  private DoubleSolenoid piston;
  private TalonSRX motor;
  private boolean isMotorOn;
  private double speed = 0.3;

  public ShooterSubsystem() {
    piston = new DoubleSolenoid(RobotMap.PCM_ID, RobotMap.SPIFFYSolenoidPort1, RobotMap.SPIFFYSolenoidPort2);
    motor = new TalonSRX(RobotMap.SPIFFYMotorID);
    isMotorOn = false;
  }

  public void extendLauncher() {
    piston.set(Value.kForward);
  }

  public void retractLauncher() {
    piston.set(Value.kReverse);
  }

  public void stopLauncher() {
    piston.set(Value.kOff);
  }

  // public void turn(double speed) {
  //   motor.set(ControlMode.PercentOutput, speed);

  public void startMotor() {
    motor.set(ControlMode.PercentOutput, speed);
    isMotorOn = true;
  }

  public void stopMotor(){
    motor.set(ControlMode.PercentOutput, 0);
    isMotorOn = false;
  }

  public boolean isMotorOn(){
    return isMotorOn;
  }
}
