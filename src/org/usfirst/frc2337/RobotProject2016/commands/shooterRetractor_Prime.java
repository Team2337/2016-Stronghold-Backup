package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class shooterRetractor_Prime extends Command{

	private double m_deadBandPercent = 1.00 - Robot.shooterRetract.retractorDeadBand;
	
	public shooterRetractor_Prime(){
		requires(Robot.shooterRetract);
	}
	protected void initialize() {
		RobotMap.shooterRetractPrimed = false;
		Robot.shooterRetract.retractorPreppedPosition();
	}

	protected void execute() {

	}

	protected boolean isFinished() {
		if( Robot.shooterRetract.getRetractPosition() >  (Robot.shooterRetract.primedRetractorPosition * m_deadBandPercent) ) {
			RobotMap.shooterRetractPrimed = true;
				return true;
			} else {
				return false;
			}
	}

	protected void end() {
		
	}

	protected void interrupted() {
		
	}

}
