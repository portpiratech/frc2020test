/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.Robot;

public class ColorSensorCommand extends CommandBase {
  public ColorSensorCommand() {
    addRequirements(Robot.colorSensorSubsystem);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  private char tColor = ' ';
  private boolean finished = false;
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
          tColor = 'R';
          break;
        case 'G' :
          tColor = 'Y';
          break;
        case 'R' :
          tColor = 'B';
          break;
        case 'Y' :
          tColor = 'G';
          break;
        default :
          tColor = ' ';
          break;
      }
    }
    else
    {
      tColor = ' ';
    }
    Robot.encoderTestSubsystem.move(0.3);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    if (tColor == Robot.colorSensorSubsystem.getColors() || OI.startButtonDriver.get()){
      finished = true;
    }

  }
 
  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return finished;
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
    finished = false;
    Robot.encoderTestSubsystem.move(0);
  }
}
