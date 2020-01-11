package frc.robot.subsystems;
import frc.robot.Robot;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 *
 */
public class ToggleTwoSpeedSubsystem extends SubsystemBase {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public void toggleTwoSpeed(){
    	if(Robot.twoSpeed == Robot.TwoSpeed.SecondDrive){
    		Robot.twoSpeed = Robot.TwoSpeed.FirstDrive;
    	}
    	else{
    		Robot.twoSpeed = Robot.TwoSpeed.SecondDrive;	
    	}
    }
}