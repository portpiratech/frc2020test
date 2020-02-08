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

public class PUOBCommand extends CommandBase {
  /**
   * Creates a new PUOBCommand.
   */
  private double speed = 0.3;
  public PUOBCommand() {
    addRequirements(Robot.PUOBSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(OI.bButtonOperator.get()){
      Robot.PUOBSubsystem.turn(speed);
    }else if(OI.backButtonOperator.get()){
      Robot.PUOBSubsystem.turn(-speed);
    }else{
      Robot.PUOBSubsystem.turn(0);
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
