package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class target_LightDeactivate extends Command {

	public target_LightDeactivate(){
		requires(Robot.Led);
	}
	protected void initialize() {
		// TODO Auto-generated method stub
		Robot.Led.lightOff();
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
		this.end();
	}

}
