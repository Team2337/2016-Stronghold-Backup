package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class auton_TurnAngle extends Command {

	double turnSpeed = 0.5;
	double speed;
	double angle;
	
	public auton_TurnAngle(double turn) {
		requires(Robot.chassisPID);
		angle = turn;
	}
	
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	
	protected void execute() {
		// TODO Auto-generated method stub
		double lessAngle = angle - 2;
		double moreAngle = angle + 2;
		if (angle > 0)
		{
			turnSpeed = ((Math.abs(angle) - Math.abs(Robot.chassisPID.readGyroYaw())) * 0.013) + 0.2;
			System.out.println("RIGHT");
			if (Robot.chassisPID.readGyroYaw() < lessAngle) {
				Robot.chassisPID.arcadeDrive(0, turnSpeed);
			} else if (Robot.chassisPID.readGyroYaw() > moreAngle) {
				Robot.chassisPID.arcadeDrive(0, -turnSpeed);
			} else {
				Robot.chassisPID.stopMotors();
			}
			
		} else {
			System.out.println("LEFT");
			turnSpeed = ((angle - Robot.chassisPID.readGyroYaw()) * 0.013) - 0.2;
			if (Robot.chassisPID.readGyroYaw() > moreAngle) {
				Robot.chassisPID.arcadeDrive(0, turnSpeed);
			} else if (Robot.chassisPID.readGyroYaw() < lessAngle) {
				Robot.chassisPID.arcadeDrive(0, -turnSpeed);
			} else {
				Robot.chassisPID.stopMotors();
			} 
		}
	}

	
	protected void initialize() {
		// TODO Auto-generated method stub
		Robot.chassisPID.resetGyro();
		double timeAngle = Math.abs(angle);
		setTimeout(timeAngle * 0.02);
		if (angle > 0) {
			turnSpeed = 0.5;
		} else {
			turnSpeed = -0.5;
		}
			
	}

	
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

	
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		double lessAngle = angle - 0.5;
		double moreAngle = angle + 0.5;
		if (angle > 0)
		{
			return (Robot.chassisPID.readGyroYaw() > lessAngle && isTimedOut());
		} else {
			return (Robot.chassisPID.readGyroYaw() < moreAngle && isTimedOut());
		}
		
	}

}
