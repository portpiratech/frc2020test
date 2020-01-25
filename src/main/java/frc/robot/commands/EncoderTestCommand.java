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

public class EncoderTestCommand extends CommandBase {
  /**
   * Creates a new EncoderTest.
   */
  private int encoderCtsPerRev = 7;
  private int encoderQuadMode = 4;
  private int gearMotorRatio = 71;
  private int GearMotorCtsPerRev = encoderCtsPerRev * encoderQuadMode * gearMotorRatio;
  private int revolutions = 5;
  private int maxCount = GearMotorCtsPerRev * revolutions;

  private double speed = 0.3;
  private boolean finished = false;
  public EncoderTestCommand() {
    addRequirements(Robot.encoderTestSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    SmartDashboard.putNumber("Encoder Speed", speed);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.encoderTestSubsystem.move(speed);
    if(Robot.encoderTestSubsystem.output() >= maxCount || OI.startButtonDriver.get()){
      finished = true;
    }
    speed = SmartDashboard.getNumber("Encoder Speed", 0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.encoderTestSubsystem.move(0);
    Robot.encoderTestSubsystem.end();
    finished = false;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finished;
  }
}
