/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class ShooterDefaultCommand extends CommandBase {
  /**
   * Creates a new ShooterDefaultCommand.
   */
  public ShooterDefaultCommand() {
    addRequirements(Robot.shooterSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    SmartDashboard.putNumber("kP", 0);
    SmartDashboard.putNumber("kI", 0);
    SmartDashboard.putNumber("kD", 0);
    SmartDashboard.putNumber("kIz", 0);
    SmartDashboard.putNumber("kFF", 0);
    SmartDashboard.putNumber("rpm", 0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double kP = SmartDashboard.getNumber("kP", 0);
    double kI = SmartDashboard.getNumber("kI", 0);
    double kD = SmartDashboard.getNumber("kD", 0);
    double kIz = SmartDashboard.getNumber("kIz", 0);
    double kFF = SmartDashboard.getNumber("kFF", 0);
    double rpm = SmartDashboard.getNumber("rpm", 0);
    Robot.shooterSubsystem.setPIDConstants(kP, kI, kD, kIz, kFF, rpm);
    Robot.shooterSubsystem.getMotorRPM();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
