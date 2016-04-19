package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

public class led_ledControl extends Command {
	
	private double shooterArmPotLightEngage;
	
	public led_ledControl() {
		requires(Robot.Led);
	}
	@Override
	protected void initialize() {
		Robot.Led.ledOn_GRIPCamera();
	}

	@Override
	protected void execute() {
		if (Robot.intake.getBallSensorState()) {
			Robot.Led.ballSensorLEDOn();
		} else {
			Robot.Led.ballSensorLEDOff();
		}
		/*
		if (RobotMap.linearAccElevatorSolenoidA.get()) {
			Robot.Led.lightOn();
		} else {
			Robot.Led.lightOff();
		}
		*/
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
