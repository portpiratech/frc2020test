package frc.robot.subsystems;

import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


/**
 * The Piston subsystem incorporates two solenoids wired to the
 * pneumatics control module (PCM).
 */
public class SolenoidSubsystem extends SubsystemBase {
	
	private DoubleSolenoid cannonSolenoid;
	public double firingDelay = 0.5;
	
	public SolenoidSubsystem() {
		super();
		cannonSolenoid = new DoubleSolenoid(RobotMap.PCM_ID, RobotMap.solenoid_port1, RobotMap.solenoid_port2);
	}

/*
	public void initDefaultCommand() {
		//setDefaultCommand(new *);
		setDefaultCommand(new PistonStop());
	}
*/
	/**
	 * The log method puts interesting information to the SmartDashboard.
	 */
	public void log() {
	}
	
	// Cannon solenoid (Launcher)
	public void extendLauncher() {
		cannonSolenoid.set(Value.kForward);
	}
	
	public void retractLauncher(){
		cannonSolenoid.set(Value.kReverse);
	}
	
	public void stopLauncher() {
		cannonSolenoid.set(Value.kOff);
	}
	
	/* last year's code
	public void extendArms() {
		solenoid2.set(Value.kForward);
	}
	
	public void retractArms() {
		solenoid2.set(Value.kReverse);
	}
	
	public void stopArms() {
		solenoid2.set(Value.kOff);
	}
	*/
}
