package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class shooterRetract_Prime extends Command{

	public shooterRetract_Prime(){
		requires(Robot.shooterRetractor);
	}
	protected void initialize() {
		RobotMap.shooterRetractMotorA.set(Robot.shooterRetractor.primedRetractorPosition);
		RobotMap.shooterRetractRetracted = false;
		setTimeout(1.5);
	}

	protected void execute() {

	}

	protected boolean isFinished() {
			//return (Robot.shooterRetractor.primedOnTarget() || isTimedOut());
		return (RobotMap.shooterRetractMotorA.isRevLimitSwitchClosed() || isTimedOut());
	}

	protected void end() {
		RobotMap.shooterRetractPrimed = true;
	}

	protected void interrupted() {
		
	}

}
