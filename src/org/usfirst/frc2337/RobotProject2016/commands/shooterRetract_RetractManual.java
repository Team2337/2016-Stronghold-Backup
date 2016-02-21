package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class shooterRetract_RetractManual extends Command{

	//public boolean shooterRetractPrimed;
	
	public shooterRetract_RetractManual(){
		requires(Robot.shooterRetract);
	}
	protected void initialize() {
		}

	protected void execute() {
		Robot.shooterRetract.retracting();
	}

	protected boolean isFinished() {
		return true;
}

	protected void end() {  
		Robot.shooterRetract.stopMotors();
	}

	protected void interrupted() {
		this.end();
	}

}
