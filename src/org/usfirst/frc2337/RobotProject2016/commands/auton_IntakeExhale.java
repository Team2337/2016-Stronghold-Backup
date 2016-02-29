package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class auton_IntakeExhale extends Command {

	double time;
	public auton_IntakeExhale(double limit) {
		requires(Robot.intake);
		time = limit;
	}
	
	protected void end() {
		// TODO Auto-generated method stub
		Robot.intake.stopMotors();
	}
	protected void execute() {
		// TODO Auto-generated method stub
		Robot.intake.intakeExhale();
	}

	protected void initialize() {
		// TODO Auto-generated method stub
		setTimeout(time);
	}

	protected void interrupted() {
		// TODO Auto-generated method stub
		this.end();
	}

	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return isTimedOut();
	}

}
