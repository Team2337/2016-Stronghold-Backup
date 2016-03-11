package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class portWheels_DoNothing extends Command {
	
	public portWheels_DoNothing() {
		requires (Robot.PortWheels);
	}

	protected void initialize() {
		// TODO Auto-generated method stub
		Robot.PortWheels.stopMotors();
	}

	protected void execute() {
		// TODO Auto-generated method stub
		
	}

	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

	protected void end() {
		// TODO Auto-generated method stub
		
	}

	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
