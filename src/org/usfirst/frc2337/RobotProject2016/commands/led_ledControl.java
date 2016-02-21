package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class led_ledControl extends Command {
	
	private double shooterArmPotLightEngage;
	
	public led_ledControl() {
		requires(Robot.Led);
	}
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		shooterArmPotLightEngage = Robot.shooterArmPID.layupShot *.9;
	}

	@Override
	protected void execute() {
		if (RobotMap.gotBallSensorState) {
			Robot.Led.gotBallOn();
		} else {
			Robot.Led.gotBallOff();
		}
		
		if (RobotMap.shooterArmPIDshooterArmPot.get() > shooterArmPotLightEngage) {
			Robot.Led.lightOn();
			Robot.Led.ledOn_GRIPCamera();
		} else {
			Robot.Led.lightOff();
			Robot.Led.ledOff_GRIPCamera();
		}
		
		
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
	

}
