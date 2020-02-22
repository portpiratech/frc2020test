/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
  private CANSparkMax rightMotor;
  private CANPIDController rightMotorPIDController;
  private boolean isMotorOn;
  // private double speed = 1;
  public double kP, kI, kD, kIz, kFF, kMaxOutput, kMinOutput, maxRPM;

  public ShooterSubsystem() {
    piston = new DoubleSolenoid(RobotMap.PCM_ID, RobotMap.SPIFFYSolenoidPort1, RobotMap.SPIFFYSolenoidPort2);
    kI = 0;
    kD = 0; 
    kIz = 0; 
    kFF = 0.000015; 
    kMaxOutput = 1; 
    kMinOutput = -1;
    maxRPM = 5700;
    leftMotor = new CANSparkMax(RobotMap.SPIFFYLeftMotorID, MotorType.kBrushless);
    leftMotorPIDController = leftMotor.getPIDController();
    leftMotorPIDController.setOutputRange(kMinOutput, kMaxOutput);
    rightMotor = new CANSparkMax(RobotMap.SPIFFYRightMotorID, MotorType.kBrushless);
    rightMotorPIDController = rightMotor.getPIDController();;
    rightMotorPIDController.setOutputRange(kMinOutput, kMaxOutput);
    // isMotorOn = false;
    stopMotor();
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
    double setPoint = 0;
    leftMotorPIDController.setReference(setPoint, ControlType.kVelocity);
    rightMotorPIDController.setReference(-setPoint, ControlType.kVelocity);
    // leftMotor.set(-speed);
    // rightMotor.set(speed);
    isMotorOn = true;
  }
  
  public void stopMotor() {
    leftMotorPIDController.setReference(0, ControlType.kVelocity);
    rightMotorPIDController.setReference(0, ControlType.kVelocity);
    // leftMotor.set(0);
    // rightMotor.set(0);
    isMotorOn = false;
  }
  
  public boolean isMotorOn() {
    return isMotorOn;
  }

  public void setPIDConstants(double kP, double kI, double kD, double kIz, double kFF, double rpm) {
    leftMotorPIDController.setP(kP);
    leftMotorPIDController.setI(kI);
    leftMotorPIDController.setD(kD);
    leftMotorPIDController.setIZone(kIz);
    leftMotorPIDController.setFF(kFF);
    rightMotorPIDController.setP(kP);
    rightMotorPIDController.setI(kI);
    rightMotorPIDController.setD(kD);
    rightMotorPIDController.setIZone(kIz);
    rightMotorPIDController.setFF(kFF);
    leftMotorPIDController.setReference(rpm, ControlType.kVelocity);
    rightMotorPIDController.setReference(-rpm, ControlType.kVelocity);
  }

  public void getMotorRPM() {
    SmartDashboard.putNumber("Left RPM", leftMotor.getEncoder().getVelocity());
    SmartDashboard.putNumber("Right PRM", rightMotor.getEncoder().getVelocity());
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
