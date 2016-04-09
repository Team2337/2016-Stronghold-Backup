package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class intakeArm_armSetPointAutonTravel extends Command {

	
	public intakeArm_armSetPointAutonTravel() {
		requires(Robot.intakeArmPID);
	}

	
	protected void initialize() {
		RobotMap.shooterArmOnTarget = false;
		//Robot.shooterArmPID.setAbsoluteTolerance(.4);	
		setTimeout(2);
		Robot.intakeArmPID.setSetpoint(Robot.intakeArmPID.autontravel);
	}
	
	
	protected void execute() {
	}


	protected boolean isFinished() {
		return (Robot.intakeArmPID.onTarget() || isTimedOut());
	}


	protected void end() {	
		//Robot.shooterArmPID.disable();
		//RobotMap.travelMode = true;
		RobotMap.shooterArmOnTarget = true;
		//Robot.shooterArmPID.setAbsoluteTolerance(.1);
		//Prevents joystick control from initializing setpoint and enabling PID.
		//RobotMap.setPointSet = true;
	}

	
	protected void interrupted() {
		//Robot.shooterArmPID.setAbsoluteTolerance(.1);
	}
}
