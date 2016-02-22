package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class shooterRetract_PrimeManual extends Command{

	public shooterRetract_PrimeManual(){
		requires(Robot.shooterRetractor);
	}
	protected void initialize() {
	
	}

	protected void execute() {
			Robot.shooterRetractor.unretracting();
		
	}

	protected boolean isFinished() {
			return false;
	}

	protected void end() {
		Robot.shooterRetractor.stopMotors();
	}

	protected void interrupted() {
		this.end();
	}

}