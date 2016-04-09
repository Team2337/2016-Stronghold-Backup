package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class intakeArm_armSetPointGround extends Command {
	
	
	
	public intakeArm_armSetPointGround() {
		requires(Robot.intakeArmPID);	
	}

	
	protected void initialize() {
		RobotMap.shooterArmOnTarget = false;
		setTimeout(2);
		Robot.intakeArmPID.setSetpoint(Robot.intakeArmPID.groundPosition);

	}
	
	
	protected void execute() {
	}


	protected boolean isFinished() {
		return (Robot.intakeArmPID.onTarget() || isTimedOut());
		//return isTimedOut();
	}


	protected void end() {
		RobotMap.shooterArmOnTarget = true;
	}

	
	protected void interrupted() {
	
	}

}
