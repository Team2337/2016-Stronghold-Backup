package org.usfirst.frc2337.RobotProject2016.commands;



import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

public class chassis_DriveWithGyroNoTurn extends Command {
	
	public double moveSpeed, speed, target, turnSpeed, yaw;
	public double deadband = 0.2;
	public int joystickAxis = 1;
	public double Kp = 0.05;

	public chassis_DriveWithGyroNoTurn() {
	    requires(Robot.chassisPID);
	}


	protected void initialize() {
    	RobotMap.gyro.reset();
    	target = RobotMap.gyro.getYaw();
	}

	protected void execute() {
		yaw = RobotMap.gyro.getYaw();
		
    	speed = Robot.oi.driverJoystick.getRawAxis(joystickAxis);
    	/*
		if (Robot.oi.driverJoystick.getRawAxis(joystickAxis) > deadband) {
			moveSpeed = -speed;
		} else if (Robot.oi.driverJoystick.getRawAxis(joystickAxis) < -deadband) {
            moveSpeed = speed;
        } else {
        	moveSpeed = 0;
        }
        */
    	moveSpeed = ((Math.abs(speed) > deadband) ? speed : 0);  //If the absolute speed of the joystick is outside of the deadband set the moveSpeed to speed otherwise set speed to zero.
		
		RobotMap.chassisDrive.arcadeDrive(moveSpeed, -yaw*Kp);
		//SmartDashboard.putNumber("drWGYNoTurn Speed", moveSpeed);
	    //SmartDashboard.putNumber("drWGYNoTurn", yaw*Kp); 
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	
	}

	protected void interrupted() {
		this.end();
	}

}
