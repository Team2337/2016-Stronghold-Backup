package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class scaler_Deactivate extends Command {

/**
 * pull out the pneumatic pin for the scaling arm
 */
	public scaler_Deactivate() {
		requires(Robot.scaler);
	}
	/**
	 * 
	 */
	protected void initialize() {
		Robot.scaler.pinIn();
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
