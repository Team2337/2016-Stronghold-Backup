package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

public class PTO_Activate extends Command {

/**
 * pull out the pneumatic pin for the scaling arm
 */
	public PTO_Activate() {
		requires(Robot.powerTakeOff);
	}
	/**
	 * 
	 */
	protected void initialize() {
		//if (Robot.oi.getoperatorControls().getRawButton(10)) {
			if (RobotMap.powerTakeOffptoSolenoid.get() != DoubleSolenoid.Value.kForward) {
				Robot.powerTakeOff.LiftOn();
				}
		//}
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
