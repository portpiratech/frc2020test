/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class TurretCommand extends CommandBase {
  /**
   * Creates a new AimTurretCommand.
   */
  private double gainX = 0.15;
  private double maxSpeedX = 1;
  private double defaultXSpeed = 0.5;

  public TurretCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.turretSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // At the start the shooter move down to reset the encoder
    // Is the robot can see the target it will turn to face it and will aim
    // vertically, so the ball will make it into the goal.
    if (Robot.cameraSubsystem.hasTarget()) {
      // X movement
      double turnSpeedX = Robot.cameraSubsystem.getXAngle() * gainX;
      if (turnSpeedX > maxSpeedX) {
        turnSpeedX = maxSpeedX;
      }
      if (turnSpeedX < -maxSpeedX) {
        turnSpeedX = -maxSpeedX;
      }
      if (turnSpeedX > 0 && Robot.turretSubsystem.getForwardLimitSwitchX() == 0) {
        Robot.turretSubsystem.setXMotor(0);
      } else if (turnSpeedX < 0 && Robot.turretSubsystem.getReverseLimitSwitchX() == 0) {
        Robot.turretSubsystem.setXMotor(0);
      } else {
        Robot.turretSubsystem.setXMotor(turnSpeedX);
      }
    } else {
      // If there isn't a target the robot will search for it.
      Robot.turretSubsystem.setXMotor(defaultXSpeed);
    }
    if (defaultXSpeed > 0 && Robot.turretSubsystem.getForwardLimitSwitchX() == 0) {
      defaultXSpeed = -defaultXSpeed;
    }
    if (defaultXSpeed < 0 && Robot.turretSubsystem.getReverseLimitSwitchX() == 0) {
      defaultXSpeed = -defaultXSpeed;
    }
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
