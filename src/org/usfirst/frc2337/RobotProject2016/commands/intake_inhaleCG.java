package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class intake_inhaleCG extends CommandGroup {
	
	public intake_inhaleCG() {
		addSequential(new intake_InhalePreLoad(1.0));
		addSequential(new intake_Inhale());
	
	}

	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {
		
	}

	protected void interrupted() {
		Robot.intake.stopMotors();
	}
}
