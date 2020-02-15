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

public class ClimberCommand extends CommandBase {
  /**
   * Creates a new ClimberCommand.
   */
  private boolean up = true;
  private double speed = 0.5;

  public ClimberCommand() {
    addRequirements(Robot.climberSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //makes the motor spin forward until x is let go then the motor spins backward until x is let go
    if (up) {
      Robot.climberSubsystem.turn(speed);
    } else {
      Robot.climberSubsystem.turn(-speed);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.climberSubsystem.turn(0);
    up = !up;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return !OI.xButtonOperator.get();
  }
}
