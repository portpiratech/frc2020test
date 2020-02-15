/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.Robot;

public class TurretCommand extends CommandBase {
  /**
   * Creates a new AimTurretCommand.
   */
  private boolean init = true;
  private double initSpeedY = 0.2;

  // private double targetYAngle = 0;
  private double gainY = 1.5;
  private double maxSpeedY = 0.5;

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
    // SmartDashboard.putNumber("target y angle", targetYAngle / Math.PI * 180);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // At the start the shooter move down to reset the encoder
    if (init) {
      Robot.turretSubsystem.setYMotor(initSpeedY);
      if (Robot.turretSubsystem.getForwardLimitSwitchY() == 1) {
        Robot.turretSubsystem.resetEncoder();
        init = false;
      }
    } else {
      // Is the robot can see the target it will turn to face it and will aim vertically, so the ball will make it into the goal.
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
        // Y movement
        double targetYAngle;
        targetYAngle = Robot.cameraSubsystem.getTargetAngle();
        if(targetYAngle > Robot.cameraSubsystem.getMaxAngle()){
          targetYAngle = Robot.cameraSubsystem.getMaxAngle();
        }
        if(targetYAngle < Robot.cameraSubsystem.getMinAngle()){
          targetYAngle = Robot.cameraSubsystem.getMinAngle();
        }
        SmartDashboard.putNumber("angle Y", Robot.turretSubsystem.getYAngle());
        SmartDashboard.putNumber("targetAngle", targetYAngle);
        double turnSpeedY = (-Robot.turretSubsystem.getYAngle() - targetYAngle) * gainY;
        if (turnSpeedY > maxSpeedY) {
          turnSpeedY = maxSpeedY;
        } else if (turnSpeedY < -maxSpeedY) {
          turnSpeedY = -maxSpeedY;
        }
        SmartDashboard.putNumber("Turn Speed Y", turnSpeedY);
        if (turnSpeedY > 0 && Robot.turretSubsystem.getForwardLimitSwitchY() == 1) {
          Robot.turretSubsystem.setYMotor(0);
        } else if (turnSpeedY < 0 && Robot.turretSubsystem.getReverseLimitSwitchY() == 1) {
          Robot.turretSubsystem.setYMotor(0);
        } else {
          Robot.turretSubsystem.setYMotor(turnSpeedY);
        }
      } else{
        // If there isn't a target the robot will search for it.
        Robot.turretSubsystem.setXMotor(defaultXSpeed);
      }
      if (defaultXSpeed > 0 && Robot.turretSubsystem.getForwardLimitSwitchX() == 0) {
        defaultXSpeed = -defaultXSpeed;
      }
      if (defaultXSpeed < 0 && Robot.turretSubsystem.getReverseLimitSwitchX() == 0) {
        defaultXSpeed = -defaultXSpeed;
      }
      Robot.turretSubsystem.getForwardLimitSwitchY();
      Robot.turretSubsystem.getReverseLimitSwitchY();
      // targetYAngle = SmartDashboard.getNumber("target y angle", targetYAngle /
      // Math.PI * 180) * Math.PI / 180;
    }
    if (OI.startButtonOperator.get()) {
      init = true;
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
