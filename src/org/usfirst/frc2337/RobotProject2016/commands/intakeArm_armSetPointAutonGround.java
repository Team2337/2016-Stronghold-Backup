package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class intakeArm_armSetPointAutonGround extends Command {
	
	
	
	public intakeArm_armSetPointAutonGround() {
		requires(Robot.intakeArmPID);	
	}

	
	protected void initialize() {
		RobotMap.shooterArmOnTarget = false;
		Robot.intakeArmPID.setSetpoint(Robot.intakeArmPID.groundPosition);
		setTimeout(10);
		if (!Robot.intakeArmPID.armPIDstatus) {
			Robot.intakeArmPID.enable();
		}
	}
	
	
	protected void execute() {
	}


	protected boolean isFinished() {
		//return (Robot.shooterArmPID.onTarget() || isTimedOut());
		return isTimedOut();
	}


	protected void end() {
		RobotMap.shooterArmOnTarget = true;
	}

	
	protected void interrupted() {
	
	}

}
