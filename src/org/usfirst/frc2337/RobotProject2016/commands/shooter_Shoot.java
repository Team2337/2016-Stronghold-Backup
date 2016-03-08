package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class shooter_Shoot extends Command {

	public shooter_Shoot(){
		requires(Robot.shooter);
		
		
		
	}
	protected void initialize() {
		// Disengages the shooter pin
		/*
		if((Robot.intakeWrist.getIntakeWristStatus()) && (RobotMap.okToShoot) && (RobotMap.shooterRetractPrimed) && (RobotMap.shooterRetractRetracted)) {
			Robot.shooter.shooterShoot();
		}
		*/
		Robot.shooter.shooterShoot();            //   ****************************
	}


	protected void execute() {

	}


	protected boolean isFinished() {
		return true;
	}


	protected void end() {
		RobotMap.okToShoot = false;
		RobotMap.shooterRetractPrimed = false;
		Robot.shooter.shooterUnShoot();
		
	}


	protected void interrupted() {
		end();
		
	}

}
