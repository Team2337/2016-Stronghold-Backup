package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class intake_InhalePreLoad extends Command {
	private double m_timeout = 1.0;
	
	public intake_InhalePreLoad() {

	}
	
	public intake_InhalePreLoad(double timeout) {
		m_timeout = timeout;
	}
	

	protected void initialize() {
		setTimeout(m_timeout);
		
	}

	protected void execute() {
		Robot.intake.intakeInhaleOffGround();
	}


	protected boolean isFinished() {
		return isTimedOut();
	}


	protected void end() {
		
	}

	protected void interrupted() {
		
	}

}
