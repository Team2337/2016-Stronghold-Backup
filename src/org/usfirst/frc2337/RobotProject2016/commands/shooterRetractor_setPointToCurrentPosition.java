package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class shooterRetractor_setPointToCurrentPosition extends Command{

	
	
	public shooterRetractor_setPointToCurrentPosition(){
		requires(Robot.shooterRetractor);
	}
	protected void initialize() {
		RobotMap.shooterRetractMotorA.set(RobotMap.shooterRetractMotorA.get());
		}

	protected void execute() {
	
	}

	protected boolean isFinished() {
		return true;
}

	protected void end() {  
	
	}

	protected void interrupted() {
		this.end();
	}

}
