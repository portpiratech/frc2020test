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

public class RotationControlCommand extends CommandBase {
  /**
   * Creates a new RotationControlCommand.
   */
  private int count;
  private boolean finished;
  private String lastColor;
  public RotationControlCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //Robot.colorSensorSubsystem.rotatePanelInit();
    lastColor = Robot.colorSensorSubsystem.getColors();
    count = 0;
    finished = false;
    SmartDashboard.putString("Done", "");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    String color = Robot.colorSensorSubsystem.getColors();
    if(color != lastColor){
      count++;
      lastColor = color;
    }
    SmartDashboard.putNumber("count", count);
    if(count >= 32 || OI.bButtonDriver.get() == true){
      finished = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    SmartDashboard.putString("Done", "Done");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finished;
  }
}
