/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.Timer;

public class ShooterPistonCommand extends CommandBase {
  /**
   * Creates a new ShooterPistonCommand.
   */
  public ShooterPistonCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (Robot.shooterSubsystem.isMotorOn()
      && Robot.cameraSubsystem.hasTarget()
      && Robot.cameraSubsystem.shotViable()
    ) {
      Robot.shooterSubsystem.retractLauncher();
      Timer.delay(1);
      Robot.shooterSubsystem.extendLauncher();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // Robot.shooterSubsystem.stopLauncher();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}