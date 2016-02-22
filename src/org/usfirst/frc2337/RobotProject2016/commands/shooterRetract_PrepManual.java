package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class shooterRetract_PrepManual extends Command{

	//public boolean shooterRetractPrimed;
	
	public shooterRetract_PrepManual(){
		requires(Robot.shooterRetractor);
	}
	protected void initialize() {
		}

	protected void execute() {
		Robot.shooterRetractor.retracting();
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
