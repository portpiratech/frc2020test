/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

//import com.ctre.phoenix.motorcontrol.ControlMode;
//import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * Add your docs here.
 */


public class CameraSubsystem extends SubsystemBase {

    NetworkTable table;
    private double cameraAngle = 0;
    private double targetHeight = 58.5/12.0;
    private double cameraHeight = 26/12.0;
    public CameraSubsystem() {
        table = NetworkTableInstance.getDefault().getTable("limelight");
    }

    public void outputToSmartDashboard() {
        NetworkTableEntry tv = table.getEntry("tv");
        NetworkTableEntry tx = table.getEntry("tx");
        NetworkTableEntry ty = table.getEntry("ty");
        NetworkTableEntry ta = table.getEntry("ta");

        double v = tv.getDouble(0.0);
        double x = tx.getDouble(0.0);
        double y = ty.getDouble(0.0);
        double area = ta.getDouble(0.0);

        SmartDashboard.putNumber("Has Target", v);
        SmartDashboard.putNumber("Degrees from target (X)", x);
        SmartDashboard.putNumber("Degrees from target (Y)", y);
        SmartDashboard.putNumber("Percentage of target", area);
    }

    public void setCamMode(int mode){
        NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(mode);
    }

    public double hasTarget(){
        NetworkTableEntry tv = table.getEntry("tv");
        double v = tv.getDouble(0.0);
        return v;
    }

    public double getXAngle(){
        NetworkTableEntry tx = table.getEntry("tx");
        double x = tx.getDouble(0.0);
        return x;
    }

    public double getYAngle(){
        NetworkTableEntry ty = table.getEntry("ty");
        double y = ty.getDouble(0.0);
        return y;
    }

    public double getDistance(){
        double angle = Math.toRadians(cameraAngle + getYAngle());
        double heightChange = targetHeight - cameraHeight;
        double distance = heightChange / (Math.tan(angle));
        SmartDashboard.putNumber("Distance", distance);
        return distance;
    }
}
