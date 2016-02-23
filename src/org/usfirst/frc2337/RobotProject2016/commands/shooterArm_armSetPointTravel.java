package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class shooterArm_armSetPointTravel extends Command {

	
	public shooterArm_armSetPointTravel() {
		requires(Robot.shooterArmPID);
	}

	
	protected void initialize() {
		RobotMap.shooterArmOnTarget = false;
		Robot.shooterArmPID.setAbsoluteTolerance(.4);		
		Robot.shooterArmPID.setSetpoint(Robot.shooterArmPID.travel);
	}
	
	
	protected void execute() {
	}


	protected boolean isFinished() {
		return (Robot.shooterArmPID.onTarget());
	}


	protected void end() {	
		Robot.shooterArmPID.disable();
		RobotMap.travelMode = true;
		RobotMap.shooterArmOnTarget = true;
		Robot.shooterArmPID.setAbsoluteTolerance(.1);
		//Prevents joystick control from initializing setpoint and enabling PID.
		RobotMap.setPointSet = true;
	}

	
	protected void interrupted() {
		Robot.shooterArmPID.setAbsoluteTolerance(.1);
	}
}
