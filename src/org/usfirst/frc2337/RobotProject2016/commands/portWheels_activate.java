package org.usfirst.frc2337.RobotProject2016.commands;



import org.usfirst.frc2337.RobotProject2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class portWheels_activate extends Command {
	
	public portWheels_activate() {
		requires (Robot.PortWheels);
	}

	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	protected void execute() {
		Robot.PortWheels.portWheelsActivate();
		
	}

	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
