package frc.robot.subsystems;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ToggleTwoSpeedSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void toggleTwoSpeed(){
    	if(Robot.twoSpeed == Robot.TwoSpeed.SecondDrive){
    		Robot.twoSpeed = Robot.TwoSpeed.FirstDrive;
    	}
    	else{
    		Robot.twoSpeed = Robot.TwoSpeed.SecondDrive;	
    	}
    }
}