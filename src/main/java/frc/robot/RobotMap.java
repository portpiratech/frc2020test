/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  public static int driverControllerId = 0;
  public static int operatorControllerId = 1;
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
  public static double driveSpeedMultiplier = 0.6;
  public static double deadband = 0.05;
  public static int leftSparkMaxID1 = 3;
  public static int rightSparkMaxID1 = 5;
  public static int leftSparkMaxID2 = 4;
  public static int rightSparkMaxID2 = 6;
  public static int leftMotorID = 33;// 9;
  public static int rightMotorID = 4798367;// 12;

  public static final int PCM_ID = 1; // Compressor/Pneumatics Control Module (used for DoubleSolenoids)
  public static int shifterSolenoidPort1 = 3; // DoubleSolenoid
  public static int shifterSolenoidPort2 = 4; // DoubleSolenoid

  public static int turretXMotorID = 10;
  public static int turretYMotorID = 11;
  public static double velocity = 13.4;

  public static int PUOBMotorID = 9;

  public static int climbMotorID = 34;

  public static int SPIFFYSolenoidPort1 = 2;
  public static int SPIFFYSolenoidPort2 = 1;
  public static int SPIFFYLeftMotorID = 10;
  public static int SPIFFYRightMotorID = 9;
}