package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class shooterRetractor_Prime extends Command{

	public shooterRetractor_Prime(){
		requires(Robot.shooterRetract);
	}
	protected void initialize() {
		Robot.shooterRetract.retractorPreppedPosition();
		RobotMap.shooterRetractRetracted = false;
	}

	protected void execute() {

	}

	protected boolean isFinished() {
			return (Robot.shooterArmPID.onTarget());
	}

	protected void end() {
		RobotMap.shooterRetractPrimed = true;
	}

	protected void interrupted() {
		
	}

}
