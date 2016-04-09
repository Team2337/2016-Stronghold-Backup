package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class shooterRetract_Mid extends Command{

	//public boolean shooterRetractPrimed;
	
	public shooterRetract_Mid(){
		requires(Robot.shooterRetractor);
	}
	protected void initialize() {
		Robot.shooterRetractor.setRetractPosition(Robot.shooterRetractor.midRetractorPosition);
		setTimeout(2.0);
		}

	protected void execute() {

	}

	protected boolean isFinished() {
		return (Robot.shooterRetractor.midOnTarget() || isTimedOut());
}

	protected void end() {
		 
	}

	protected void interrupted() {

	}

}
