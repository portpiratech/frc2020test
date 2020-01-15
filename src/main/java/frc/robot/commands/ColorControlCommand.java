/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class ColorControlCommand extends CommandBase {
  public ColorControlCommand() {
    addRequirements(Robot.colorSensorSubsystem);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    String gameData;
    gameData = DriverStation.getInstance().getGameSpecificMessage();
    if(gameData.length() > 0)
    {
      switch (gameData.charAt(0))
      {
        case 'B' :
          SmartDashboard.putString("GameData", "B");
          break;
        case 'G' :
          SmartDashboard.putString("GameData", "G");
          break;
        case 'R' :
          SmartDashboard.putString("GameData", "R");
          break;
        case 'Y' :
          SmartDashboard.putString("GameData", "Y");
          break;
        default :
          //This is corrupt data
          break;
      }
    }
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return true;
  }

}
