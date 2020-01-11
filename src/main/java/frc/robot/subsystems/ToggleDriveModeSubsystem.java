package frc.robot.subsystems;
import frc.robot.Robot;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 *
 */
public class ToggleDriveModeSubsystem extends SubsystemBase {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public void toggleDriveMode(){
    	if(Robot.driveMode == Robot.DriveMode.TankDrive){
    		Robot.driveMode = Robot.DriveMode.ArcadeDrive;
    	}
    	else{
    		Robot.driveMode = Robot.DriveMode.TankDrive;	
    	}
    }
}