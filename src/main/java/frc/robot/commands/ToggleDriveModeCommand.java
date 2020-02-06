/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class ToggleDriveModeCommand extends CommandBase {
	
	
  public ToggleDriveModeCommand() {
      // Use requires() here to declare subsystem dependencies
      addRequirements(Robot.driveTrainSubsystem);
  }

  // Called just before this Command runs the first time
  public void initialize() {
    
  }

  // Called repeatedly when this Command is scheduled to run
  public void execute() {
    Robot.driveTrainSubsystem.toggleDriveMode();
  }

  // Make this return true when this Command no longer needs to run execute()
  public boolean isFinished() {
      return true;
  }

  // Called once after isFinished returns true
  public void end(boolean interrupted) {
  }
}
