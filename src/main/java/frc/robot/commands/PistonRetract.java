
package frc.robot.commands;

import frc.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class PistonRetract extends Command {
	
	boolean finished = false;
	
    public PistonRetract() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.solenoid);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Set cannons to launch mode, extend piston, wait, retract, stop cannons
    	SmartDashboard.putString("In execute:","CannonPistonRetract");
    	
    	Robot.solenoid.retractLauncher();
    	Timer.delay(0.5);
    	
    	finished = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.solenoid.stopLauncher();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
