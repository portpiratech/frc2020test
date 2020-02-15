/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class GyroSubsystem extends SubsystemBase {
  /**
   * Creates a new GyroSubsystem.
   */
  ADXRS450_Gyro gyro;

  public GyroSubsystem() {
    gyro = new ADXRS450_Gyro();
  }
  // reads the gyro on the roborio
  public void readGyro() {
    double angle = gyro.getAngle();
    double rate = gyro.getRate();
    SmartDashboard.putNumber("angle", angle);
    SmartDashboard.putNumber("rate", rate);
  }
}
