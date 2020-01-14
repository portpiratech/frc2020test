/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ColorSensorCommand;
import frc.robot.commands.PistonCommand;
import frc.robot.commands.ToggleDriveModeCommand;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
  public static XboxController driverController;
  public static XboxController operatorController;
  public static JoystickButton backButtonDriver;
  public static JoystickButton yButtonDriver;
  public static JoystickButton rightBumperDriver;
	public static JoystickButton yButtonOperator;
	public static JoystickButton xButtonOperator;
	public static JoystickButton aButtonOperator;
	public static JoystickButton bButtonOperator;
	public static JoystickButton backButtonOperator;
	public static JoystickButton startButtonOperator;
  public static JoystickButton leftBumperOperator;
  public static JoystickButton rightBumperOperator;
  public static JoystickButton aButtonDriver;
	public static JoystickButton bButtonDriver;
	
	public OI() {
		driverController = new XboxController(RobotMap.driverControllerId);
		operatorController = new XboxController(RobotMap.operatorControllerId);
		
		//name buttons to include which controller
    backButtonDriver = new JoystickButton(driverController, 7);
    yButtonDriver = new JoystickButton(driverController, 4);
    rightBumperDriver = new JoystickButton(driverController, 6);
		yButtonOperator = new JoystickButton(operatorController, 4);
		xButtonOperator = new JoystickButton(operatorController, 3);
		aButtonOperator = new JoystickButton(operatorController, 1);
		bButtonOperator = new JoystickButton(operatorController, 2);
		backButtonOperator = new JoystickButton(operatorController, 7);
    startButtonOperator = new JoystickButton(operatorController, 8);
    leftBumperOperator = new JoystickButton(operatorController, 5);
    rightBumperOperator = new JoystickButton(operatorController, 6);
    aButtonDriver = new JoystickButton(driverController, 1);
    bButtonDriver = new JoystickButton(driverController, 2);

    backButtonDriver.whenPressed(new ToggleDriveModeCommand());
    rightBumperDriver.whenPressed(new PistonCommand());

    yButtonDriver.whenPressed(new ColorSensorCommand());
  }
}
