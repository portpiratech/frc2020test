package frc.robot.subsystems;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ToggleDriveModeSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void toggleDriveMode(){
    	if(Robot.driveMode == Robot.DriveMode.TankDrive){
    		Robot.driveMode = Robot.DriveMode.ArcadeDrive;
    	}
    	else{
    		Robot.driveMode = Robot.DriveMode.TankDrive;	
    	}
    }
}