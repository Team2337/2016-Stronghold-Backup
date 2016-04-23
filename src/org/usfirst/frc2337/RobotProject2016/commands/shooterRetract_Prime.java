package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class shooterRetract_Prime extends Command{

	public shooterRetract_Prime(){
		requires(Robot.shooterRetractor);
	}
	protected void initialize() {
		//Robot.shooter.shooterUnShoot();
		Robot.shooterRetractor.retractorPrimedPosition();
		RobotMap.shooterRetractRetracted = false;
		setTimeout(3.0);
	}

	protected void execute() {

	}

	protected boolean isFinished() {
			//return (Robot.shooterRetractor.primedOnTarget() || isTimedOut());
		return (Robot.shooterRetractor.onLimitSwitch() || isTimedOut());
	}

	protected void end() {
		//RobotMap.shooterRetractPrimed = true;
		if(Robot.shooterRetractor.onLimitSwitch()) {
			RobotMap.shooterRetractPrimed = true;
		} else {
			RobotMap.shooterRetractPrimed = false;
		}
		Robot.shooter.shooterUnShoot();
		RobotMap.shooterRetractMotorA.disable();   ///  Testing on Can Drive day
	}

	protected void interrupted() {
		end();
	}

}
