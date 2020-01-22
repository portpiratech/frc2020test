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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class DriveTrainSubsystem extends SubsystemBase {
  private TalonSRX leftMotor;
  private TalonSRX rightMotor;
  private CANSparkMax leftMotor2;
  private CANSparkMax rightMotor2;
  private CANSparkMax leftMotor1;
  private CANSparkMax rightMotor1;
  public DriveTrainSubsystem(){
      leftMotor =  new TalonSRX(RobotMap.leftMotorID);
      rightMotor =  new TalonSRX(RobotMap.rightMotorID);
      leftMotor1 = new CANSparkMax(RobotMap.leftSparkMaxID1, MotorType.kBrushless);
      rightMotor1 = new CANSparkMax(RobotMap.rightSparkMaxID1, MotorType.kBrushless);
      leftMotor2 = new CANSparkMax(RobotMap.leftSparkMaxID2, MotorType.kBrushless);
      rightMotor2 = new CANSparkMax(RobotMap.rightSparkMaxID2, MotorType.kBrushless);
  }
  /*
  //@Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new DriveCommand());
  }
*/
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
      /*
      if(Robot.twoSpeed == Robot.TwoSpeed.SecondDrive)
    	{
        
    	}
    	else
    	{
        
      }*/
      if(Math.abs(leftSpeed) <= RobotMap.deadband){
        leftSpeed = 0;
      }
      if(Math.abs(rightSpeed) <= RobotMap.deadband){
        rightSpeed = 0;
      }
      //leftMotor.setInverted(true);
      leftMotor.set(ControlMode.PercentOutput, leftSpeed);
      rightMotor.set(ControlMode.PercentOutput, rightSpeed);    	
      //press right bumper for halfspeed
      leftMotor1.set(-leftSpeed);
      leftMotor2.set(-leftSpeed);
      rightMotor1.set(-rightSpeed);
      rightMotor2.set(-rightSpeed);
      SmartDashboard.putNumber("Left speed", leftSpeed);
      SmartDashboard.putNumber("Right speed", rightSpeed);
  }

  public void turn(double speed){
    leftMotor1.set(speed);
    leftMotor2.set(speed);
    rightMotor1.set(speed);
    rightMotor2.set(speed);
  }

  public void set(double left, double right){
    leftMotor1.set(left);
    leftMotor2.set(left);
    rightMotor1.set(-right);
    rightMotor2.set(-right);
  }
}

