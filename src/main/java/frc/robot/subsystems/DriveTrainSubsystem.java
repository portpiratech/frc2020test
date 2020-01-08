/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.DriveCommand;

/**
 * Add your docs here.
 */
public class DriveTrainSubsystem extends Subsystem {
  private TalonSRX leftMotor;
  private TalonSRX rightMotor;
  private CANSparkMax leftMotor2;
  private CANSparkMax rightMotor2;
  public DriveTrainSubsystem(){
      leftMotor =  new TalonSRX(RobotMap.leftMotorID);
      rightMotor =  new TalonSRX(RobotMap.rightMotorID);
      leftMotor2 = new CANSparkMax(RobotMap.leftSparkMaxID, MotorType.kBrushless);
      rightMotor2 = new CANSparkMax(RobotMap.rightSparkMaxID, MotorType.kBrushless);
  }

  //@Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new DriveCommand());
  }

  public void drive(){  
      double leftSpeed, rightSpeed;
    	
    	if(Robot.driveMode == Robot.DriveMode.ArcadeDrive)
    	{
        //arcade drive
    		double turnValue = OI.driverController.getX(Hand.kLeft);
        double throttleValue = OI.driverController.getY(Hand.kLeft);
        	
        	leftSpeed = ((turnValue-throttleValue)*RobotMap.driveSpeedMultiplier);
        	rightSpeed = ((turnValue+throttleValue)*RobotMap.driveSpeedMultiplier);
    	}
    	else
    	{
        //tank drive
    		double leftY = -OI.driverController.getY(Hand.kLeft);
        double rightY = OI.driverController.getY(Hand.kRight);
       /*if(leftY - rightY <= RobotMap.throttleTolerance || rightY - leftY <= RobotMap.throttleTolerance){
          leftY = rightY;
        }*/
        	leftSpeed = (leftY * RobotMap.driveSpeedMultiplier);
        	rightSpeed = (rightY * RobotMap.driveSpeedMultiplier);
      }
      
      if(Robot.twoSpeed == Robot.TwoSpeed.SecondDrive)
    	{
        
    	}
    	else
    	{
        
      }
      //leftMotor.setInverted(true);
      leftMotor.set(ControlMode.PercentOutput, leftSpeed);
      rightMotor.set(ControlMode.PercentOutput, rightSpeed);    	
    	//press right bumper for halfspeed
      leftMotor2.set(leftSpeed);
      rightMotor2.set(rightSpeed);
  }
}

