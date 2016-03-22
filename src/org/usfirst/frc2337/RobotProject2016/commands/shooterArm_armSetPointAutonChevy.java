package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class shooterArm_armSetPointAutonChevy extends Command {
	
	
	
	public shooterArm_armSetPointAutonChevy() {
		requires(Robot.shooterArmPID);	
	}

	
	protected void initialize() {
		RobotMap.shooterArmOnTarget = false;
		Robot.shooterArmPID.setSetpoint(Robot.shooterArmPID.chevy);
		setTimeout(3);
		if (!Robot.shooterArmPID.armPIDstatus) {
			Robot.shooterArmPID.enable();
		}
	}
	
	
	protected void execute() {
	}


	protected boolean isFinished() {
		return (Robot.shooterArmPID.onTarget() || isTimedOut());
		
	}


	protected void end() {
		RobotMap.shooterArmOnTarget = true;
	}

	
	protected void interrupted() {
	
	}

}