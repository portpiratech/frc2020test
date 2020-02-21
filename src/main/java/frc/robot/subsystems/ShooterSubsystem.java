/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
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
  private CANSparkMax leftMotor;
  private CANPIDController leftMotorPIDController;
  private CANEncoder leftMotorEncoder;
  private CANSparkMax rightMotor;
  private CANPIDController rightMotorPIDController;
  private CANEncoder rightMotorEncoder;
  private boolean isMotorOn;
  private double speed = 0.3;

  public ShooterSubsystem() {
    piston = new DoubleSolenoid(RobotMap.PCM_ID, RobotMap.SPIFFYSolenoidPort1, RobotMap.SPIFFYSolenoidPort2);
    leftMotor = new CANSparkMax(RobotMap.SPIFFYLeftMotorID, MotorType.kBrushless);
    leftMotorPIDController = leftMotor.getPIDController();
    leftMotorEncoder = leftMotor.getEncoder();
    rightMotor = new CANSparkMax(RobotMap.SPIFFYRightMotorID, MotorType.kBrushless);
    rightMotorPIDController = rightMotor.getPIDController();
    rightMotorEncoder = rightMotor.getEncoder();
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
  
  public void startMotor() {
    leftMotor.set(speed);
    rightMotor.set(-speed);
    isMotorOn = true;
  }
  
  public void stopMotor() {
    leftMotor.set(0);
    rightMotor.set(0);
    isMotorOn = false;
  }
  
  public boolean isMotorOn() {
    return isMotorOn;
  }
  
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
