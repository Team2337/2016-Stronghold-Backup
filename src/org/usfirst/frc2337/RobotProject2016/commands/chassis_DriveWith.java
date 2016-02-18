package org.usfirst.frc2337.RobotProject2016.commands;



import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

public class chassis_DriveWith extends Command {
	
	public double moveSpeed, speed, target, turnSpeed, yaw;
	public double deadband = 0.2;
	public int joystickAxis = 1;
	public double Kp = 0.05;

	public chassis_DriveWith() {
	    requires(Robot.chassisPID);
	}


	protected void initialize() {
    	RobotMap.gyro.reset();
    	target = RobotMap.gyro.getYaw();
	}

	protected void execute() {
		yaw = RobotMap.gyro.getAngle();
		
    	speed = Robot.oi.driverJoystick.getRawAxis(joystickAxis);
    	
		if (Robot.oi.driverJoystick.getRawAxis(joystickAxis) > deadband) {
			moveSpeed = speed;
		} else if (Robot.oi.driverJoystick.getRawAxis(joystickAxis) < -deadband) {
            moveSpeed = -speed;
        } else {
        	moveSpeed = 0;
        }
		
		RobotMap.chassisDrive.arcadeDrive(moveSpeed, yaw*Kp);
        SmartDashboard.putNumber("yaw4Nerds", yaw); 
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
