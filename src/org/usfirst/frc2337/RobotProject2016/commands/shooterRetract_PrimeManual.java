package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class shooterRetract_PrimeManual extends Command{

	public shooterRetract_PrimeManual(){
		requires(Robot.shooterRetractor);
	}
	protected void initialize() {
		setTimeout(4);
		Robot.shooter.shooterUnShoot();
		RobotMap.shooterRetractRetracted = false;
	
	}

	protected void execute() {
			Robot.shooterRetractor.unretracting();    //fix this name by switching in methods???
		
	}

	protected boolean isFinished() {
			return (isTimedOut() || Robot.shooterRetractor.onLimitSwitch()); 
	}

	protected void end() {
		Robot.shooterRetractor.stopMotors();
		if(Robot.shooterRetractor.onLimitSwitch()) {
			RobotMap.shooterRetractPrimed = true;
			Robot.shooterRetractor.resetEncoder();
			Robot.shooterRetractor.setRetractPosition(Robot.shooterRetractor.preppedRetractorPosition);
			RobotMap.shooterRetractRetracted = true;
		} else {
		Robot.shooterRetractor.setRetractPosition(Robot.shooterRetractor.getRetractPosition());
		RobotMap.shooterRetractPrimed = false;
		}
	}
	
	protected void interrupted() {
		this.end();
	}

}
