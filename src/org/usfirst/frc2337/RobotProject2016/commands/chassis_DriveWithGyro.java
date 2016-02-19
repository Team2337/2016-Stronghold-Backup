// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2337.RobotProject2016.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc2337.RobotProject2016.RobotMap;
import org.usfirst.frc2337.RobotProject2016.Robot;

/**
 *
 */
public class chassis_DriveWithGyro extends Command {
	//Gyro Vars
	public double speed = 1.0/2;
	public double Kp = 0.05;
	public double target;
	public double turn;
	double leftJoystick;
	double rightJoystick;
	double turnJoystick;

    public chassis_DriveWithGyro() {
        requires(Robot.chassisPID);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.gyro.reset();
    	target = RobotMap.gyro.getYaw();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	leftJoystick = Robot.oi.driverJoystick.getRawAxis(1);
    	//rightJoystick =  Robot.oi.joystickMain.getRawAxis(5);
    	
    	turnJoystick =  Robot.oi.driverJoystick.getRawAxis(4);
    	
    	//speed = (leftJoystick + rightJoystick) / 2;
    	speed = leftJoystick;
    	target = target + ((turnJoystick)/3);
    	turn = (target - RobotMap.gyro.getYaw()) * Kp;
    	SmartDashboard.putNumber(   "speed-gyro",             speed);
    	SmartDashboard.putNumber(   "target-gyro",             target);
    	SmartDashboard.putNumber(   "turn-gyro",             turn);
    	RobotMap.chassisDrive.arcadeDrive(speed, turn);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}