/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class ClimberSubsystem extends SubsystemBase {
  /**
   * Creates a new ClimberSubsystem.
   */
  private double speed = 0.3;
  private CANSparkMax motor;
  public ClimberSubsystem() {
    motor = new CANSparkMax(RobotMap.climbMotorID, MotorType.kBrushless);
  }

  public void stop(){
    motor.set(0);
  }

  public void turn(){
    motor.set(speed);
  }

  public void switchDirection(){
    speed = -speed;
  }
}
