/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.Robot;

public class TurretCommand extends CommandBase {
  /**
   * Creates a new AimTurretCommand.
   */
  private double gainX = 0.005;
  private double maxSpeedturn = 0.1;
  private boolean finished = false;
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
    if(Robot.cameraSubsystem.hasTarget() > 0.5){
      double turnSpeed = Robot.cameraSubsystem.getXAngle() * gainX;
      if(turnSpeed > maxSpeedturn){
        turnSpeed = maxSpeedturn;
      }
      Robot.turretSubsystem.setXMotor(turnSpeed);
    }else{
      Robot.turretSubsystem.setXMotor(0);
    }
    if(OI.startButtonDriver.get()){
      finished = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finished;
  }
}
