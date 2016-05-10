package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class shooterRetract_Prep extends Command{

	//public boolean shooterRetractPrimed;
	
	public shooterRetract_Prep(){
		requires(Robot.shooterRetractor);
	}
	protected void initialize() {
		RobotMap.shooterRetractMotorA.enable();
		Robot.shooterRetractor.setRetractPosition(Robot.shooterRetractor.preppedRetractorPosition);
		
		setTimeout(4);
		}

	protected void execute() {

	}

	protected boolean isFinished() {
		if (Robot.shooterRetractor.preppedOnTarget()) {
		   //System.out.println("on Target");
		}
		return (Robot.shooterRetractor.preppedOnTarget() || isTimedOut());
		
		//return false;
}

	protected void end() {
		//System.out.println("INIT**************************************************************");
		//System.out.println(timeSinceInitialized());
		//System.out.println("INIT**************************************************************");
		RobotMap.shooterRetractRetracted = true;   
		RobotMap.shooterRetractMotorA.disable();
	}

	protected void interrupted() {

	}

}
