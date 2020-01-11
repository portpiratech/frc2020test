
package frc.robot.commands;

import frc.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class PistonRetract extends CommandBase {
	
	boolean finished = false;
	
    public PistonRetract() {
        // Use requires() here to declare subsystem dependencies
        addRequirements(Robot.solenoid);
    }

    // Called just before this Command runs the first time
    public void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    public void execute() {
    	//Set cannons to launch mode, extend piston, wait, retract, stop cannons
    	SmartDashboard.putString("In execute:","CannonPistonRetract");
    	
    	Robot.solenoid.retractLauncher();
    	Timer.delay(0.5);
    	
    	finished = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    public boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    public void end(boolean interrupted) {
    	Robot.solenoid.stopLauncher();
    }
}
