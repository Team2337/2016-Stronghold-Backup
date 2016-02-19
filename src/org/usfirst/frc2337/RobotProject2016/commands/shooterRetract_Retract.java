package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class shooterRetract_Retract extends Command{

	//public boolean shooterRetractPrimed;
	
	public shooterRetract_Retract(){
		requires(Robot.shooterRetract);
	}
	protected void initialize() {
		Robot.shooterRetract.setRetractPosition(Robot.shooterRetract.preppedRetractorPosition);
		}

	protected void execute() {

	}

	protected boolean isFinished() {
		return (Robot.shooterArmPID.onTarget());
}

	protected void end() {
		RobotMap.shooterRetractRetracted = true;   
	}

	protected void interrupted() {

	}

}
