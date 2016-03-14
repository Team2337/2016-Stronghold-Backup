package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class shooterRetractor_turnOnBrakeMode extends Command{

	
	
	public shooterRetractor_turnOnBrakeMode(){
		requires(Robot.shooterRetractor);
	}
	protected void initialize() {
		RobotMap.shooterRetractMotorA.enableBrakeMode(true);
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
