package frc.robot.commands;

import frc.robot.Robot;

import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 *
 */
public class PistonStop extends CommandBase {

    public PistonStop() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        addRequirements(Robot.solenoid);
    }

    // Called just before this Command runs the first time
    public void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    public void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    public boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    public void end(boolean interrupted) {
    }
}
