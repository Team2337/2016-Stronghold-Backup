package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class auton_SimpleReach extends Command {
	
    private int distance = -1000;    //TODO  need to determine encoder value
	private int time = 3;
	private double speed = 0.5;
	
	/**
	 * Drives a pre-set distance forward(+) or reverse(-) based on 'distance' set in code.
	 * Uses the left encoder to determine when 'target' distance has been reached.
	 * Uses gyro to drive straight. 
	 */
	public auton_SimpleReach()
	{
		requires(Robot.chassisPID);
	}
	
	protected void initialize() {
		Robot.chassisPID.resetDriveEncoder();
		Robot.chassisPID.resetGyro();
		//Robot.chassisPID.readLeftEncoder();
		//Robot.chassisPID.readRightEncoder();
		setTimeout(time);
	}


	protected void execute() {
	    double yaw = Robot.chassisPID.readGyroYaw();
		Robot.chassisPID.arcadeDrive(speed, -yaw);
	}

	
	protected boolean isFinished() {
		
		return (Robot.chassisPID.encoderOnTargetLeft(distance) || isTimedOut());
		
	}


	protected void end() {
		Robot.chassisPID.stopMotors();
	}

	
	protected void interrupted() {
		this.end();
	}

}
