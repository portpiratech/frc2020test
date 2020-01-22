/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class AimCameraCommand extends CommandBase {
  /**
   * Creates a new AimCameraCommand.
   */
  private double gainX = 0.005;
  private double minDistance = 5;
  private double gainDist = 0.01;
  private double maxSpeed = 0.2;
  public AimCameraCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.driveTrainSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //Robot.driveTrainSubsystem.turn(-Robot.cameraSubsystem.getXAngle() * gainX);
    if(Robot.cameraSubsystem.hasTarget() == 1){
      double left = -Robot.cameraSubsystem.getXAngle() * gainX;
      double right = Robot.cameraSubsystem.getXAngle() * gainX;
      double distance = Robot.cameraSubsystem.getDistance();
      if(distance > minDistance){
        left += (distance - minDistance) * gainDist;
        right += (distance - minDistance) * gainDist;
        if(left > maxSpeed){
          left = maxSpeed;
        }
        if(right > maxSpeed){
          right = maxSpeed;
        }
        Robot.driveTrainSubsystem.set(left, right);
      }else{
        Robot.driveTrainSubsystem.set(0, 0);
      }
    }else{
      Robot.driveTrainSubsystem.set(0, 0);
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
