/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

// import com.ctre.phoenix.motorcontrol.ControlMode;
// import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class ShooterSubsystem extends SubsystemBase {
  /**
   * Creates a new ShooterSubsystem.
   */
  private DoubleSolenoid piston;
  // private TalonSRX motor;
  private CANSparkMax leftMotor;
  private CANSparkMax rightMotor;
  private boolean isMotorOn;
  private double speed = 0.3;

  public ShooterSubsystem() {
    piston = new DoubleSolenoid(RobotMap.PCM_ID, RobotMap.SPIFFYSolenoidPort1, RobotMap.SPIFFYSolenoidPort2);
    // motor = new TalonSRX(RobotMap.SPIFFYMotorID);
    leftMotor = new CANSparkMax(RobotMap.SPIFFYLeftMotorID, MotorType.kBrushless);
    rightMotor = new CANSparkMax(RobotMap.SPIFFYRightMotorID, MotorType.kBrushless);
    isMotorOn = false;
  }
  // Extends the piston.
  public void extendLauncher() {
    piston.set(Value.kForward);
  }
  // Retracts the piston.
  public void retractLauncher() {
    piston.set(Value.kReverse);
  }
  // Stops the piston.
  public void stopLauncher() {
    piston.set(Value.kOff);
  }
  // Turns the motor on.
  public void startMotor() {
    // motor.set(ControlMode.PercentOutput, speed);
    leftMotor.set(speed);
    rightMotor.set(-speed);
    isMotorOn = true;
  }
  // Stops the motor.
  public void stopMotor() {
    // motor.set(ControlMode.PercentOutput, 0);
    leftMotor.set(0);
    rightMotor.set(0);
    isMotorOn = false;
  }
  // Returns if the motor is on.
  public boolean isMotorOn() {
    return isMotorOn;
  }
  // Shoots the ball and returns if it succeeded.
  public boolean shoot(){
    if (Robot.shooterSubsystem.isMotorOn()
      && Robot.cameraSubsystem.hasTarget()
      && Robot.cameraSubsystem.shotViable()
    ) {
      Robot.shooterSubsystem.retractLauncher();
      Timer.delay(1);
      Robot.shooterSubsystem.extendLauncher();
      return true;
    }else{
      return false;
    }
  }
}
