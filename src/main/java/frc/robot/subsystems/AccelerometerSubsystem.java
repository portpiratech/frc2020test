/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class AccelerometerSubsystem extends SubsystemBase {
  /**
   * Creates a new AccelerometerSubsystem.
   */
  BuiltInAccelerometer accelerometer;
  public AccelerometerSubsystem() {
    accelerometer = new BuiltInAccelerometer();
  }

  public void readAccelerometer(){
    double x = accelerometer.getX();
    double y = accelerometer.getY();
    double z = accelerometer.getZ();
    SmartDashboard.putNumber("accelerometerX", x);
    SmartDashboard.putNumber("accelerometerY", y);
    SmartDashboard.putNumber("accelerometerZ", z);
  }
}
