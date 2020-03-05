package frc.robot.subsystems;

import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * The Piston subsystem incorporates two solenoids wired to the pneumatics
 * control module (PCM).
 */
public class SolenoidSubsystem extends SubsystemBase {

	private DoubleSolenoid leftSolenoid;
	private DoubleSolenoid rightSolenoid;

	public SolenoidSubsystem() {
		super();
		leftSolenoid = new DoubleSolenoid(RobotMap.PCM_ID, RobotMap.shifterSolenoidPort1Left,
				RobotMap.shifterSolenoidPort2Left);
		rightSolenoid = new DoubleSolenoid(RobotMap.PCM_ID, RobotMap.shifterSolenoidPort1Right,
				RobotMap.shifterSolenoidPort2Right);
	}

	/*
	 * public void initDefaultCommand() { //setDefaultCommand(new *);
	 * setDefaultCommand(new PistonStop()); }
	 */
	/**
	 * The log method puts interesting information to the SmartDashboard.
	 */
	// public void log() {
	// }

	// Cannon solenoid (Launcher)
	// Extends the piston.
	public void extendLauncher() {
		leftSolenoid.set(Value.kForward);
		rightSolenoid.set(Value.kForward);
	}
	// Retracts the piston.
	public void retractLauncher() {
		leftSolenoid.set(Value.kReverse);
		rightSolenoid.set(Value.kReverse);
	}
	// Stops the piston.
	public void stopLauncher() {
		leftSolenoid.set(Value.kOff);
		rightSolenoid.set(Value.kOff);
	}

	/*
	 * last year's code public void extendArms() { solenoid2.set(Value.kForward); }
	 * 
	 * public void retractArms() { solenoid2.set(Value.kReverse); }
	 * 
	 * public void stopArms() { solenoid2.set(Value.kOff); }
	 */
}
