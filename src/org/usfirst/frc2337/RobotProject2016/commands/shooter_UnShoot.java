package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class shooter_UnShoot extends Command {

	public shooter_UnShoot(){
		requires(Robot.shooter);
		
	
	}
	protected void initialize() {
	
		Robot.shooter.shooterShoot();           //   ****************************
	}


	protected void execute() {

	}


	protected boolean isFinished() {
		return true;
	}


	protected void end() {
		
	}


	protected void interrupted() {
		end();
		
	}

}
