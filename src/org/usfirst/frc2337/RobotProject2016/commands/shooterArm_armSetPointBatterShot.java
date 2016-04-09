package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class shooterArm_armSetPointBatterShot extends Command {
	
	
	
	public shooterArm_armSetPointBatterShot() {
		requires(Robot.shooterArmPID);	
	}

	
	protected void initialize() {
		RobotMap.shooterArmOnTarget = false;
		Robot.shooterArmPID.setSetpoint(Robot.shooterArmPID.battershot);
		setTimeout(2);
		if (!Robot.shooterArmPID.armPIDstatus) {
			Robot.shooterArmPID.enable();
		}
	}
	
	
	protected void execute() {
	}


	protected boolean isFinished() {
		return (Robot.shooterArmPID.onTarget() || isTimedOut());
		//return isTimedOut();
	}


	protected void end() {
		RobotMap.shooterArmOnTarget = true;
	}

	
	protected void interrupted() {
	
	}

}
