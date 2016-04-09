package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class intakeArm_armSetPointShortShot extends Command {

	
	public intakeArm_armSetPointShortShot() {
		requires(Robot.intakeArmPID);
	}

	
	protected void initialize() {
		RobotMap.shooterArmOnTarget = false;
		setTimeout(2);
		Robot.intakeArmPID.setSetpoint(Robot.intakeArmPID.layupShot);
		if (!Robot.intakeArmPID.armPIDstatus) {
			Robot.intakeArmPID.enable();
		}
	}
	
	
	protected void execute() {
	}

	
	protected boolean isFinished() {
		return (Robot.intakeArmPID.onTarget() || isTimedOut());
	}

	
	protected void end() {	
		RobotMap.shooterArmOnTarget = true;
	}

	
	protected void interrupted() {
		
	}
}
